package com.example.myclassroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button welcomeloginbuttonteacherinclass,welcomeloginbuttonstudentinclass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        gotologinpage();
    }


    public void gotologinpage(){
        welcomeloginbuttonteacherinclass = (Button)findViewById(R.id.welcomebuttonteacher);
        welcomeloginbuttonstudentinclass = (Button)findViewById(R.id.welcomebuttonstudent);
        welcomeloginbuttonteacherinclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TeacherLogIn.class));
            }
        });
        welcomeloginbuttonstudentinclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StudentLogIn.class));
            }
        });
        }

}
