package com.example.gcccylclingmobileapplication;

import com.example.gcccylclingmobileapplication.Account;

public class ParticipantAccount extends Account {

    final String role = "Participant";
    public ParticipantAccount(){};
    public ParticipantAccount(String email) {
        this.email = email;
    }
    public boolean createAccount() {
        // implement later
        return false;
    }

    // getters and setters
    public String getRole(){ return "Participant"; }

}
