package com.blckclov3r.cebu_mproject.mRecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mFragment.jeep_fragment;
import com.blckclov3r.cebu_mproject.mMisc.dbKey;
import com.blckclov3r.cebu_mproject.mSplashscreen.SplashScreen;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

import org.w3c.dom.Text;

/**
 * Created by admin on 8/11/2018.
 */

public class JeepAdapter extends RecyclerView.Adapter<JeepAdapter.JeepViewHolder> {
    private Context mContext;
    private Cursor mCursor;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public JeepAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor = cursor;
    }
    static jeep_fragment jf;
    public static class JeepViewHolder extends RecyclerView.ViewHolder{
        public TextView textView_code;
        public TextView textView_goto;
        public LinearLayout jeep_itemLayout;
        public JeepViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            textView_code = (TextView) itemView.findViewById(R.id.textView_code);
            textView_goto = (TextView) itemView.findViewById(R.id.textView_goto);
            jeep_itemLayout = (LinearLayout) itemView.findViewById(R.id.jeep_itemLayout);
            jf = new jeep_fragment();
            if(jf.dState){
                textView_goto.setTextColor(Color.rgb(255,255,255));
                textView_code.setTextColor(Color.rgb(255,255,255));
                jeep_itemLayout.setBackgroundColor(Color.rgb(33,33,33));

            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @Override
    public JeepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.jeep_item,parent,false);
        return new JeepViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(JeepViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position)){
           return;
        }
        String jeepCode = mCursor.getString(mCursor.getColumnIndex(dbKey.JEEPCODE));
        String jeepGoto = mCursor.getString(mCursor.getColumnIndex(dbKey.JEEPTOGO));
        holder.textView_code.setText(jeepCode);
        holder.textView_goto.setText(jeepGoto);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }


}
