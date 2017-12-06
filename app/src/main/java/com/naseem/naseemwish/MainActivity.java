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

import static com.naseem.naseemwish.R.id.etEmail2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPass;
    private Button btnSignin;
    private Button btnSignup;
    private Button btnForget;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnForget = (Button) findViewById(R.id.btnForget);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        btnSignin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

    }

    private void dataHandler() {
        String email = etEmail.getText().toString();
        String passw = etPass.getText().toString();
        signIn(email, passw);
    }

    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getBaseContext(), MainListActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "signIn failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

    public void onClick(View view) {
        if (view == btnSignin) {
            dataHandler();
        }
        if (view == btnSignup) {
            Intent i = new Intent(this, SignUP.class);
            startActivity(i);
        }
    }
}



