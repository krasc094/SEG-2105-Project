package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gcccylclingmobileapplication.R;

public class ClubDescription extends AppCompatActivity {
    TextView socialMedia;
    TextView clubName;
    TextView contactName;
    TextView phoneNumber;
    Button deleteClub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_description);

        socialMedia = findViewById(R.id.socialMediaView);
        clubName = findViewById(R.id.clubNameView);
        contactName = findViewById(R.id.contactNameView);
        phoneNumber = findViewById(R.id.phoneNumberView);
        deleteClub = findViewById(R.id.deleteClub);

        deleteClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AccountManager delete account
            }
        });


    }
}