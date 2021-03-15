package com.example.myclassroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TeacherLogIn extends AppCompatActivity {
    EditText etuser, etpass;
    Button loginbutton;
    private DatabaseReference mDatabase;
    private List<Userteacher> listuserteachers = new ArrayList<>();
    int i;
    boolean j = true, errorcheck = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_teacher_log_in);
        Firebase.setAndroidContext(this);

        etuser = (EditText) findViewById(R.id.useredittext);
        etpass = (EditText) findViewById(R.id.passwordedittext);
        loginbutton = (Button) findViewById(R.id.loginbutton);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etuser.getText().toString().isEmpty()) {
                    etuser.setError("Enter username");
                    errorcheck = false;
                }
                if (etpass.getText().toString().isEmpty()) {
                    etpass.setError("Enter password");
                    errorcheck = false;
                }
                if (errorcheck == true) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("teachers");
                    myRef.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            listuserteachers.clear();
                            List<String> key = new ArrayList<>();
                            for (DataSnapshot keynode : dataSnapshot.getChildren()) {
                                key.add(keynode.getKey());
                                Userteacher userteacher = keynode.getValue(Userteacher.class);
                                listuserteachers.add(userteacher);
                            }

                            for (i = 0; i < listuserteachers.size(); i++) {
                                if (listuserteachers.get(i).getUser_name().equals(etuser.getText().toString().trim()) && listuserteachers.get(i).getPassword().equals(etpass.getText().toString().trim())) {
                                    startActivity(new Intent(TeacherLogIn.this, Teacherhome.class));
                                    j = false;
                                }

                            }
                            if (j == true) {
                                Toast.makeText(TeacherLogIn.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                            }


                        }
                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                        }

                    });

                }

                j = true;
                errorcheck = true;
            }
        });
    }

}
