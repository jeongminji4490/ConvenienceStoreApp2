package com.example.conveniencestoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    Button OkBtn,findPwd;
    private EditText EditEmail,EditPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        OkBtn=(Button)findViewById(R.id.OkBtn);
        findPwd=(Button)findViewById(R.id.findPwd);

        EditEmail=(EditText)findViewById(R.id.EditEmail);
        EditPassword=(EditText)findViewById(R.id.EditPassword);
        firebaseAuth=FirebaseAuth.getInstance(); //FirebaseAuth의 인스턴스를 가져옴

        findPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


        OkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=EditEmail.getText().toString().trim();
                String password=EditPassword.getText().toString().trim();
                //String형 변수 email.password(edittext에서 받아오는 값)으로 로그인하는것

                if(email.isEmpty() || password.isEmpty()){ //이메일과 비밀번호 란이 공백일 경우
                    Toast.makeText(LoginActivity.this,"아이디와 비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return; //로그인 안되도록!
                }
                else{ //공백 아니면
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){ //로그인 성공했을 때
                                Intent intent=new Intent(LoginActivity.this,MainActivity2.class);
                                startActivity(intent);
                                finish(); //현재 액티비티 종료, 문제시 삭제
                            }
                            else{ //실패했을 때
                                Toast.makeText(LoginActivity.this,"존재하지 않는 이메일과 비밀번호입니다.",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    void showDialog (){
        final EditText et=new EditText(LoginActivity.this);
        AlertDialog.Builder ad=new AlertDialog.Builder(LoginActivity.this).setTitle("비밀번호 찾기").setMessage("이메일 입력").setView(et).setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email2=et.getText().toString().trim(); //et로 입력된 이메일을 email2로 가져옴

                //비밀번호 재설정 메일 보냄//
                firebaseAuth.sendPasswordResetEmail(email2).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){ //해당하는 이메일이 데이터베이스에 있으면
                            Intent intent=new Intent(LoginActivity.this,FindPasswordActivity.class);
                            startActivity(intent);
                            finish(); //현재 액티비티 종료
                        }
                        else{ //없으면
                            Toast.makeText(LoginActivity.this,"존재하지 않는 이메일입니다.",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        AlertDialog rad=ad.create();
        rad.show();
    }
}