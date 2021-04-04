package com.example.amoriproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class UpdateProfile extends AppCompatActivity {

    private TextView mTextView;
    private Button cancelBtn, saveBtn;
    TextInputLayout fullname, username, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cancelBtn = findViewById(R.id.btn_cancel);
        saveBtn = findViewById(R.id.btn_save);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdateProfile.this, "Profile updated!", Toast.LENGTH_SHORT).show();
                //after review has posted, it will go back to the page before
                finish();
            }
        });

    }
}