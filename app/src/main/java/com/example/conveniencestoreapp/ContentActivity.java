package com.example.conveniencestoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContentActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    long now=System.currentTimeMillis();
    Date date=new Date(now);
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String formateDate=dateFormat.format(date);
    TextView dateNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent=getIntent();

        t1=(TextView)findViewById(R.id.content_Category);
        t2=(TextView)findViewById(R.id.content_Title);
        t3=(TextView)findViewById(R.id.content_Content);
        dateNow=(TextView)findViewById(R.id.dateNow);

        dateNow.setText(formateDate);

        t1.setText(intent.getStringExtra("Category2"));
        t2.setText(intent.getStringExtra("Title2"));
        t3.setText(intent.getStringExtra("Content2"));

    }
}

