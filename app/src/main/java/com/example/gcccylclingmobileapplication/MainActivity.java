package com.example.gcccylclingmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            // user is signed in
            Intent intent = new Intent(this, WelcomeScreen.class);
            startActivity(intent);
        } else {
            // no user is signed in
            Intent intent = new Intent(this, LoginScreen.class);
            startActivity(intent);
        }
    }
}