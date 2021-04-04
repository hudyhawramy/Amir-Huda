package com.example.car_s;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Submition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submition);
    }

    public void submit2(View view) {
        Intent intent = new Intent(Submition.this ,login.class );
        startActivity(intent);
        finish();
    }
}