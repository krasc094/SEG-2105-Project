package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.gcccylclingmobileapplication.R;
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
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(this, SignupScreen.class);
            startActivity(intent);
        } else {
            // no user is signed in
            Intent intent = new Intent(this, LoginScreen.class);
            startActivity(intent);
        }
    }
}