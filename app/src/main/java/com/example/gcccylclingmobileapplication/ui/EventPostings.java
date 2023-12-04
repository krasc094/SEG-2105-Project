package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.gcccylclingmobileapplication.R;

import java.util.Scanner;

public class EventPostings extends AppCompatActivity {
    Button postNewEvent;
    Button openEventPosting;
    Spinner eventPostings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_postings);
        postNewEvent = (Button) findViewById(R.id.postNewEvent);
        openEventPosting = (Button) findViewById(R.id.openEventPosting);
        eventPostings = (Spinner) findViewById(R.id.selectEventPosting);
        postNewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        openEventPosting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}