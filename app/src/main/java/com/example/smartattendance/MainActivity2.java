package com.example.smartattendance;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;

class teacher_register extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Teachers.db";
    public static final String TABLE_NAME = "teacher_table";
    public static final String col_1 = "Name";
    public static final String col_2 = "ID";
    public static final String col_3 = "ContactNo";
    public static final String col_4 = "EmailID";
    public static final String col_5 = "Password";

    public teacher_register(Context context) {
        super(context, DATABASE_NAME , null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table teacher_table (Name TEXT,ID INTEGER PRIMARY KEY ,ContactNo INTEGER,EmailID INTEGER, Password TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS LOGIN" +TABLE_NAME);
        onCreate(db);
    }
}

public class MainActivity2 extends MainActivity4 {
    teacher_register mydb;
    EditText name, id, email, contact, password, confirm_password;
    Button button;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mydb = new teacher_register(this);

        name = (EditText) findViewById(R.id.editText2);
        id = (EditText) findViewById(R.id.editText3);
        contact = (EditText) findViewById(R.id.editText5);
        email = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText6);
        confirm_password = (EditText) findViewById(R.id.editText7);
        button = (Button) findViewById(R.id.button);
        mydb = new teacher_register(this);
    }
    public void register(View v){
        String un = String.valueOf(name.getText());
        String sid = String.valueOf(id.getText());
        String eid = String.valueOf(email.getText());
        String pass = String.valueOf(password.getText());
        String cpass = String.valueOf(confirm_password.getText());

        db = mydb.getWritableDatabase();
        String q = "insert into login values ("+un+" , "+pass+ ")";
        db.execSQL(q);
        Toast.makeText(getApplicationContext(),"Welcome!!", Toast.LENGTH_LONG).show();
    }
}