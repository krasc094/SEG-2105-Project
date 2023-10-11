package com.example.gcccylclingmobileapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

abstract class Account {

    String message;
    String firstName;
    String lastName;
    String username;
    String password;

    public boolean logIn() {
        return false;
    }

    public String getMessage() {
        return message;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }


}
