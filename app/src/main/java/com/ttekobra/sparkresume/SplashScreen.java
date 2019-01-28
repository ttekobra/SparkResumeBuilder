package com.ttekobra.sparkresume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ttekobra.sparkresume.Auth.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    FirebaseUser user;
    FirebaseAuth firebaseAuth;
    String userUID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        FirebaseApp.initializeApp(SplashScreen.this);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            user = firebaseAuth.getCurrentUser();
            userUID = user.getUid();
            Toast.makeText(SplashScreen.this, userUID, Toast.LENGTH_SHORT).show();
            if (!userUID.isEmpty()) {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        } catch (Exception e) {
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
