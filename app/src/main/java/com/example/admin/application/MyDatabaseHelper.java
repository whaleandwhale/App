package com.example.admin.application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MyDatabaseHelper extends SQLiteOpenHelper {
    /**
     *
     */
    public static final String CREATE_ACCOUNT = "create table Account ("
            +"id integer primary key autoincrement,"
            +"name text,"
            +"password text,"
            +"shop_name text,"
            +"photo_shop text)";
    public static final String CREATE_SHOP ="create table Shop("
            +"id integer primary key autoincrement,"
            +"shop_name text,"
            +"dishes_name text,"
            +"price real,"
            +"photo_dishes text)";
    public static final String CREATE_ORDERS="create table Orders("
            +"id integer primary key autoincrement,"
            +"shop_name text,"
            +"photo_shop blob,"
            +"dishes_name text,"
            +"price real)";
    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public static void getInstance(Activity_3 activity_3) {

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ACCOUNT);
        db.execSQL(CREATE_SHOP);
        db.execSQL(CREATE_ORDERS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Account");
        db.execSQL("drop table if exists Shop");
        db.execSQL("drop table if exists Orders");

        onCreate(db);
    }
}
