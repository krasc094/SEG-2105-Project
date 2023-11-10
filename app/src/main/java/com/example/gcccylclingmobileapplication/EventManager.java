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

        // missing arguments, createEvent fails
        boolean anyInvalidFields = event.getName() == null || event.getType() == null || event.getRequirements() == null;
        if (anyInvalidFields) {
            // missing arguments, createAccount fails
            System.out.println("createEvent is missing arguments!");
            System.out.println(event.getName() + ", " + event.getType() + ", " + event.getRequirements());
            return;
        }

        FirebaseAuth mAuth = FirebaseAuth.getInstance(); // get ref to firebase auth server

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("events"); // get reference to '/events' directory

        Map<String, Event> events = new HashMap<>(); // create local hash map
        events.put(event.getEID(), event); // put data in local hash map as / <UID> -> account

        ref.child(event.getEID()).setValue(events);// put hash map in database at /events/ directory
    }

    public void deleteEvent(Event event) {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = database.getReference("events/" + event.getEID());

        eventRef.removeValue();
    }

    public void editEvent(Event event, String newName, String newType, String[] newRequirements) {

        //Setting up reference to specific event in database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = database.getReference("events/" + event.getEID());

        //Updating the event
        event.setName(newName);
        event.setType(newType);
        event.setRequirements(newRequirements);

        //Creating new hashmap with new values
        Map<String, Object> eventUpdates = new HashMap<>();
        eventUpdates.put(event.getEID(), event);

        //Committing new updates to database
        eventRef.child(event.getEID()).setValue(event);
    }

}
