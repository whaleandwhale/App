package com.example.admin.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_6 extends AppCompatActivity {
    EditText name, price;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        add = (Button) findViewById(R.id.add);
        name = (EditText) findViewById(R.id.name);
        price = (EditText) findViewById(R.id.price);
    }
}