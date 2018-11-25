package com.example.admin.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Activity_5 extends AppCompatActivity {
    private List<Dishes> mDishesList=new ArrayList<>();
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        initData();
        RecyclerView recyclerView=findViewById(R.id.recycler_view3);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DishesAdapter dishesAdapter=new DishesAdapter(mDishesList);
        recyclerView.setAdapter(dishesAdapter);
    }
    private void initData() {
        int[]imageId=new int[]{};
        String[]name=new String[]{};
        for (int i=0;i<2;i++){
            Dishes dishes=new Dishes();
            dishes.setImageId(imageId[i]);
            dishes.setName(name[i]);
            mDishesList.add(dishes);
        }
    }
}
