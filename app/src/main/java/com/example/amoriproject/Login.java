package com.example.amoriproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    // define variables
    Button register, login;
    TextInputLayout username, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // find components by id according to the defined variable
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        register = findViewById(R.id.btn_regis);
        login = findViewById(R.id.btn_login);

               //set onclick register button which will display on register page
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });


        //set onclick login button which will display on dashboard page
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user =  username.getEditText().getText().toString().trim();
                String password =  pass.getEditText().getText().toString().trim();

                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT) .show();
                startActivity(new Intent(Login.this, Dashboard.class));

//                // login method
//                if(user.equals("") || password.equals("")){
//                    Toast.makeText(Login.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
//                }else{
//                    if (false) {
//                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT) .show();
//                        startActivity(new Intent(Login.this, Dashboard.class));
//                    } else {
//                        Toast.makeText(Login.this, "Login Failed, please recheck your username or password", Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });

    }

    @Override
    public void onBackPressed() {

        //set alert dialog for user who click back button on the phone
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}