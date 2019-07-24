package com.example.harpreet.firebasesigninandlogin;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText ed11,ed22;
    Button b11;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed11=findViewById(R.id.ed6);
        ed22=findViewById(R.id.ed9);
        b11=findViewById(R.id.b8);
        firebaseAuth=FirebaseAuth.getInstance();


    }

    public void login(View view) {
        final ProgressDialog progressDialog=ProgressDialog.show(login.this,"plese wait ","loading",true);
        (firebaseAuth.signInWithEmailAndPassword(ed11.getText().toString(),ed22.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressDialog.dismiss();
                if (task.isSuccessful()) {

                    Toast.makeText(login.this, "login sucess", Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(login.this, welcome.class);
                //   intent.putExtra("email",firebaseAuth.getCurrentUser().getEmail());
                   startActivity(intent);
                   finish();
                } else {
                    Toast.makeText(login.this, "login not sucess", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }

    public void onBackPressed() {
        // super.onBackPressed();

        AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if   "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }}


