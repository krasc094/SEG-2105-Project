package com.example.gcccylclingmobileapplication;

import com.example.gcccylclingmobileapplication.Account;

public class ParticipantAccount extends Account {

    public ParticipantAccount(){};
    public ParticipantAccount(String email) {
        this.email = email;
    }
    public boolean createAccount() {
        // implement later
        return false;
    }

    public String getRole(){ return "Participant"; }

}
