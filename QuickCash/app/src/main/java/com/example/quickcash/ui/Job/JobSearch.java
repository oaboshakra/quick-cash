package com.example.quickcash.ui.Job;
import com.example.quickcash.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.models.Job;
import com.example.quickcash.ui.home.HomePage;
import com.example.quickcash.util.FireBaseConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class JobSearch extends AppCompatActivity {
    private EditText searchByName;
    private Button search, apply,back;
    private TextView name, Location, TimeZone, Wage, JobOwner;

    private DatabaseReference firebaseDBRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
        search.setOnClickListener(view -> {
            final String searchByNameString = searchByName.getText().toString();
            if (!searchByNameString.trim().isEmpty()) {
                searchJob(searchByNameString);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });
    }

    private void init(){
        searchByName = findViewById(R.id.searchName);
        search = findViewById(R.id.searchBUTTON);
        name = findViewById(R.id.name);
        Location = findViewById(R.id.Location);
        TimeZone = findViewById(R.id.TimeZone);
        firebaseDBRef = FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL).getReference();
        apply = findViewById(R.id.buttonApply);
        apply.setVisibility(View.GONE);
        Wage = findViewById(R.id.Wage);
        back = findViewById(R.id.back);
        JobOwner = findViewById(R.id.jobOwner);
    }

    private void searchJob(String searchByNameString) {
        final Query nameQuery = firebaseDBRef.child("Jobs")
                .orderByChild("name")
                .equalTo(searchByNameString);

        nameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists() && snapshot.getChildrenCount() > 0) {
                    final Job job;

                    for (DataSnapshot currentSnapShot : snapshot.getChildren()) {
                        job = currentSnapShot.getValue(Job.class);
                        if (job != null) {
                            apply.setVisibility(View.VISIBLE);
                            name.setText(String.format("Name: %s", job.getName()));
                            Location.setText(String.format("Location: %s", job.getLocation()));
                            TimeZone.setText(String.format("TimeZone: %s", job.getTimeZone()));
                            Wage.setText(String.format("Wage: %s", job.getWage()));
                            JobOwner.setText(String.format("JobOwner: %s", job.getJobOwner()));
                            apply.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getApplicationContext(), ApplyJobActivity.class);
                                    intent.putExtra("Job", job.getName());
                                    startActivity(intent);
                                }
                            });
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
}
