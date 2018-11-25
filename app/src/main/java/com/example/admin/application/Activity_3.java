package com.example.admin.application;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.sql.Blob;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Activity_3 extends AppCompatActivity {
    private SQLiteDatabase db;
    private ShopAdapter shopAdapter;
    private RecyclerView recyclerView;
    List<Shop> list=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        MyDatabaseHelper.getInstance(Activity_3.this);
        list= ShopFactor.createShop(db);
        shopAdapter=new ShopAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(shopAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

}
