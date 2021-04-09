package com.example.car_s;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Main_User extends AppCompatActivity implements View.OnClickListener {

    ImageView image_1,image_2,image_3,image_4,image_5,image_6,image_7,image_8,image_9,image_10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_user);
        getSupportActionBar().hide();




        image_1 = (ImageView) findViewById(R.id.flat);
        image_2 = (ImageView) findViewById(R.id.wireman);
        image_3 = (ImageView) findViewById(R.id.patry);
        image_4 = (ImageView) findViewById(R.id.tirech);
        image_5 = (ImageView) findViewById(R.id.oilch);
        image_6 = (ImageView) findViewById(R.id.fitpump);
        image_7 = (ImageView) findViewById(R.id.radiater);
        image_8 = (ImageView) findViewById(R.id.banzin);
        image_9 = (ImageView) findViewById(R.id.computer);
        image_10 = (ImageView) findViewById(R.id.nazanm);





        image_1.setOnClickListener(this);
        image_2.setOnClickListener(this);
        image_3.setOnClickListener(this);
        image_4.setOnClickListener(this);
        image_5.setOnClickListener(this);
        image_6.setOnClickListener(this);
        image_7.setOnClickListener(this);
        image_8.setOnClickListener(this);
        image_9.setOnClickListener(this);
        image_10.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.flat:


                go();

                break;

            case R.id.wireman:


                go();

                break;

            case R.id.patry:


                go();

                break;

            case R.id.tirech:


                go();

                break;

            case R.id.oilch:


                go();

                break;

            case R.id.fitpump:


                go();

                break;

            case R.id.radiater:


                go();

                break;

            case R.id.banzin:


                go();

                break;

            case R.id.computer:


                go();

                break;

           case R.id.nazanm:


               Intent intent = new Intent(Main_User.this,Nazanm.class);
               startActivity(intent);

                break;
        }

    }

    void go (){
        Intent intent = new Intent(Main_User.this,MainUser2.class);
        startActivity(intent);

    }
}