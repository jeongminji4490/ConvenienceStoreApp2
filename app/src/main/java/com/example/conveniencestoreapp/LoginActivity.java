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

public class LoginActivity extends AppCompatActivity {

    Button joinBtn,OkBtn;
    private EditText EditEmail,EditPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        joinBtn=(Button)findViewById(R.id.joinBtn);
        OkBtn=(Button)findViewById(R.id.OkBtn);
        EditEmail=(EditText)findViewById(R.id.EditEmail);
        EditPassword=(EditText)findViewById(R.id.EditPassword);
        firebaseAuth=FirebaseAuth.getInstance(); //FirebaseAuth의 인스턴스를 가져옴

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(intent);
            }
        });

        OkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=EditEmail.getText().toString().trim();
                String password=EditPassword.getText().toString().trim();
                //String형 변수 email.password(edittext에서 받아오는 값)으로 로그인하는것

                //이메일과 비밀번호가 공백일 경우에도 오류메세지를 보여주어야 함!
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){ //성공했을 때
                            Intent intent=new Intent(LoginActivity.this,MainActivity2.class);
                            startActivity(intent);
                        }
                        else{ //실패했을 때
                            Toast.makeText(LoginActivity.this,"로그인 오류",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}