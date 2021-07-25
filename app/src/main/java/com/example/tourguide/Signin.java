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

public class Signin extends AppCompatActivity {
private Button btn3;
private EditText edUsername;
private EditText edPassword;
private  final String SHAREDPREFERENCE = "hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        btn3 = findViewById(R.id.btn3);
        edUsername = findViewById(R.id.edit5);
        edPassword = findViewById(R.id.edit6);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credentials = getSharedPreferences(SHAREDPREFERENCE, Context.MODE_PRIVATE);
                String strUsername = credentials.getString("Username",null);
                String strpassword = credentials.getString("Password", null);

                String username_from_ed = edUsername.getText().toString();
                String password_from_ed = edPassword.getText().toString();

                if(strUsername != null && username_from_ed != null && strUsername.equalsIgnoreCase(username_from_ed)){
                    if(strpassword != null && password_from_ed != null && strpassword.equalsIgnoreCase(password_from_ed)){
                        Toast.makeText(Signin.this,"Sign Successfull",Toast.LENGTH_LONG).show();
                        Intent a =new Intent(Signin.this,Card_view_menu.class);
                        startActivity(a);
                    }else{
                        Toast.makeText(Signin.this,"Invalid Password",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Signin.this,"Don't Leave Blank Space",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}