package com.example.gcccylclingmobileapplication;

// firebase urL: https://project-for-seg-default-rtdb.firebaseio.com
// firebase key: AIzaSyAa51clJlgIYvsx5iWd_FitokXAgiDXPSU

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseRegistrar;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AccountManager {

    // TO-DO
    // implement everything
    // comment and organize methods

    private Account loggedInAccount = null;
    private Context lastActivity;
    public AccountManager() {}

    public void createAccount(Account account, String password, Function onSuccessFunction) {
        // accounts are expected to at least have:
        // username
        // email
        // password
        // type

        boolean anyInvalidFields = account.getEmail() == null || account.getUsername() == null || account.getRole() == null || password == null;
        if (anyInvalidFields) {
            // missing arguments, createAccount fails
            System.out.println("createAccount is missing arguments!");
            System.out.println(account.getEmail() + ", " + account.getUsername() + ", " + password);
            return;
        }

        setLoggedInAccount( account );

        FirebaseAuth mAuth = FirebaseAuth.getInstance(); // get ref to firebase auth server

        mAuth.createUserWithEmailAndPassword(account.getEmail(), password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // create account success
                            createAccountOnSuccess( mAuth.getCurrentUser() );

                        } else {
                            // account creation failed
                            createAccountOnFailure( task.getException() );
                        }
                    }
                });
    
    }

    public Account getAccount(String uid) {
        Account account;

        // get account from uid
        // get account details from database + uid
        // get account type from account details
        // create different account type based off of type in details
        // set details on account object
        // return account object
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("users").child("uid").child(uid);

        int testVal = 0;
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return null;
    }



    protected boolean deleteAccount(String uid) {
        // implement later
        return false;
    }

    public void logIn(String uid) {}

    private void setLoggedInAccount(Account account) {
        this.loggedInAccount = account;
    }

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    private void createAccountOnSuccess(FirebaseUser user, Function<Object, Object> onSuccessFunction) {
        createAccountOnSuccess(user);
        onSuccessFunction.apply(null);
    }
    private void createAccountOnSuccess(FirebaseUser user) {
        Log.d(TAG, "createUserWithEmail:success");

        // final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        loggedInAccount.setUID( user.getUid() );

        // set account details in database
        final FirebaseDatabase db = FirebaseDatabase.getInstance();

        DatabaseReference ref = db.getReference("users/id"); // get reference to '/users/uid/' directory

        Map<String, Account> users = new HashMap<>(); // create local hash map
        users.put(loggedInAccount.getUID(), loggedInAccount); // put data in local hash map as / <UID> -> account

        ref.setValue(users); // put hash map in database at /users/uid/ directory
        // ref.child("uid").child( loggedInAccount.getUID() ).setValue( loggedInAccount ); // directly set data
    }

    private void createAccountOnFailure(Exception e) {
        Log.w(TAG,  "createUserWithEmail:failure", e);

        setLoggedInAccount( null );

    }

    public void deleteAccountOnSuccess() {}

    public void deleteAccountOnFailure() {}

}
