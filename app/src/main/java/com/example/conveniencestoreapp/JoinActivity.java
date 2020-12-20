package com.example.conveniencestoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class JoinActivity extends AppCompatActivity {

    Button joinOkBtn;
    private EditText name_join,phone_join,email_join,password_join;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        joinOkBtn=(Button)findViewById(R.id.joinOkBtn);
        name_join=(EditText)findViewById(R.id.name_join);
        phone_join=(EditText)findViewById(R.id.phone_join);
        email_join=(EditText)findViewById(R.id.email_join);
        password_join=(EditText)findViewById(R.id.phone_join);

        firebaseAuth=FirebaseAuth.getInstance();

        joinOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email=email_join.getText().toString().trim();
                final String password=password_join.getText().toString().trim();
                final String name=name_join.getText().toString().trim();
                final String phoneNum=phone_join.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(JoinActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent=new Intent(JoinActivity.this,MainActivity2.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(JoinActivity.this,"등록 에러",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
            }
        });
    }
}