package com.example.quickcash.ui.JobPosting;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quickcash.R;
import com.example.quickcash.models.Job;
import com.example.quickcash.ui.MainActivity;
import com.example.quickcash.util.FireBaseConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class PostJobFragment extends AppCompatActivity {

    public EditText etJobName;
    public EditText etHoursRequired;
    public EditText etHourlyWage;
    public EditText etSkillsNeeded;
    public Button etButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postjob);

        // Initialize EditText fields
        etJobName = findViewById(R.id.etJobName);
        etHoursRequired = findViewById(R.id.etHoursRequired);
        etHourlyWage = findViewById(R.id.etHourlyWage);
        etSkillsNeeded = findViewById(R.id.etSkillsNeeded);
        etButton = findViewById(R.id.btnCreateJob);
        setUpListeners();
    }

    private void setUpListeners() {
        etButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button clicked", Toast.LENGTH_LONG).show();
                Job job = new Job("nith2411@gmail.com" ,
                        etJobName.getText().toString().trim() ,
                        Integer.parseInt(etHoursRequired.getText().toString().trim()),
                        Integer.parseInt(etHourlyWage.getText().toString().trim()) ,
                        etSkillsNeeded.getText().toString()
                );
                FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL).getReference().child(FireBaseConstants.JOB_COLLECTION).child(UUID.randomUUID().toString())
                        .setValue(job).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Job posted", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Job not posted", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                Toast.makeText(getApplicationContext(), "Button clicked twice", Toast.LENGTH_LONG).show();

            }
        });




    }

    // Method to validate input fields
    public boolean validateInputFields() {
        String jobName = etJobName.getText().toString().trim();
        String hoursRequired = etHoursRequired.getText().toString().trim();
        String hourlyWage = etHourlyWage.getText().toString().trim();
        String skillsNeeded = etSkillsNeeded.getText().toString().trim();

        if (TextUtils.isEmpty(jobName)) {
            etJobName.setError("Job name cannot be empty");
            return false;
        }

        if (TextUtils.isEmpty(hoursRequired)) {
            etHoursRequired.setError("Hours required cannot be empty");
            return false;
        }

        if (TextUtils.isEmpty(hourlyWage)) {
            etHourlyWage.setError("Hourly wage cannot be empty");
            return false;
        }

        if (TextUtils.isEmpty(skillsNeeded)) {
            etSkillsNeeded.setError("Skills needed cannot be empty");
            return false;
        }

        return true;
    }
}
