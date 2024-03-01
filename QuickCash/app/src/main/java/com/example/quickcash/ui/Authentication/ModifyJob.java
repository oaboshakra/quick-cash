package com.example.quickcash.ui.Authentication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;
import com.example.quickcash.util.FireBaseConstants;
public class ModifyJob extends AppCompatActivity {
    private EditText name, Location, TimeZone, Wage;
    private Button add;
    private DatabaseReference firebaseDBRef;

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
    }

    private void attachListeners() {
        add.setOnClickListener(view -> addDataToFRTD());
    }


    private void addDataToFRTD() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("Location", Location.getText().toString());
        map.put("TimeZone", TimeZone.getText().toString());
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
