package com.example.conveniencestoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends AppCompatActivity {

    Button joinOkBtn;
    private EditText name_join,phone_join,email_join,password_join;
    private String email,password,name,phoneNum;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        joinOkBtn=(Button)findViewById(R.id.joinOkBtn);
        name_join=(EditText)findViewById(R.id.name_join);
        phone_join=(EditText)findViewById(R.id.phone_join);
        email_join=(EditText)findViewById(R.id.email_join);
        password_join=(EditText)findViewById(R.id.password_join);

        firebaseAuth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();

        joinOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp();
            }
        });
    }
    void SignUp(){
        email=email_join.getText().toString().trim();
        password=password_join.getText().toString().trim();
        name=name_join.getText().toString().trim();
        phoneNum=phone_join.getText().toString().trim();

        if(isValidEmail() && isValidPassword() && isValidName() && isValidPhoneNum()){
            createUser(email,password);
        }
        else{
            Toast.makeText(JoinActivity.this,"공백란이 하나라도 있으면 회원가입이 안됩니다 8ㅅ8",Toast.LENGTH_SHORT).show();
        }
    }

    //이메일 유효성 검사
    private boolean isValidEmail(){
        if(email.isEmpty()){
            return false;
        }
        else
            return true;
    }

    private boolean isValidPassword(){
        if(password.isEmpty()){
            return false;
        }
        else
            return true;
    }

    private boolean isValidName(){
        if(name.isEmpty()){
            return false;
        }
        else
            return true;
    }

    private boolean isValidPhoneNum(){
        if(phoneNum.isEmpty()){
            return false;
        }
        else
            return true;
    }

    //회원가입
    private void createUser(String email,String password){
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(JoinActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    //파이어스토어에 회원정보 저장//
                    Map<String,Object> user=new HashMap<>();

                    user.put("Name",name);
                    user.put("PhoneNum",phoneNum);
                    user.put("Email",email);
                    user.put("Password",password);

                    db.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("TAG","Document added with ID: "+documentReference.getId());
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("TAG","Error adding Document",e);
                        }
                    });

                    Toast.makeText(JoinActivity.this,"회원가입 성공!",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(JoinActivity.this,"회원가입 에러 ㅠㅠ",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}