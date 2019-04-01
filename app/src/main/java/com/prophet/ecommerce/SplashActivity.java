package com.prophet.ecommerce;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FirebaseApp.initializeApp(this);

        firebaseAuth = FirebaseAuth.getInstance();
        // Sleeps this activity after 3seconds
        SystemClock.sleep(3000);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null){
            // Starts RegisterActivity
            Intent loginIntent = new Intent(SplashActivity.this, RegisterActivity.class);
            startActivity(loginIntent);
            finish();
        } else {
            // Starts RegisterActivity
            Intent loginIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }
}
