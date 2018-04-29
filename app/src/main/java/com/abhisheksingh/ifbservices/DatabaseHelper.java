package com.abhisheksingh.ifbservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhishek Singh on 26-04-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Login.db";
    public static final String TABLE_NAME="employee_login_table";
    public static final String COL_1="SNO";
    public static final String COL_2="NAME";
    public static final String COL_3="USERNAME";
    public static final String COL_4="PASSWORD";
    public static final String COL_5="STATUS";

    //Create database (Constructor)
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE if not exists "+TABLE_NAME+"(SNO INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,USERNAME TEXT,PASSWORD BLOB,STATUS TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name,String username,String password,String status){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,username);
        contentValues.put(COL_4,password);
        contentValues.put(COL_5,status);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
}
