package com.example.conveniencestoreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentMainActivity extends AppCompatActivity {

    Button gsItems1,gsItems2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        gsItems1=(Button)findViewById(R.id.gsItems1);
        gsItems2=(Button)findViewById(R.id.gsItems2);

        //첫 화면에 AFragment 레이아웃이 보이도록//
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        AFragment aFragment=new AFragment();
        transaction.replace(R.id.gsMainFragment,aFragment);
        transaction.commit(); //commit 꼭 해주세요

        gsItems1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.gsMainFragment,aFragment); //메인 프레그먼트 화면에서 1+1 프레그먼트 화면으로 교체
                transaction.commit();
            }
        });

        gsItems2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                FragmentB bFragment=new FragmentB();
                transaction.replace(R.id.gsMainFragment,bFragment); //메인 프레그먼트 화면에서 2+1 프레그먼트 화면으로 교체
                transaction.commit();
            }
        });
    }

}