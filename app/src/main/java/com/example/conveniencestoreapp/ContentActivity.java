package com.example.conveniencestoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    EditText EditComment;
    Button commentBtn;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent=getIntent();

        t1=(TextView)findViewById(R.id.content_Category);
        t2=(TextView)findViewById(R.id.content_Title);
        t3=(TextView)findViewById(R.id.content_Content);
        EditComment=(EditText)findViewById(R.id.EditComment);
        commentBtn=(Button)findViewById(R.id.commentBtn);
        listView=(ListView)findViewById(R.id.comment_list);

        arrayList=new ArrayList<>();

        adapter=new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1,arrayList);

        t1.setText(intent.getStringExtra("Category2"));
        t2.setText(intent.getStringExtra("Title2"));
        t3.setText(intent.getStringExtra("Content2"));


        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                arrayList.add(EditComment.getText().toString());
                adapter.notifyDataSetChanged();
                EditComment.setText("");
            }
        });

        listView.setAdapter(adapter);

    }
}

