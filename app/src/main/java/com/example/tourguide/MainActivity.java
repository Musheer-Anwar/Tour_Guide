package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button btn1,btn2;
     EditText edUseremail;
     EditText edPassword;
     EditText edConfirmPassword;
     final String SHAREDPREFERENCE = "hello";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUseremail = findViewById(R.id.edit2);
        edPassword = findViewById(R.id.edit3);
        edConfirmPassword = findViewById(R.id.edit4);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stremail = edUseremail.getText().toString();
                String strpassword = edPassword.getText().toString();
                String strconfirmpassword = edConfirmPassword.getText().toString();
                if( stremail == null || strpassword == null || strconfirmpassword == null){
                    Toast.makeText(MainActivity.this, "All Fields are Mandatory", Toast.LENGTH_SHORT).show();
                }
                if(strpassword != null && strconfirmpassword != null && strpassword.equalsIgnoreCase(strconfirmpassword)){
                    SharedPreferences credentials = getSharedPreferences(SHAREDPREFERENCE, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("Password",strpassword);
                    editor.putString("Username",stremail);
                    editor.commit();
                    Toast.makeText(MainActivity.this,"SignUp Successfull",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),Signin.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Signin.class);
                startActivity(intent);
            }
        });


    }
}