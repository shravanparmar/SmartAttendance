package com.example.smartattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button3;
    Button button;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button3 = (Button) findViewById(R.id.button3);
        button2 = (Button) findViewById(R.id.button2);
        button = (Button) findViewById(R.id.button);

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openDialog2();
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openDialog1();
            }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openDialog();
            }
        });
    }
    public void openDialog(){
    LayoutDialog1 layoutDialog1 = new LayoutDialog1();
    layoutDialog1.show(getSupportFragmentManager(), "Layout Dialog1");
    }

    public void openDialog1(){
        LayoutDialog2 layoutDialog2 = new LayoutDialog2();
        layoutDialog2.show(getSupportFragmentManager(), "Layout Dialog2");
    }

    public void openDialog2(){
        LayoutDialog3 layoutDialog3 = new LayoutDialog3();
        layoutDialog3.show(getSupportFragmentManager(), "Layout Dialog3");
    }
}
