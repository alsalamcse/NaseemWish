package com.naseem.naseemwish;

import android.content.Intent;
import android.support.annotation.NonNull;
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
import com.google.firebase.auth.FirebaseUser;
import com.naseem.naseemwish.mainlistfragments.MainListActivity;

public class SignUP extends AppCompatActivity implements View.OnClickListener{

    private EditText etName;
    private EditText etEmail2;
    private EditText etPass2;
    private EditText etRepass;
    private Button btnSave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etName = (EditText) findViewById(R.id.etName);
        etEmail2 = (EditText) findViewById(R.id.etEmail2);
        etPass2 = (EditText) findViewById(R.id.etPass2);
        etRepass = (EditText) findViewById(R.id.etRepass);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        auth=FirebaseAuth.getInstance();
        firebaseUser=auth.getCurrentUser();
    }
    private void dataHandler() {
        String email = etEmail2.getText().toString();
        String passw = etPass2.getText().toString();

        createAccount(email,passw);
    }



    private void createAccount(String email,String passw){
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUP.this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    Toast.makeText(SignUP.this, "Authentication Successful", Toast.LENGTH_SHORT).show();
                    //updateUserProfile(task.getResult().getUser());
                    finish();
                }
                else
                {
                    Toast.makeText(SignUP.this,"Authentication failed"+task.getException().getMessage(),
                            Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });




    }


    public void onClick(View view) {
        if (view==btnSave)
        {
            dataHandler();
        }

    }
}



