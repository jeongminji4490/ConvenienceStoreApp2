package com.example.conveniencestoreapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

public class CommuActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    Button writeBtn;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commu);

        listView=(ListView)findViewById(R.id.listView);
        writeBtn=(Button)findViewById(R.id.writeBtn);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        adapter=new ListViewAdapter();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //프로젝트 타이틀 삭제

        listView.setAdapter(adapter);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CommuActivity.this,WriteActivity.class);
                startActivityForResult(intent,1);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(CommuActivity.this,ContentActivity.class);
                intent.putExtra("Category2",adapter.arrayList.get(position).getText1());
                intent.putExtra("Title2",adapter.arrayList.get(position).getText2());
                intent.putExtra("Content2",adapter.arrayList.get(position).getText3());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && data!=null){
            String cateFromWriteActivity=data.getStringExtra("Category");
            String titleFromWriteActivity=data.getStringExtra("Title");
            String contentFromWriteActivity=data.getStringExtra("Content");

            adapter.addItem(cateFromWriteActivity,titleFromWriteActivity,contentFromWriteActivity);
            adapter.notifyDataSetChanged();
        }
    }
}