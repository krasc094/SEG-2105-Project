package com.example.gcccylclingmobileapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createAccount {

    private LoggedInUser user = null;

    private void setLoggedInUser(LoggedInUser user){
        this.user = user;
    }
    public Result<LoggedInUser> register(String username,String password, String email, String role){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference newUserRoleRef = database.getReference("users/"+username+"/role");
        DatabaseReference newUserEmailRef = database.getReference("users/"+username+"/email");
        DatabaseReference newUserPasswordRef = database.getReference("users/"+username+"/password");

        newUserRoleRef.setValue(role);
        newUserEmailRef.setValue(email);
        newUserPasswordRef.setValue(password);


        return register;
    }
}
