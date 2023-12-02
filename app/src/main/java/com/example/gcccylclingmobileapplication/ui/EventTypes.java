package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gcccylclingmobileapplication.R;

public class EventTypes extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button addEvent_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_types);
        addEvent_button = findViewById(R.id.addEvent);
        Spinner spinner = findViewById(R.id.selectEvent);
        //Events error: Events is supposed to be the list of the events in firebase.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Events,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        addEvent_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddNewEvent();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String text = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void openAddNewEvent(){
        Intent intent = new Intent(this, AddNewEvent.class);
        startActivity(intent);
    }
}