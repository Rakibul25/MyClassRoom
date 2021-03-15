package com.example.myclassroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class StudentLogIn extends AppCompatActivity {
    EditText etuser,etpass;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_log_in);
        getSupportActionBar().hide();
        etuser = (EditText) findViewById(R.id.useredittext);
        etpass = (EditText) findViewById(R.id.passwordedittext);
        loginbutton = (Button) findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentLogIn.this,Studenthome.class));
            }
        });
    }
}
