package com.blckclov3r.cebu_mproject.mRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mDatabase.DBHelper;
import com.blckclov3r.cebu_mproject.mFragment.jeep_fragment;
import com.blckclov3r.cebu_mproject.mMisc.dbKey;
import spencerstudios.com.bungeelib.Bungee;
/**
 * Created by Abrenica, Aljun
 */
public class JeepAdapter extends RecyclerView.Adapter<JeepAdapter.JeepViewHolder> {
    static Context mContext;
    private Cursor mCursor;
    private OnItemClickListener mListener;
    private static final String TAG = JeepAdapter.class.getSimpleName();
    private static final String COMMON_TAG = "acinerba_nujla";
    static jeep_fragment jf;
    public static String textCode;
    public static int id = -1;
    public static String code = "";
    public interface OnItemClickListener {
        void onItemClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public JeepAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public static class JeepViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_code;
        public TextView textView_goto;
        public LinearLayout jeep_itemLayout;


        public JeepViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            textView_code = (TextView) itemView.findViewById(R.id.textView_code);
            textView_goto = (TextView) itemView.findViewById(R.id.textView_goto);
            jeep_itemLayout = (LinearLayout) itemView.findViewById(R.id.jeep_itemLayout);
            jf = new jeep_fragment();
            if (jf.dState) {
                textView_goto.setTextColor(Color.rgb(255, 255, 255));
                textView_code.setTextColor(Color.rgb(255, 255, 255));
                jeep_itemLayout.setBackgroundColor(Color.rgb(33, 33, 33));

            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    if (listener != null) {
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                            Log.d(COMMON_TAG, TAG + ", position != RecyclerView.NOPOSITION");
                        }
                    }else{
                        textCode = textView_code.getText().toString();
                        DBHelper dbHelper = new DBHelper(mContext);
                        Cursor c = dbHelper.getData(String.valueOf(JeepAdapter.textCode));
                        if (c.moveToFirst()) {
                            do {
                                id = c.getInt(0);
                                code = c.getString(1);
                            } while (c.moveToNext());
                        }
                        String jcode = "";
                        String jdesc = "";
                        Cursor cursor = dbHelper.getPositionId(id);
                        if(cursor.moveToFirst()){
                            do{
                                jcode = cursor.getString(1);
                                jdesc = cursor.getString(2);
                            }while (cursor.moveToNext());
                        }
                        cursor.close();
                        Intent intent = new Intent(mContext,JeepInfo.class);
                        intent.putExtra("code",jcode);
                        intent.putExtra("desc",jdesc);
                        mContext.startActivity(intent);
                        Bungee.slideUp(mContext);
                    }
                }
            });
        }
    }


    @Override
    public JeepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.jeep_item, parent, false);
        return new JeepViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(JeepViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
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
