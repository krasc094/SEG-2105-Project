package com.example.gcccylclingmobileapplication.ui;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gcccylclingmobileapplication.Account;
import com.example.gcccylclingmobileapplication.AccountManager;
import com.example.gcccylclingmobileapplication.CyclingClubAccount;
import com.example.gcccylclingmobileapplication.ParticipantAccount;
import com.example.gcccylclingmobileapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class  SignupScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        private FirebaseAuth mAuth;
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        private EditText etUsername, etEmail, etPassword;
        private Spinner roleSelector;
        private String selectedRole;

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
            roleSelector = findViewById(R.id.spinnerRoles);

            ArrayAdapter adapter = new ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    getResources().getStringArray(R.array.account_type)
                    );

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            roleSelector.setAdapter(adapter);

            roleSelector.setOnItemSelectedListener(this);
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selectedRole = adapterView.getItemAtPosition(i).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

        public void onSignUpButtonClick(View view) {

            if (!checkAllFields()) return;

            String email = String.valueOf(etEmail.getText());
            String username = String.valueOf(etUsername.getText());
            String password = String.valueOf(etPassword.getText());

            String role = selectedRole;

            AccountManager accountManager = new AccountManager();
            Account acc;

            System.out.println(role);

            if ( role.equals("Participant") ) {
                acc = new ParticipantAccount();
            } else if ( role.equals("Cycling Club") ) {
                acc = new CyclingClubAccount();
            } else {
                System.out.println("else ran");
                acc = new ParticipantAccount();
            }

            acc.setEmail( email );
            acc.setUsername( username );

            accountManager.createAccount(acc, password);
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

            // System.out.println("checked -> " + valid);
            return valid;
        }

        protected void createAccount(String email, String password) {
            boolean success = false;
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                // create account success
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                userCreated(user);

                            } else {

                                // create account fail
                                Log.w(TAG,  "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignupScreen.this, "Could not make account.",
                                        Toast.LENGTH_SHORT).show();
                                userCreated(null);

                            }
                        }
                    });
        }

        private void userCreated(FirebaseUser user) {
            if (user == null) return;

            String username = String.valueOf(etUsername.getText());
            String uid = user.getUid();

            CollectionReference users = db.collection("users");
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("username", username);
            userMap.put("role", selectedRole);
            users.document(uid).set(userMap);

            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName("username")
                    .build();

            user.updateProfile(profileUpdates);

            Intent intent = new Intent(this, WelcomeScreen.class);
            startActivity(intent);
        }

    }
