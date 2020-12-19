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

public class MainActivity2 extends AppCompatActivity {

    Toolbar toolbar2; //버튼,이미지버튼,툴바 등 아이템들 기존의 것과 다른거 쓸거면 꼭 아이디 다르게 해주세요!!
    Button gsBtn,cuBtn,sevenBtn,miniBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar2=(Toolbar)findViewById(R.id.toolbar2);
        gsBtn=(Button)findViewById(R.id.gsBtn);
        cuBtn=(Button)findViewById(R.id.cuBtn);
        sevenBtn=(Button)findViewById(R.id.sevenBtn);
        miniBtn=(Button)findViewById(R.id.miniBtn);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        gsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,GsMenuActivity.class);
                startActivity(intent);
            }
        });

        cuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,CuMenuActivity.class);
                startActivity(intent);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,SevenMenuActivity.class);
                startActivity(intent);
            }
        });

        miniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MiniMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater main_menuInflater=getMenuInflater();
        main_menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.myInfoBtn:
                GoMyInfoActivity();
                break;
            case R.id.logoutBtn:
                GoMainActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void GoMyInfoActivity(){
        Intent intent=new Intent(MainActivity2.this,MyInfoActivity.class);
        startActivity(intent);
    }

    public void GoMainActivity(){
        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}