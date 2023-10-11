package com.example.gcccylclingmobileapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.R;

public class CyclingClubAccount extends AppCompatActivity {

    String selectedRole;
    String firstName;
    String lastName;
    String username;
    String password;
    String email;

    public CyclingClubAccount(){
        this.selectedRole = getAccountInfo()[0];
        this.email = getAccountInfo()[1];
        this.username = getAccountInfo()[2];
        this.password = getAccountInfo()[3];
    }

    private Spinner rolesSpinner;
    private EditText emailEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up); // Assuming your XML file is named activity_signup_screen.xml

        rolesSpinner = findViewById(R.id.spinner_roles);
        emailEditText = findViewById(R.id.email);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        signupButton = findViewById(R.id.signup_button);


    }
    public String[] getAccountInfo() {
        // Handle signup button click event here
        String selectedRole = rolesSpinner.getSelectedItem().toString();
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        String[] accountInfo = new String[4];
        accountInfo[0] = selectedRole;
        accountInfo[1] = email;
        accountInfo[2] = username;
        accountInfo[3] = password;

        return accountInfo;
    }
    
    public boolean logIn(){
        return false;
    }

    public String getSelectedRole(){
        return this.selectedRole;
    }
    public String getEmail(){
        return this.email;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    
}

