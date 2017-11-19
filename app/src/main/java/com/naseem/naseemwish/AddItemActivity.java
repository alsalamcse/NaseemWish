package com.naseem.naseemwish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.naseem.naseemwish.mainlistfragments.MainListActivity;

public class AddItemActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAmount;
    private EditText etUnits;
    private EditText etPrice;
    private ImageButton iBtnImage;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        etName=(EditText)findViewById(R.id.etName);
        etAmount=(EditText)findViewById(R.id.etAmount);
        etUnits=(EditText)findViewById(R.id.etUnits);
        etPrice=(EditText)findViewById(R.id.etPrice);
        iBtnImage=(ImageButton)findViewById(R.id.iBtnImage);
        btnSave=(Button)findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datahandler();
            }
        });
    }
    public void datahandler() {
        String stName = etName.getText().toString();
        String stUnits = etUnits.getText().toString();
        String stAmount = etAmount.getText().toString();
        String stPrice = etPrice.getText().toString();
        double amount = Double.parseDouble(stAmount);
        double price = Double.parseDouble(stPrice);

        DatabaseReference reference;
        reference= FirebaseDatabase.getInstance().getReference();
        reference.child("list").setValue(stName);
    }
//    public void onClick(View v)
//    {
//        if(btnSave==v)
//        {
//            Intent i = new Intent(this,MainListActivity.class);
//            startActivity(i);
//        }
//    }


}
