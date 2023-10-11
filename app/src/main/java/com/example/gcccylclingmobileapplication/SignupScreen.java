package com.example.gcccylclingmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SignupScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        private Spinner spinner_roles;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            spinner_roles = findViewById(R.id.spinner_roles);

            String[] userRoles = getResources().getStringArray(R.array.user_roles);
            ArrayAdapter adapter = new ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, userRoles);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_roles.setAdapter(adapter);

        }
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String selectedRole = adapterView.getItemAtPosition(i).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

    }
