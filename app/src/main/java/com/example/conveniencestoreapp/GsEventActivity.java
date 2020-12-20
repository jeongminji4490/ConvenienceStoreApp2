package com.example.conveniencestoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GsEventActivity extends AppCompatActivity {

    ImageButton gsevent1,gsevent2,gsevent3,gsevent4;
    ImageButton cuevent1,cuevent2,cuevent3,cuevent4;
    ImageButton sevenevent1,sevenevent2,sevenevent3,sevenevent4;
    ImageButton minievent1,minievent2,minievent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gs_event);

        gsevent1=(ImageButton)findViewById(R.id.gsevent1);
        gsevent2=(ImageButton)findViewById(R.id.gsevent2);
        gsevent3=(ImageButton)findViewById(R.id.gsevent3);
        gsevent4=(ImageButton)findViewById(R.id.gsevent4);

        cuevent1=(ImageButton)findViewById(R.id.cuevent1);
        cuevent2=(ImageButton)findViewById(R.id.cuevent2);
        cuevent3=(ImageButton)findViewById(R.id.cuevent3);
        cuevent4=(ImageButton)findViewById(R.id.cuevent4);

        sevenevent1=(ImageButton)findViewById(R.id.sevenevent1);
        sevenevent2=(ImageButton)findViewById(R.id.sevenevent2);
        sevenevent3=(ImageButton)findViewById(R.id.sevenevent3);
        sevenevent4=(ImageButton)findViewById(R.id.sevenevent4);

        minievent1=(ImageButton)findViewById(R.id.minievent1);
        minievent2=(ImageButton)findViewById(R.id.minievent2);
        minievent3=(ImageButton)findViewById(R.id.minievent3);

        gsevent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://gs25.gsretail.com/gscvs/ko/customer-engagement/event/detail/publishing?pageNum=1&eventCode=8825649876512"));
                startActivity(intent);
            }
        });

        gsevent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://gs25.gsretail.com/gscvs/ko/customer-engagement/event/detail/publishing?pageNum=1&eventCode=8825715379744"));
                startActivity(intent);
            }
        });

        gsevent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://gs25.gsretail.com/gscvs/ko/customer-engagement/event/detail/text-input?pageNum=1&eventCode=8825649843744"));
                startActivity(intent);
            }
        });

        gsevent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://gs25.gsretail.com/gscvs/ko/customer-engagement/event/detail/publishing?pageNum=1&eventCode=8825584537120"));
                startActivity(intent);
            }
        });

        cuevent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://membership.bgfretail.com/pc/eventDetail?page=&state=&event_id=728"));
                startActivity(intent);
            }
        });

        cuevent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://membership.bgfretail.com/pc/eventDetail?page=&state=&event_id=741"));
                startActivity(intent);
            }
        });

        cuevent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://membership.bgfretail.com/pc/eventDetail?page=&state=&event_id=744"));
                startActivity(intent);
            }
        });

        cuevent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://membership.bgfretail.com/pc/eventDetail?page=&state=&event_id=742"));
                startActivity(intent);
            }
        });

        sevenevent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.7-eleven.co.kr/event/eventView.asp"));
                startActivity(intent);
            }
        });

        sevenevent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.7-eleven.co.kr/event/eventView.asp"));
                startActivity(intent);
            }
        });

        sevenevent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.7-eleven.co.kr/event/eventView.asp"));
                startActivity(intent);
            }
        });

        sevenevent4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.7-eleven.co.kr/event/eventView.asp"));
                startActivity(intent);
            }
        });

        minievent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ministop.co.kr/MiniStopHomePage/page/event/eventview.do"));
                startActivity(intent);
            }
        });

        minievent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ministop.co.kr/MiniStopHomePage/page/event/eventview.do"));
                startActivity(intent);
            }
        });

        minievent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ministop.co.kr/MiniStopHomePage/page/event/eventview.do"));
                startActivity(intent);
            }
        });
    }
}