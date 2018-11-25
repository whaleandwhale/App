package com.example.admin.application;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ShopFactor {
    public static String[]name=new String[1000];
    public static String[]imageId=new String[1000];
    public static int shopCount;
    public static void queryDatabase(SQLiteDatabase db){
        String[]strings=new String[]{"photo_shop","shop_name"};
        Cursor cursor=db.query("Account", strings,null,null,null,null,null);
        shopCount=cursor.getCount();
        for (int i=0;i<cursor.getCount();i++){
            if (cursor.moveToFirst()){
                cursor.move(i);
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                Log.d("shop id","shop is NO."+id);
                imageId[i]=cursor.getString(cursor.getColumnIndex("photo_shop"));
                name[i]=cursor.getString(cursor.getColumnIndex("shop_name"));
            }
        }
    }
    public static List<Shop> createShop(SQLiteDatabase db){
        List<Shop>shops=new ArrayList<>();
        queryDatabase(db);
        for (int i=0;i<shopCount;i++){
            String photo_shop=imageId[i];
            String shop_name=name[i];
            shops.add(new Shop(photo_shop,shop_name));
        }
        return shops;
    }
}
