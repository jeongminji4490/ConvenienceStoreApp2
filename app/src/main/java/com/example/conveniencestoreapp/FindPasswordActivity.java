package com.example.conveniencestoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindPasswordActivity extends AppCompatActivity {

    Button findPwd_Ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);

        findPwd_Ok=(Button)findViewById(R.id.findPwd_Ok);

        findPwd_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FindPasswordActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}