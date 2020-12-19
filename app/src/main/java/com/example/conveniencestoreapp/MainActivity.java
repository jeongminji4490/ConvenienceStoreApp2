package com.example.conveniencestoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button gsBtn,cuBtn,sevenBtn,miniBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        gsBtn=(Button)findViewById(R.id.gsBtn);
        cuBtn=(Button)findViewById(R.id.cuBtn);
        sevenBtn=(Button)findViewById(R.id.sevenBtn);
        miniBtn=(Button)findViewById(R.id.miniBtn);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //프로젝트 타이틀 삭제

        gsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GsMenuActivity.class);
                startActivity(intent);
            }
        });

        cuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CuMenuActivity.class);
                startActivity(intent);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SevenMenuActivity.class);
                startActivity(intent);
            }
        });

        miniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MiniMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logMenu:
                GoLoginActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void GoLoginActivity(){
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}