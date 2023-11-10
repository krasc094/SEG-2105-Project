package com.example.gcccylclingmobileapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public abstract class Account {

    String message;

    String firstName;
    String lastName;

    String email;
    String username;
    String uid;

    public boolean logIn() {
        return false;
    }

    // getters and setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setUsername(String username) { this.username = username; }
    public void setUID(String uid) { this.uid = uid; }


    public String getMessage() { return message; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getUID() { return uid; }

    abstract String getRole();

}
