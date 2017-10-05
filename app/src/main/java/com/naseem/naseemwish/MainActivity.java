package com.naseem.naseemwish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.naseem.naseemwish.mainlistfragments.MainListActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPass;
    private Button btnSignin;
    private Button btnSignup;
    private Button btnForget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnForget = (Button) findViewById(R.id.btnForget);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
    }

    public void Onlclick(View v) {
        if (v == btnSignup) {
            Intent intent = new Intent(this, SignUP.class);
            startActivity(intent);

        }
        if (v == btnSignin) {
            Intent intent = new Intent(this, MainListActivity.class);
            startActivity(intent);

        }


    }

}


