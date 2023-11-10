package com.example.gcccylclingmobileapplication;

import androidx.annotation.NonNull;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseRegistrar;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class EventManager {
    // event array list

    public void createEvent(Event event) {

        //possibly working.

        boolean anyInvalidFields = event.getName() == null || event.getType() == null || event.getRequirements() == null;
        if (anyInvalidFields) {
            // missing arguments, createAccount fails
            System.out.println("createEvent is missing arguments!");
            System.out.println(event.getName() + ", " + event.getType() + ", " + event.getRequirements());
            return;
        }

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("events");

        Map<String, Event> events = new HashMap<>();
        events.put(event.getName(), event);

        ref.child(event.getName()).setValue(event);
    }

    public void deleteEvent() {
        // implement later
    }

    public void editEvent() {
        // implement later
    }

}
