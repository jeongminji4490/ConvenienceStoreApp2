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
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    Toolbar toolbar2; //버튼,이미지버튼,툴바 등 아이템들 기존의 것과 다른거 쓸거면 꼭 아이디 다르게 해주세요!!
    Button eventBtn,commuBtn;
    ImageButton menuIcon2;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar2=(Toolbar)findViewById(R.id.toolbar2);
        eventBtn=(Button)findViewById(R.id.eventBtn);
        commuBtn=(Button)findViewById(R.id.commuBtn2);
        menuIcon2=(ImageButton)findViewById(R.id.menuIcon2);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout2);
        navigationView=(NavigationView)findViewById(R.id.navi_view2);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        commuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,CommuActivity.class);
                startActivity(intent);
            }
        });

        menuIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,GsEventActivity.class);
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();

                switch (id){
                    case R.id.navi_info:
                        Intent intent1=new Intent(MainActivity2.this,MyInfoActivity.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navi_logout:
                        Intent intent2=new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }
}