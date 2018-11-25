package com.example.admin.application;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class Activity extends AppCompatActivity {
    Button enter, register;
    EditText user, password_1;
    String name, pass_1;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        user = (EditText) findViewById(R.id.user);
        password_1 = (EditText) findViewById(R.id.password);
        enter = (Button) findViewById(R.id.enter);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity.this, Activity_2.class);
                startActivity(intent);
            }
        });
        dbHelper = new MyDatabaseHelper(this, "Account.db", null, 1);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = user.getText().toString().trim();
                pass_1 = password_1.getText().toString().trim();
                if (login(name, pass_1)) {
                    Toast.makeText(Activity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Activity.this, Activity_3.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(Activity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public boolean login(String name, String pass) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select * from Account where name=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[]{name, pass});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }
}

