package com.example.toki.checkbox_home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLInput;

/**
 * Created by toki on 2017/12/05.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(Context context) {
        super(context, "mac", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table toki(_id integer primary key autoincrement,name varchar(20),count integer,time varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        this.onCreate(sqLiteDatabase);
    }

    public void insert(String n, long c,String t) {
        sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",n);
        contentValues.put("time",t);
        contentValues.put("count",c);
        sqLiteDatabase.insert("toki",null,contentValues);
    }
    public Cursor show(){
        sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from toki order by count asc",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            return cursor;
        }
        cursor.close();
        return cursor;
    }
//    public void erase(){
//        sqLiteDatabase=this.getWritableDatabase();
//        sqLiteDatabase.delete("toki","name=?",new String[] {"00:00.00"});
//        sqLiteDatabase.delete("toki","time=?",new String[]{"00:00.12"});
//        sqLiteDatabase.delete("toki","time=?",new String[]{"00:00.25"});
//    }

}