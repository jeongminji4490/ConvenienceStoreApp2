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
    Button eventBtn,itemBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar2=(Toolbar)findViewById(R.id.toolbar2);
        eventBtn=(Button)findViewById(R.id.eventBtn);
        itemBtn=(Button)findViewById(R.id.itemBtn);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,GsEventActivity.class);
                startActivity(intent);
            }
        });

        itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,CsMenuActivity.class);
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