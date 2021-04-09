package com.example.car_s;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class Nazanm extends AppCompatActivity implements View.OnClickListener {
    ImageView img,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nazanm);


        img = (ImageView) findViewById(R.id.information);
        img2 = (ImageView) findViewById(R.id.light);



        img.setOnClickListener(this);
        img2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.information:
                setContentView(R.layout.zanyari);
                ScrollView zanyari = (ScrollView) findViewById(R.id.INFO);
            break;

            case R.id.light:
                setContentView(R.layout.glop);
                ScrollView glop = (ScrollView) findViewById(R.id.GL);
                break;
        }


    }
}