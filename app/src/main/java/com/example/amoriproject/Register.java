package com.example.amoriproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    // define variables
    Button login, regis;
    TextInputLayout fullname, email, username, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // find components by id according to the defined variable
        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);
        regis = findViewById(R.id.btn_regis);

        //set onclick login button which will display on login page
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });

        //set onclick register button
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String full_name = fullname.getEditText().getText().toString().trim();
                String mail = email.getEditText().getText().toString().trim();
                String user =  username.getEditText().getText().toString().trim();
                String password =  pass.getEditText().getText().toString().trim();

                Toast.makeText(Register.this, "Register successful", Toast.LENGTH_SHORT).show();

                //change page from register to login page
                Intent i = new Intent( Register.this, Login.class);
                startActivity(i);

//                //register method
//                if (password.equals("") || user.equals("") || full_name.equals("") || mail.equals("") ) {
//                    Toast.makeText(Register.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
//
//                } else {
//                    //make toast for tell user that register successful
//                    Toast.makeText(Register.this, "Register successful", Toast.LENGTH_SHORT).show();
//
//                    //change page from register to login page
//                    Intent i = new Intent( Register.this, Login.class);
//                    startActivity(i);
//
//                    finish();
//                }
            }
        });
    }

}
