package com.example.smartattendance;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Dialog;
public class LayoutDialog1 extends AppCompatDialogFragment {

    private Button button1;
    private Button button2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view).setTitle("Login");

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);


        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(getActivity(), MainActivity4.class);
                startActivity(i);
            }
        });


        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(getActivity(), MainActivity5.class);
                startActivity(i);
            }
        });
        return builder.create();


    }

}
