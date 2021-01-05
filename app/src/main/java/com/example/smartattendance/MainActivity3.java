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

class register extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Students.db";
    public static final String TABLE_NAME = "student_table";
    public static final String col_1 = "Name";
    public static final String col_2 = "ID";
    public static final String col_3 = "ContactNo";
    public static final String col_4 = "EmailID";
    public static final String col_5 = "Parent_name";
    public static final String col_6 = "Parent_contact_no";
    public static final String col_7 = "Password";

    public register(Context context) {
        super(context, DATABASE_NAME , null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student_table (Name TEXT,ID INTEGER PRIMARY KEY ,ContactNo INTEGER,EmailID INTEGER,Parent_name TEXT, Parent_contact_no INTEGER, Password TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS LOGIN" +TABLE_NAME);
        onCreate(db);
    }
}

public class MainActivity3 extends MainActivity5 {
    register mydb;
    EditText name, id, email, contact, parent_name, parent_contact, password, confirm_password;
    Button button;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mydb = new register(this);

        name = (EditText) findViewById(R.id.editText2);
        id = (EditText) findViewById(R.id.editText3);
        contact = (EditText) findViewById(R.id.editText5);
        email = (EditText) findViewById(R.id.editText4);
        parent_name = (EditText) findViewById(R.id.editText6);
        parent_contact = (EditText) findViewById(R.id.editText7);
        password = (EditText) findViewById(R.id.editText8);
        confirm_password = (EditText) findViewById(R.id.editText9);
        button = (Button) findViewById(R.id.button);
        mydb = new register(this);
    }

    public void login(View v){
        String un = String.valueOf(name.getText());
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
                            if (un.contentEquals((CharSequence) name) && pass.contentEquals(pass)) {
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

    public void register(View v){
        String un = String.valueOf(name.getText());
        String sid = String.valueOf(id.getText());
        String eid = String.valueOf(email.getText());
        String pname = String.valueOf(parent_name.getText());
        String pcontact = String.valueOf(parent_contact.getText());
        String pass = String.valueOf(password.getText());
        String cpass = String.valueOf(confirm_password.getText());

        db = mydb.getWritableDatabase();
        String q = "insert into login values ("+un+" , "+pass+ ")";
        db.execSQL(q);
        Toast.makeText(getApplicationContext(),"Welcome!!", Toast.LENGTH_LONG).show();
    }


}
