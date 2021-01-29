package com.example.conveniencestoreapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class CommuActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    Button writeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commu);

        listView=(ListView)findViewById(R.id.listView);
        writeBtn=(Button)findViewById(R.id.writeBtn);
        adapter=new ListViewAdapter();

        listView.setAdapter(adapter);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CommuActivity.this,WriteActivity.class);
                startActivityForResult(intent,1);
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