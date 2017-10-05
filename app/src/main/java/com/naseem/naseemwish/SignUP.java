package com.naseem.naseemwish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUP extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail2;
    private EditText etPass2;
    private EditText etRepass;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName = (EditText) findViewById(R.id.etName);
        etEmail2 = (EditText) findViewById(R.id.etEmail2);
        etPass2 = (EditText) findViewById(R.id.etPass2);
        etRepass = (EditText) findViewById(R.id.etRepass);
        btnSave = (Button) findViewById(R.id.btnSave);
    }
    public void onCliclk(View v)
    {
        if(btnSave==v)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }




    }
}
