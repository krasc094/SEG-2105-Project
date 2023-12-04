package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gcccylclingmobileapplication.R;

public class EventDescription extends AppCompatActivity {
    TextView name;
    TextView description;
    TextView age;
    TextView pace;
    TextView difficulty;
    Button editEvent;
    Button deleteEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        name = findViewById(R.id.nameOfEvent);
        description = findViewById(R.id.eventDescription);
        age = findViewById(R.id.eventAge);
        pace = findViewById(R.id.eventPace);
        difficulty = findViewById(R.id.eventDifficulty);

        editEvent = (Button) findViewById(R.id.editEvent);
        deleteEvent = (Button) findViewById(R.id.deleteEvent);

        editEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditPostingDescription();
            }
        });
        deleteEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create Event
                //Event Manager delete account
            }
        });
    }
    public void openEditPostingDescription(){
        Intent intent = new Intent(this, EditEventPostingDescription.class);
        startActivity(intent);
    }
}