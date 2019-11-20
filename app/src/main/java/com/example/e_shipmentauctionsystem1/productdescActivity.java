package com.example.e_shipmentauctionsystem1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class productdescActivity extends AppCompatActivity  {
    ImageView imageView3;
    EditText etWeight,etLength,etWidth,etHeight;
    Button buContinue;
    DatabaseReference dbProduct;
    String sn;
    double result;
    List<String> arr;

    public static final int CAMERA_REQUEST=999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdesc);
        dbProduct= FirebaseDatabase.getInstance().getReference("products");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etWeight=(EditText) findViewById(R.id.etWeight);
        etLength=(EditText) findViewById(R.id.etLength);
        etWidth=(EditText) findViewById(R.id.etWidth);
        etHeight=(EditText) findViewById(R.id.etHeight);
        buContinue=(Button) findViewById(R.id.buContinue);
        imageView3=(ImageView)findViewById(R.id.imageView3);
        Spinner spineer=findViewById(R.id.Spinner1);
        Spinner spineer2=findViewById(R.id.Spinner2);
        arr =new ArrayList<String>();
        arr.add("New Delhi");
        arr.add("Mumbai");
        arr.add("Gujarat");
        arr.add("Jammu & Kashmir");
        arr.add("Other State");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arr);
        spineer.setAdapter(arrayAdapter);
        spineer2.setAdapter(arrayAdapter);
         sn= spineer2.getSelectedItem().toString();;

         spineer2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 sn=arr.get(i);

             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });



    }





    String pc1="10";
    public void OpenCamera(View view) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CAMERA_REQUEST){
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            imageView3.setImageBitmap(bitmap);
        }
    }


    public void buCont(View view) {

        int n1;
        n1 = Integer.parseInt(etWeight.getText().toString());
        if(sn.equals("New Delhi")){
            result=n1*30;
        }
        else if(sn.equals("Mumbai")){
            result=n1*50;
        }
        else if(sn.equals("Gujarat")){
            result=n1*50;
        }
        else if(sn.equals("Jammu & Kashmir")){
            result=n1*160;
        }
        else{
            result=n1*120;
        }

        addDetails();

    }
    private void addDetails(){
        String weight=etWeight.getText().toString().trim();
        String length=etLength.getText().toString().trim();
        String width=etWidth.getText().toString().trim();
        String height=etHeight.getText().toString().trim();
        String result1=Double.toString(result);

        String id= dbProduct.push().getKey();

        Product pr1=new Product(id,weight,length,width,height);
        dbProduct.child(id).setValue(pr1);
        Intent intent=new Intent(productdescActivity.this,pop.class);
        intent.putExtra("predictedprice",result1);
        startActivity(intent);
    }


}
