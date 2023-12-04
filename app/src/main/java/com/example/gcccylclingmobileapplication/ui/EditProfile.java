package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.gcccylclingmobileapplication.R;

public class EditProfile extends AppCompatActivity {
    Spinner selectSocialMediaType;
    EditText socialMediaLink;
    EditText mainContact;
    EditText phoneNumber;
    Button saveContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        selectSocialMediaType = (Spinner) findViewById(R.id.selectSocialMediaType);
        socialMediaLink = findViewById(R.id.socialMediaLink);
        mainContact = findViewById(R.id.mainContactName);
        phoneNumber = findViewById(R.id.phoneNumber);
        saveContactButton = findViewById(R.id.saveContact);



        saveContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContact();
            }
        });

    }

    public void addContact(){

    }
}