package com.example.conveniencestoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class WriteActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter arrayAdapter;
    EditText EditTitle,EditContent;
    Button registerBtn;
    String title,content,sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        spinner=(Spinner)findViewById(R.id.spinner);
        EditTitle=(EditText)findViewById(R.id.EditTitle);
        EditContent=(EditText)findViewById(R.id.EditContent);
        registerBtn=(Button)findViewById(R.id.registerBtn);

        arrayAdapter=ArrayAdapter.createFromResource(this,R.array.array, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WriteActivity.this,CommuActivity.class);

                title=EditTitle.getText().toString().trim();
                content=EditContent.getText().toString().trim();
                sp=spinner.getSelectedItem().toString();

                intent.putExtra("Category",sp);
                intent.putExtra("Title",title);
                intent.putExtra("Content",content);

                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}