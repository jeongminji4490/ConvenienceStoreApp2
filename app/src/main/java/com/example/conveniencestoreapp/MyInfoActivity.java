package com.example.conveniencestoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MyInfoActivity extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        db=FirebaseFirestore.getInstance();
        DocumentReference docRef=db.collection("users").document("\n" +
                "5uPDm8kAXSLt0qQmEckh\n");
        
        //FirebaseUser user;
        //FirebaseFirestore db=FirebaseFirestore.getInstance();

        //user= FirebaseAuth.getInstance().getCurrentUser();


        //if (user!=null)
        //{
            //String emailText2=user.getEmail();
            //boolean emailVerified=user.isEmailVerified();
            //String uid=user.getUid();
        //}

    }
}