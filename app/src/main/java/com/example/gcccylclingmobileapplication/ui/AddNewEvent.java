package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gcccylclingmobileapplication.R;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gcccylclingmobileapplication.Event;
import com.example.gcccylclingmobileapplication.R;

public class AddNewEvent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_event);

        TextView description = findViewById(R.id.description);
        TextView event_name = findViewById(R.id.event_name_input);
        Spinner pace_spinner = (Spinner) findViewById(R.id.selectPace);
        Spinner difficulty_spinner = (Spinner) findViewById(R.id.selectDifficulty);
        Spinner minimumAge_spinner = (Spinner) findViewById(R.id.selectAge);
        Spinner type_spinner = (Spinner) findViewById(R.id.selectType);
        Button addEvent = findViewById(R.id.addEvent);

        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.event_types_spinner, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> difficultyAdapter = ArrayAdapter.createFromResource(this, R.array.difficulty_spinner, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> ageAdapter = ArrayAdapter.createFromResource(this, R.array.minimumAge_spinner, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> paceAdapter = ArrayAdapter.createFromResource(this, R.array.pace_spinner, android.R.layout.simple_spinner_item);

        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pace_spinner.setAdapter(paceAdapter);
        difficulty_spinner.setAdapter(difficultyAdapter);
        minimumAge_spinner.setAdapter(ageAdapter);
        type_spinner.setAdapter(typeAdapter);

        pace_spinner.setOnItemSelectedListener(this);
        difficulty_spinner.setOnItemSelectedListener(this);
        minimumAge_spinner.setOnItemSelectedListener(this);
        type_spinner.setOnItemSelectedListener(this);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] event_requirements = new String[4];
                event_requirements[0] = pace_spinner.getSelectedItem().toString();
                event_requirements[1] = difficulty_spinner.getSelectedItem().toString();
                event_requirements[2] = minimumAge_spinner.getSelectedItem().toString();
                event_requirements[3] = description.toString();

                String type = type_spinner.getSelectedItem().toString();

                String name = event_name.toString();

                //create/add event with values;

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


