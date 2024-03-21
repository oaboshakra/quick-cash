package com.example.quickcash.ui.Job;
import com.example.quickcash.util.DataValidator;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.R;
import com.example.quickcash.models.Job;
import com.example.quickcash.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;
import com.example.quickcash.util.FireBaseConstants;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ModifyJob extends AppCompatActivity {
    private EditText name, Location, TimeZone, Wage;
    private Button add;
    private DatabaseReference firebaseDBRef;

    private boolean nameNull,tzNull, wageNull,locNull;
    private String userName;
    private String emailId = "nt477834@dal.ca";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjob);
        init();
        attachListeners();
    }

    private void init() {
        name = findViewById(R.id.name);
        Location = findViewById(R.id.Location);
        TimeZone = findViewById(R.id.TimeZone);
        Wage = findViewById(R.id.Wage);
        add = findViewById(R.id.add);
        firebaseDBRef = FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL).getReference();
        Bundle extras = getIntent().getExtras();
        emailId = extras.getString("emailid");
        searchNameByEmail(emailId);


    }

    private void attachListeners() {
        add.setOnClickListener(view -> addDataToFRTD());
    }


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
                Log.e("SearchActivity", error.getMessage());
            }
        });
    }

    private void getUserName(String fname, String Lname){
        userName = fname+" "+Lname;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }


}

