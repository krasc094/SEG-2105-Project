package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gcccylclingmobileapplication.R;

public class AdminPageActivity extends AppCompatActivity {

    Button manageEventTypes_button;
    Button manageCyclingClubsAccounts_button;
    Button manageParticipantAccounts_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        manageEventTypes_button = (Button) findViewById(R.id.manageEventsButton);
        manageCyclingClubsAccounts_button = (Button) findViewById(R.id.manageCyclingClubAccountsButton);
        manageParticipantAccounts_button = (Button) findViewById(R.id.manageParticipantButton);

        manageEventTypes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEvent_Types_Activity();
            }
        });

        manageCyclingClubsAccounts_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openManage_Cycling_Club_Activity();
            }
        });

        manageParticipantAccounts_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openManage_Participant_Accounts_Activity();
            }
        });

    }

    public void openEvent_Types_Activity(){
        Intent intent = new Intent(this, EventTypes.class);
        startActivity(intent);
    }
    public void openManage_Cycling_Club_Activity(){
        Intent intent = new Intent(this, ManageCyclingClub.class);
        startActivity(intent);
    }
    public void openManage_Participant_Accounts_Activity(){
        Intent intent = new Intent(this, ManageCyclingClub.class);
        startActivity(intent);
    }
}