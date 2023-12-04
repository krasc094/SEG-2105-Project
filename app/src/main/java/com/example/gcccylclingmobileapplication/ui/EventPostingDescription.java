package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gcccylclingmobileapplication.R;

public class EventPostingDescription extends AppCompatActivity {
    Button editEventPosting;
    Button deleteEventPosting;
    TextView eventName;
    TextView eventDescription;
    TextView eventAge;
    TextView eventDate;
    TextView eventDifficulty;
    TextView eventPace;
    TextView eventAmountOfParticipants;
    TextView eventRegion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_posting_description);

        editEventPosting = (Button) findViewById(R.id.editEventPosting);
        deleteEventPosting = (Button) findViewById(R.id.deleteEventPosting);
        eventName = findViewById(R.id.event_posting_name);
        eventDescription = findViewById(R.id.eventPostingDescription);
        eventAge = findViewById(R.id.eventPostingAge);
        eventDate = findViewById(R.id.eventPostingDate);
        eventDifficulty = findViewById(R.id.eventPostingDifficulty);
        eventPace = findViewById(R.id.eventPostingPace);
        eventAmountOfParticipants = findViewById(R.id.eventPostingAmountParticipants);
        eventRegion = findViewById(R.id.eventPostingRegion);

        editEventPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        deleteEventPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}