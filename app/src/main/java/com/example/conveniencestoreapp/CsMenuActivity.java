package com.example.conveniencestoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CsMenuActivity extends AppCompatActivity {

    Button gsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_menu);

        gsBtn=(Button)findViewById(R.id.gsBtn);

        gsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CsMenuActivity.this,FragmentMainActivity.class);
                startActivity(intent);
            }
        });
    }
}