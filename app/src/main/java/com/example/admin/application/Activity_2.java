package com.example.admin.application;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_2 extends AppCompatActivity {
    Button register;
    EditText user, password_1, password_2;
    String name, pass;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        register = (Button) findViewById(R.id.register);
        user = (EditText) findViewById(R.id.user);
        password_1 = (EditText) findViewById(R.id.password_1);
        password_2 = (EditText) findViewById(R.id.password_2);
        dbHelper = new MyDatabaseHelper(this, "Account.db", null, 1);

        register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                name = user.getText().toString();
                pass = password_1.getText().toString();
                if (CheckIsDataAlreadyInDBorNot(name)) {
                    Toast.makeText(Activity_2.this, "该用户名已被注册，注册失败", Toast.LENGTH_SHORT).show();
                } else {

                    if (register_1(name, pass)) {
                        Toast.makeText(Activity_2.this, "插入数据表成功", Toast.LENGTH_SHORT).show();
                    }
                }
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("password", pass);
                db.insert("Account", null, values);
                values.clear();
                Toast.makeText(Activity_2.this, "数据库建立成功", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public boolean register_1(String name, String pass) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("password", pass);
        db.insert("Account", null, values);
        db.close();
        db.execSQL("insert into Account(name,password) values(?,?)", new String[]{name, pass});
        return true;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String value) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String Query = "Select * from userData where name =?";
        Cursor cursor = db.rawQuery(Query, new String[]{value});
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
}





