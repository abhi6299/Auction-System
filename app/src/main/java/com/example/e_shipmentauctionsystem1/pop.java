package com.example.e_shipmentauctionsystem1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.e_shipmentauctionsystem1.R;

public class pop extends Activity {
    TextView edittext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup);

        Button bu=(Button)findViewById(R.id.Confirm);
        Button bu_1=(Button)findViewById(R.id.Cancel);
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Bundle b=getIntent().getExtras();
        String name=b.getString("predictedprice");
        edittext=(TextView) findViewById(R.id.Confirm1);
        edittext.setText(name);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pop.this,Main2custActivity.class));
                Toast.makeText(pop.this, "Product Added Successful", Toast.LENGTH_SHORT).show();
            }
        });
        bu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pop.this,home2.class));
                Toast.makeText(pop.this, "Product not Added", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
