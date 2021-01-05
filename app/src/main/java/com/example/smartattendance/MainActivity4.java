package com.example.smartattendance;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity4 extends AppCompatActivity {
    teacher_register mydb;
    EditText id, password;
    Button button;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mydb = new teacher_register(this);

        id = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText6);
        button = (Button) findViewById(R.id.button);
        mydb = new teacher_register(this);
    }
    public void login(View v){
        String un = String.valueOf(id.getText());
        String pass = String.valueOf(password.getText());
        db = mydb.getReadableDatabase();

        String q = "Select * from login where name = '" +un+ "' and password = " +pass+ "";
        try {
            Cursor c = db.rawQuery(q, null);
            if (c.getCount() == 0) {
                Toast.makeText(getApplicationContext(), "Name or password wrong or doesn't exits", Toast.LENGTH_SHORT).show();
            } else {
                while (c.moveToNext()) {
                    un = c.getString(0);
                    pass = c.getString(1);
                    Toast.makeText(getApplicationContext(), "Name: " + un + "\nPassword: " + pass, Toast.LENGTH_LONG).show();
                    if (un.contentEquals((CharSequence) id) && pass.contentEquals(pass)) {
                        Toast.makeText(getApplicationContext(), "Welcome Name: " + un, Toast.LENGTH_LONG).show();
                        c.close();
                    }
                }
            }
        }
        catch (SQLiteException sqle) {
            sqle.printStackTrace();
        }
    }

}
