package com.example.admin.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Activity_4 extends AppCompatActivity {
    private List<Orders> mOrdersList=new ArrayList<>();
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        initData();
        RecyclerView recyclerView=findViewById(R.id.recycler_view2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        OrdersAdapter ordersAdapter=new OrdersAdapter(mOrdersList);
        recyclerView.setAdapter(ordersAdapter);
    }
    private void initData() {
        int[]imageId=new int[]{};
        String[]name=new String[]{};
        for (int i=0;i<2;i++){
            Orders orders=new Orders();
            orders.setImageId(imageId[i]);
            orders.setName(name[i]);
            mOrdersList.add(orders);
        }
    }
}
