package com.blckclov3r.cebu_mproject.mDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.blckclov3r.cebu_mproject.mMisc.dbKey;
import com.blckclov3r.cebu_mproject.mModel.Jeepcode;

/**
 * Created by Abrenica, Aljun
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = DBHelper.class.getSimpleName();
    private static final String COMMON_TAG = "acinerba_nujla";
    private static final String JEEP_CODE = "CREATE TABLE "+dbKey.TABLENAME+" ("
            +dbKey._ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
            +dbKey.JEEPCODE+" TEXT NOT NULL,"
            +dbKey.JEEPDESC+" TEXT NOT NULL,"
            +dbKey.JEEPTOGO+" TEXT "
            +");";


    public DBHelper(Context context) {
        super(context, dbKey.DBNAME, null, dbKey.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            Log.d(COMMON_TAG,TAG+"DBHelper onCreate try block");
            sqLiteDatabase.execSQL(JEEP_CODE);
        }catch (SQLiteException e){
            Log.d(COMMON_TAG,TAG+"DBHelper OnCreate: SQLiteException: "+e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+dbKey.DBNAME);
        onCreate(sqLiteDatabase);
    }

    public boolean jeepCodeData(Jeepcode code){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        db.beginTransaction();
        try{
            cv.put(dbKey.JEEPCODE,code.getCode());
            cv.put(dbKey.JEEPDESC,code.getDesc());
            cv.put(dbKey.JEEPTOGO,code.getTogo());
            long result = db.insert(dbKey.TABLENAME,dbKey._ID,cv);
            db.setTransactionSuccessful();
            if(result > 0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            db.close();
            return false;
        }finally {
            db.endTransaction();
            db.close();
        }
    }

    public Cursor getAllItems(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+dbKey.TABLENAME;
        return db.rawQuery(query,null);
    }

    public Cursor getAllItemText(String s){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+dbKey.TABLENAME+" WHERE "+dbKey.JEEPCODE+" LIKE '%"+String.valueOf(s)+"%'";
        return db.rawQuery(query,null);
    }

    public void deleteList(){
        SQLiteDatabase db  = this.getWritableDatabase();
        db.execSQL("DROP TABLE "+dbKey.TABLENAME);
        onCreate(db);
    }

    public Cursor getPositionId(int pos){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+dbKey.TABLENAME+" WHERE "+dbKey._ID+" = '"+pos+"'";
        Cursor data =  db.rawQuery(query,null);
        return data;
    }

    public Cursor getSearchText(String search){

        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {dbKey._ID,dbKey.JEEPCODE,dbKey.JEEPTOGO};
        Cursor cursor = null;
        if(search!=null && search.length()>0){
            String sql = "SELECT * FROM "+dbKey.TABLENAME+" WHERE "+dbKey.JEEPCODE+" LIKE '"+search+"%'";
            cursor = db.rawQuery(sql,null);
            return cursor;
        }
        cursor = db.query(dbKey.TABLENAME,columns,dbKey._ID,null,null,null,null);
        return cursor;
    }

    public Cursor getData(String s){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM "+dbKey.TABLENAME+" WHERE "+dbKey.JEEPCODE+" = '"+s+"'";
        return db.rawQuery(sql,null);
    }

}
