package com.naseem.naseemwish;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.naseem.naseemwish.data.Product;
import com.naseem.naseemwish.mainlistfragments.MainListActivity;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener{

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
        iBtnImage.setOnClickListener(this);
    }
    public void datahandler() {
        String stName = etName.getText().toString();
        String stUnits = etUnits.getText().toString();
        String stAmount = etAmount.getText().toString();
        String stPrice = etPrice.getText().toString();

        double amount = Double.parseDouble(stAmount);
        double price = Double.parseDouble(stPrice);

        Product p=new Product();
        p.setName(stName);
        p.setAmount(amount);
        p.setPrice(price);
        p.setCompleted(false);


        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email= email.replace('.','*');

        DatabaseReference reference;
        reference= FirebaseDatabase.getInstance().getReference();
        reference.child(email).child("mylist").push().setValue(p).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(AddItemActivity.this,"Add Product Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddItemActivity.this,"Add Product Filed",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //reference.child("list").setValue(stName);

    }


    @Override
    public void onClick(View v) {
        if (iBtnImage== v)
        {
            Intent i = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            final int ACTIVITY_SELECT_IMAGE = 1234;
            startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1234:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
            /* Now you have choosen image in Bitmap format in object "yourSelectedImage". You can use it in way you want! */
                }
        }

    };
}
