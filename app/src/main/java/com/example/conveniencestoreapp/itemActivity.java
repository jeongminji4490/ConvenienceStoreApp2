package com.example.conveniencestoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class itemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

    }
}