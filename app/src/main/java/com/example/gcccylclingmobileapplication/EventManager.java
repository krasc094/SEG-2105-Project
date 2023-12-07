package com.example.gcccylclingmobileapplication;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseRegistrar;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EventManager {
    // event array list

    public void createEvent(Event event) {

        //possibly working.

        // missing arguments, createEvent fails
        boolean anyInvalidFields = event.getName() == null || event.getType() == null || event.getRequirements() == null;
        if (anyInvalidFields) {
            // missing arguments, createAccount fails
            System.out.println("createEvent is missing arguments!");

            // System.out.println(event.getName() + ", " + event.getType() + ", " + event.getRequirements());
            return;
        }

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("events"); // get reference to '/events' directory

        Map<String, Event> events = new HashMap<>(); // create local hash map
        events.put(event.getEID(), event); // put data in local hash map as / <UID> -> account

        ref.setValue(events);
        //ref.child(event.getEID()).setValue(events);// put hash map in database at /events/ directory
    }

    public void deleteEvent(Event event) {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("events").child ( event.getEID() );

        ref.removeValue();
    }

    public void editEvent(Event event, String newName, String newType, String[] newRequirements) {

        //Setting up reference to specific event in database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference eventRef = database.getReference("events").child( event.getEID() );

        //Updating the event
        if (newName != null) {
            event.setName( newName );
        }

        if (newType != null) {
            event.setType( newType );
        }

        if (newRequirements != null) {
            event.setRequirements( newRequirements );
        }

        //Creating new hashmap with new values
        Map<String, Object> eventUpdates = new HashMap<>();
        eventUpdates.put(event.getEID(), event);

        //Committing new updates to database
        eventRef.updateChildren(eventUpdates);
    }

    public void loadAccountData(String uid) {
        // get account from uid
        // get account details from database + uid
        // get account type from account details
        // create different account type based off of type in details
        // set details on account object
        // return account object

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users").child("uid").child(uid);

        int testVal = 0;
        ref.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    // data retrieved
                    DataSnapshot data = task.getResult();
                    String role = data.child("role").getValue(String.class);

                    Account account;


                } else {
                    // failed

                    // implement later

                }
            }
        });
    }


}
