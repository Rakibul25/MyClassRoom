package com.example.myclassroom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Studenthome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studenthome);
        getSupportActionBar().hide();
    }
}
