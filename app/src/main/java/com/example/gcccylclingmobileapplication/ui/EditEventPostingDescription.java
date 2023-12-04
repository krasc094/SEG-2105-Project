package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gcccylclingmobileapplication.EventManager;
import com.example.gcccylclingmobileapplication.R;

public class EditEventPostingDescription extends AppCompatActivity {

    Spinner selectEventSpinner;
    EditText regionEditText;
    EditText enterDateOfEvent;
    EditText enterNumberOfParticipants;
    Button saveEvent;

    EventManager EM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event_posting_description);

        selectEventSpinner = (Spinner) findViewById(R.id.selectEventPosting);
        regionEditText = findViewById(R.id.region);
        enterDateOfEvent = findViewById(R.id.enterDateOfEvent);
        enterNumberOfParticipants = findViewById(R.id.numberOfParticipants);
        saveEvent = findViewById(R.id.saveContact);
        EM = new EventManager();

        saveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}