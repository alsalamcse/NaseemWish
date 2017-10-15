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

public class SignUP extends AppCompatActivity {

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
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        if (firebaseUser == null) {
            startActivity(new Intent(this, MainListActivity.class));
            finish();
            ;
            return;
        } else {
            String userName = firebaseUser.getDisplayName();
        }

        etName = (EditText) findViewById(R.id.etName);
        etEmail2 = (EditText) findViewById(R.id.etEmail2);
        etPass2 = (EditText) findViewById(R.id.etPass2);
        etRepass = (EditText) findViewById(R.id.etRepass);
        btnSave = (Button) findViewById(R.id.btnSave);
    }


    private void dataHandler() {
        String stEmail = etEmail2.getText().toString();
        String stName = etName.getText().toString();
        String stPassw = etPass2.getText().toString();
        String stRepassw = etRepass.getText().toString();
        boolean isok = true;
        if(stEmail.length()==0 || stEmail.indexOf('@')<1)
        {
            etEmail2.setError("Wrong Email");
            isok=false;
        }
        if(stPassw.length()<8 || stPassw.equals(stRepassw)==false)
        {
            etPass2.setError("Bad Password");
            isok=false;
        }
        craetAcount(stEmail, stPassw);
    }


    public void onClick(View v) {
        dataHandler();
    }

    private void craetAcount(String email, String passw) {
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUP.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUP.this, "Authentication Successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(SignUP.this, "Authentication failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }


        });
    }
}



