package com.example.quickcash.ui.Job;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quickcash.R;
import com.example.quickcash.models.User;
import com.example.quickcash.util.FireBaseConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Activity for modifying job details.
 * This activity allows users to modify job details such as name, location, time zone, and wage.
 */
public class ModifyJob extends AppCompatActivity {
    private EditText name, Location, TimeZone, Wage;
    private Button add;
    private DatabaseReference firebaseDBRef;

    private String userName;
    private String emailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjob);
        init();
        attachListeners();
    }

    /**
     * This method initializes all the  UI elements of the registeratio page.
     * UI elements initialized :
     *       |----> Text field : name , location , timeZone , wage
     *       |----> Button : add
     *       |----> Spinner : NIL.
     */
    private void init() {
        name = findViewById(R.id.name);
        Location = findViewById(R.id.Location);
        TimeZone = findViewById(R.id.TimeZone);
        Wage = findViewById(R.id.Wage);
        add = findViewById(R.id.add);
        firebaseDBRef = FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL).getReference();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            emailId = extras.getString("emailid");
            searchNameByEmail(emailId);
        }
    }

    /**
     * Attaches click listener to the add button.
     */
    private void attachListeners() {
        add.setOnClickListener(view -> addDataToFRTD());
    }

    /**
     * This function holds the query to add a job to the firebase collection .
     * It create a hashmap with these field : name, location, timezone, jobowner, wage of the job
     * If the job was added properly in the firebase , a proper message is notified to the user properly
     * else a unSuccessfull message is also notified to the user using Toast.
     */
    private void addDataToFRTD() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("Location", Location.getText().toString());
        map.put("TimeZone", TimeZone.getText().toString());
        map.put("jobOwner", userName);
        map.put("Wage", Wage.getText().toString());
        FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL)
                .getReference()
                .child("Jobs")
                .push()
                .setValue(map)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(getApplicationContext(), "Job added successfully", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(getApplicationContext(), "Job insertion failed", Toast.LENGTH_SHORT).show());
    }

    /**
     * Searches for the user's name based on the email.
     * This function holds the firebase query to search in the Users collection.
     * If teh user the user is found , the user is returned else  a proper error message is displayed.
     * @param email The user's email
     */
    private void searchNameByEmail(String email) {
        final Query emailQuery = firebaseDBRef.child("Users")
                .orderByChild("email")
                .equalTo(email);

        emailQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists() && snapshot.getChildrenCount() > 0) {
                    final User user;

                    for (DataSnapshot currentSnapShot : snapshot.getChildren()) {
                        user = currentSnapShot.getValue(User.class);
                        if (user != null) {
                            getUserName(user.getFirstName(), user.getLastName());
                        }
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ModifyJob", error.getMessage());
            }
        });
    }

    /**
     * Concatenates the user's first name and last name to get the full name.
     * @param fname The user's first name
     * @param Lname The user's last name
     */
    private void getUserName(String fname, String Lname){
        userName = fname + " " + Lname;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
