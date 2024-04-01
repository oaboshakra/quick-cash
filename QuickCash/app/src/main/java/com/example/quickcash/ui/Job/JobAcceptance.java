package com.example.quickcash.ui.Job;

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

import com.example.quickcash.R;
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

/**
 * Activity for accepting or canceling job applications.
 * This activity allows employers to search for job applications and take actions like accepting or canceling them.
 */
public class JobAcceptance extends AppCompatActivity {
    private EditText searchByName;
    private Button search, back, acceptance, completion, cancel;
    private TextView jobName, employeeName, employeePhone, employeeEmail, status, statusLabel;

    private DatabaseReference firebaseDBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobacceptance);

        // Initialize UI elements
        init();

        /**
         * This is the onClick Listener for the search button.
         * This gets the string to search from the text field and calls the search
         * Job function with the string xtracted from the text field.
         */
        search.setOnClickListener(view -> {
            final String searchByNameString = searchByName.getText().toString();
            if (!searchByNameString.trim().isEmpty()) {
                searchJob(searchByNameString);
            }
        });

        // OnClickListener for the Back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });
    }

    /**
     * This method initializes all the  UI elements of the registeratio page.
     * UI elements initialized :
     *       |----> Text field : searchByName , employeName , employePhone , employeEmail , status
     *       |----> Button : Search , job accept button , cancel button .
     *       |----> Spinner : User Role options spinner
     */
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

    /**
     * This is the function that holds query to search for the job with the data is the Job collection.
     * This function also holds two call back functions for the buttom's eventListeners : Button cancel and accept job.
     * @param searchByNameString  A string entered in the search text field to search.
     */
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
                            // Show buttons for actions
                            cancel.setVisibility(View.VISIBLE);
                            acceptance.setVisibility(View.VISIBLE);
                            completion.setVisibility(View.VISIBLE);

                            // Display job application details
                            jobName.setText(String.format("Job Name: %s", jobAcceptance.getJobName()));
                            employeeName.setText(String.format("Employee Name: %s", jobAcceptance.getEmployeeName()));
                            employeePhone.setText(String.format("Employee Phone: %s", jobAcceptance.getEmployeePhone()));
                            employeeEmail.setText(String.format("Employee Email: %s", jobAcceptance.getEmployeeEmail()));
                            status.setText(String.format("Status: %s", jobAcceptance.getStatus()));

                            DatabaseReference jobKey = currentSnapShot.getRef();

                            /**
                             * This is the onClick call back function for the cancel button ,
                             */
                            cancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // Update status to "Cancel" and update database
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

                            /**
                             * This is the onClick call back function for the accept buttom ,
                             */
                            acceptance.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // Update status to "Acceptance" and update database
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

                            /**
                             * This is the onClick call back function for the complete buttom ,
                             */
                            completion.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // Update status to "Completion" and update database
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
