package com.example.conveniencestoreapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firestore.v1.Write;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

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

                if (title.isEmpty() || content.isEmpty()){
                    Toast.makeText(WriteActivity.this,"제목 또는 내용을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra("Category",sp);
                    intent.putExtra("Title",title);
                    intent.putExtra("Content",content);

                    setResult(Activity.RESULT_OK,intent);
                    finish();
                }
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        RequestOptions options=new RequestOptions().circleCrop();
//
//        if(requestCode==1 && resultCode==RESULT_OK && data!=null){
//            imgUri=data.getData();
//            Glide.with(getApplicationContext()).load(imgUri).apply(options).into(imgView);
//        }
//
//        if(requestCode==1){
//
//            if (resultCode==RESULT_OK){
//
//                try {
//                    InputStream in=getContentResolver().openInputStream(data.getData());
//                    img= BitmapFactory.decodeStream(in);
//                    in.close();
//                    imgView.setImageBitmap(img);
//                }catch (Exception e){
//
//                }
//            }
//            else if (resultCode==RESULT_CANCELED){
//                Toast.makeText(this,"사진 선택 취소",Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

//    public byte[] bitmapToByte(Bitmap bitmap){
//
//        ByteArrayOutputStream stream=new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
//        byte[] byteArray=stream.toByteArray();
//        return byteArray;
//    }
}