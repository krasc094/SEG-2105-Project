package com.example.gcccylclingmobileapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        private Spinner spinner_roles;
        private FirebaseAuth mAuth;
        EditText etUsername, etEmail, etPassword;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            // connect to firebase auth server
            mAuth = FirebaseAuth.getInstance();

            // register EditText with their ids
            etUsername = findViewById(R.id.usernameField);
            etEmail = findViewById(R.id.emailField);
            etPassword = findViewById(R.id.passwordField);

            // init dropdown spinner
            spinner_roles = findViewById(R.id.dropdown_roles);

            String[] accountType = getResources().getStringArray(R.array.account_type);
            ArrayAdapter adapter = new ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, accountType);
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

        public void onSignUpButtonClick(View view) {
            checkAllFields();
        }

        private boolean checkAllFields() {
            boolean valid = true;
            if (etUsername.length() == 0) {
                etUsername.setError("This field is required");
                valid = false;
            }

            if (etEmail.length() == 0) {
                etEmail.setError("Email is required");
                valid = false;
            }

            if (etPassword.length() == 0) {
                etPassword.setError("Password is required");
                valid = false;
            } else if (etPassword.length() < 6) {
                etPassword.setError("Password must be minimum 6 characters");
                valid = false;
            }

            return valid;
        }

        protected boolean createAccount(String email, String password) {
            boolean success = false;
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // create account success
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                            } else {
                                // create account fail
                                Log.w(TAG,  "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignupScreen.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            return success;
        }


    }
