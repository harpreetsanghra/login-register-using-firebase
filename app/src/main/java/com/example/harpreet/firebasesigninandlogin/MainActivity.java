package com.example.harpreet.firebasesigninandlogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btnlg(View view) {


        Intent intent=new Intent(this,login.class);
        startActivity(intent);
    }

    public void btnregister(View view) {

        Intent intent=new Intent(this,register.class);
        startActivity(intent);

    }







}
