package com.example.conveniencestoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.legacy.app.ActionBarDrawerToggle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button eventBtn, itemBtn, commuBtn;
    DrawerLayout mDrawerLayout;
    ImageButton menuIcon;
    View drawView;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        eventBtn = (Button) findViewById(R.id.eventBtn);
        itemBtn = (Button) findViewById(R.id.itemBtn);
        commuBtn = (Button) findViewById(R.id.commuBtn1);
        menuIcon = (ImageButton) findViewById(R.id.menuIcon);
        drawView = (View) findViewById(R.id.navi_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuIcon = (ImageButton) findViewById(R.id.menuIcon);

        navigationView = (NavigationView) findViewById(R.id.navi_view);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //프로젝트 타이틀 삭제

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GsEventActivity.class);
                startActivity(intent);
            }
        });

        itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CsMenuActivity.class);
                startActivity(intent);
            }
        });

        commuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "커뮤니티는 회원 전용 메뉴입니다 8ㅅ8", Toast.LENGTH_SHORT).show();
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch (id){
                    case R.id.navi_login:
                        Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent1);
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.navi_join:
                        Intent intent2=new Intent(MainActivity.this,JoinActivity.class);
                        startActivity(intent2);
                        mDrawerLayout.closeDrawers();
                        break;
                }

                return true;
            }
        });
    }

}


