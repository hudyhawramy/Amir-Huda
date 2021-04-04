package com.example.car_s;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListdataActivity extends AppCompatActivity {


    ImageView rasm;
    TextView name,age,exper,place,raqam,jor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);



        rasm = (ImageView) findViewById(R.id.rasm);

        name = (TextView) findViewById(R.id.naw);
        age = (TextView) findViewById(R.id.taman);
        exper = (TextView) findViewById(R.id.azmun);
        place = (TextView) findViewById(R.id.shwen);
        raqam = (TextView) findViewById(R.id.raqam);
        jor = (TextView) findViewById(R.id.jor);

        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        String receivedAge =  intent.getStringExtra("taman");
        String receivedExper =  intent.getStringExtra("azmun");
        String receivedPlace =  intent.getStringExtra("shwen");
        String receivedRaqam =  intent.getStringExtra("raqam");
        String receivedJor =  intent.getStringExtra("jor");

        int receivedImage = intent.getIntExtra("image",0);


        name.setText(receivedName);
        age.setText(receivedAge);
        exper.setText(receivedExper);
        place.setText(receivedPlace);
        raqam.setText(receivedRaqam);
        jor.setText(receivedJor);

        rasm.setImageResource(receivedImage);

        //enable back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //getting back to listview
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




    }
