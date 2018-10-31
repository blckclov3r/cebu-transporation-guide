package com.blckclov3r.cebu_mproject.mFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mDatabase.DBHelper;
import com.blckclov3r.cebu_mproject.mMainActivity.MainActivity;
import com.blckclov3r.cebu_mproject.mModel.Jeepcode;
import com.blckclov3r.cebu_mproject.mRecyclerView.JeepAdapter;
import com.blckclov3r.cebu_mproject.mRecyclerView.JeepInfo;
import java.util.ArrayList;
import java.util.List;
import in.codeshuffle.typewriterview.TypeWriterView;
import spencerstudios.com.bungeelib.Bungee;

import static android.content.Context.MODE_PRIVATE;

/**
 * Abrenica, Aljun
 */

public class jeep_fragment extends Fragment {

    private JeepAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private DBHelper dbHelper;
    private SharedPreferences sharedPreferences;
    public static boolean dState = false;
    TypeWriterView tv_title;
    LinearLayout head_,bg_layout;
    SearchView searchView;
    List<Jeepcode> listCode;
    public interface mListener{
        void sendInfo(String code,String desc);
    }
    private mListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jeep_fragment,container,false);
        searchView = (SearchView)  view.findViewById(R.id.searchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dbHelper = new DBHelper(getActivity());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listCode = new ArrayList<>();
        mAdapter = new JeepAdapter(getActivity(),dbHelper.getAllItems());

        sharedPreferences = this.getActivity().getSharedPreferences(option_fragment.MY_PREF, MODE_PRIVATE);
        dState = sharedPreferences.getBoolean(option_fragment.BACKGROUNDTHEME,false);
        tv_title = (TypeWriterView) view.findViewById(R.id.tv_title);
        head_ = (LinearLayout) view.findViewById(R.id.head_);
        bg_layout = (LinearLayout) view.findViewById(R.id.bg_layout);

        if(dState){
            mRecyclerView.setBackgroundColor(getResources().getColor(R.color.black));
            head_.setBackgroundColor(Color.rgb(77,77,77));
            bg_layout.setBackgroundColor(getResources().getColor(R.color.black));
            tv_title.setTextColor(getResources().getColor(R.color.whiteSmoke));
//            jeep_itemLayout.setBackground(getResources().getDrawable(R.drawable.recycler_item_black));
        }else{
            mRecyclerView.setBackgroundColor(getResources().getColor(R.color.gray));
        }
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        tv_title.setWithMusic(false);
        tv_title.animateText("Jeep Codes");
        tv_title.setDelay(50);

        adapterClicked();
    }

    private void adapterClicked(){
        mAdapter.setOnItemClickListener(new JeepAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String jcode = "";
                String jdesc = "";
                Cursor cursor = dbHelper.getPositionId(position+1);
                if(cursor.moveToFirst()){
                    do{
                        jcode = cursor.getString(1);
                        jdesc = cursor.getString(2);
                    }while (cursor.moveToNext());
                }
                cursor.close();
                dbHelper.close();
                listener.sendInfo(jcode,jdesc);
                Intent intent = new Intent(getActivity(),JeepInfo.class);
//                intent.putExtra("code",jcode);
//                intent.putExtra("desc",jdesc);
                getActivity().startActivity(intent);
                Bungee.slideUp(getActivity());
            }

        });
    }

    public void getJeepCode(String searchTerm){
        mAdapter = new JeepAdapter(getActivity(),dbHelper.getAllItemText(searchTerm));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getJeepCode(newText);
                return false;
            }
        });
    }



    public void Toast(String s){
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (mListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(e.toString()+" must implements mListener");
        }
    }
}
