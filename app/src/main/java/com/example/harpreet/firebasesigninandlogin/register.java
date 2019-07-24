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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.iid.FirebaseInstanceId;

public class register extends AppCompatActivity {

   // TextView tv1,tv2,tv3;
    EditText ed1,ed2;
    Button b1;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ed1=findViewById(R.id.ed6);
        ed2=findViewById(R.id.ed9);
        b1=findViewById(R.id.b1);
      //  firebaseAuth=FirebaseAuth.getInstance();
        FirebaseInstanceId.getInstance().getToken();
    }

    public void register(View view) {
        final ProgressDialog progressDialog=ProgressDialog.show(register.this,"plese wait ","loading",true);
        (firebaseAuth.createUserWithEmailAndPassword(ed1.getText().toString(),ed2.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressDialog.dismiss();
                if (task.isSuccessful()) {

                    Toast.makeText(register.this, "register sucess", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(register.this, login.class);
                    startActivity(intent);
                 //   finish();
                } else {
                    Toast.makeText(register.this, "register not sucess", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }




    public void onBackPressed() {
        // super.onBackPressed();

        AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
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



