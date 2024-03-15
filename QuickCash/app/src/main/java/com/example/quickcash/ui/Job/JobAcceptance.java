package com.example.quickcash.ui.Job;
import com.example.quickcash.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.models.JobApplication;
import com.example.quickcash.ui.home.HomePage;
import com.example.quickcash.util.FireBaseConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class JobAcceptance extends AppCompatActivity {
    private EditText searchByName;
    private Button search, back, acceptance, completion, cancel;
    private TextView jobName, employeeName, employeePhone, employeeEmail, status, statusLabel;

    private DatabaseReference firebaseDBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_jobacceptance);

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
        search = findViewById(R.id.search_btn);
        jobName = findViewById(R.id.jobName);
        employeeName = findViewById(R.id.employeeName);
        employeePhone = findViewById(R.id.employeePhone);
        employeeEmail = findViewById(R.id.employeeEmail);
        status = findViewById(R.id.status);
        firebaseDBRef = FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL).getReference();
        acceptance = findViewById(R.id.acceptance_btn);
        completion = findViewById(R.id.completion_btn);
        cancel = findViewById(R.id.cancel_btn);
        acceptance.setVisibility(View.GONE);
        completion.setVisibility(View.GONE);
        cancel.setVisibility(View.GONE);
        back = findViewById(R.id.back);
        statusLabel = findViewById(R.id.statusLabel);
        statusLabel.setVisibility(View.GONE);
    }

    private void searchJob(String searchByNameString) {
        final Query nameQuery = firebaseDBRef.child("JobApplication")
                .orderByChild("jobName")
                .equalTo(searchByNameString);

        nameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists() && snapshot.getChildrenCount() > 0) {
                    final JobApplication jobAcceptance;

                    for (DataSnapshot currentSnapShot : snapshot.getChildren()) {
                        jobAcceptance = currentSnapShot.getValue(JobApplication.class);
                        if (jobAcceptance != null) {
                            cancel.setVisibility(View.VISIBLE);
                            acceptance.setVisibility(View.VISIBLE);
                            completion.setVisibility(View.VISIBLE);
                            jobName.setText(String.format("Job Name: %s", jobAcceptance.getJobName()));
                            employeeName.setText(String.format("Employee Name: %s", jobAcceptance.getEmployeeName()));
                            employeePhone.setText(String.format("Employee Phone: %s", jobAcceptance.getEmployeePhone()));
                            employeeEmail.setText(String.format("Employee Email: %s", jobAcceptance.getEmployeeEmail()));
                            status.setText(String.format("Status: %s", jobAcceptance.getStatus()));
                            DatabaseReference jobKey = currentSnapShot.getRef();
                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    status.setText("Status: Cancel");
                                    jobAcceptance.setStatus("Cancel");
                                    statusLabel.setText("Cancel");
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("jobName", jobAcceptance.getJobName());
                                    map.put("employeeName", jobAcceptance.getEmployeeName());
                                    map.put("employeePhone", jobAcceptance.getEmployeePhone());
                                    map.put("employeeEmail", jobAcceptance.getEmployeeEmail());
                                    map.put("status", "Cancel");
                                    jobKey.updateChildren(map);
                                    Toast.makeText(JobAcceptance.this, "Cancel Success" ,Toast.LENGTH_SHORT).show();
                                }
                            });

                            acceptance.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    status.setText("Status: Acceptance");
                                    jobAcceptance.setStatus("Acceptance");
                                    statusLabel.setText("Acceptance");
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("jobName", jobAcceptance.getJobName());
                                    map.put("employeeName", jobAcceptance.getEmployeeName());
                                    map.put("employeePhone", jobAcceptance.getEmployeePhone());
                                    map.put("employeeEmail", jobAcceptance.getEmployeeEmail());
                                    map.put("status", "Acceptance");
                                    jobKey.updateChildren(map);
                                    Toast.makeText(JobAcceptance.this, "Acceptance Success" ,Toast.LENGTH_SHORT).show();
                                }
                            });

                            completion.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    status.setText("Status: Completion");
                                    jobAcceptance.setStatus("Completion");
                                    statusLabel.setText("Completion");
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("jobName", jobAcceptance.getJobName());
                                    map.put("employeeName", jobAcceptance.getEmployeeName());
                                    map.put("employeePhone", jobAcceptance.getEmployeePhone());
                                    map.put("employeeEmail", jobAcceptance.getEmployeeEmail());
                                    map.put("status", "Completion");
                                    jobKey.updateChildren(map);
                                    Toast.makeText(JobAcceptance.this, "Completion Success" ,Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("JobAcceptanceActivity", error.getMessage());
            }
        });
    }
}
