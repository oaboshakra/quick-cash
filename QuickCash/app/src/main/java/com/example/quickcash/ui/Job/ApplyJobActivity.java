package com.example.quickcash.ui.Job;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quickcash.MainActivity;
import com.example.quickcash.R;
import com.example.quickcash.models.User;
import com.example.quickcash.models.JobApplication;
import com.example.quickcash.ui.home.HomePage;
import com.example.quickcash.util.AppConstants;
import com.example.quickcash.util.DataValidator;
import com.example.quickcash.util.FireBaseConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class ApplyJobActivity extends AppCompatActivity {
    private String message = "";
    private DatabaseReference firebaseDBRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_applyjob);

        Button applyBtn = findViewById(R.id.apply_btn);
        Button backBtn = findViewById(R.id.back_btn);
        Bundle extras = getIntent().getExtras();
        String jobName = extras.getString("Job");
        applyBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText nameTextBox = findViewById(R.id.apply_Name);
                EditText phoneTextBox = findViewById(R.id.apply_Phone);
                EditText emailTextBox = findViewById(R.id.apply_Email);

                TextView statusLabel = findViewById(R.id.statusLabel);
                setMessage(AppConstants.EMPTY_STRING);

                String name = nameTextBox.getText().toString();
                String phone = phoneTextBox.getText().toString();
                String email = emailTextBox.getText().toString();

                boolean ready = true;
                if (email.equals(AppConstants.EMPTY_STRING) || name.equals(AppConstants.EMPTY_STRING)|| phone.equals(AppConstants.EMPTY_STRING)) {
                    setMessage(AppConstants.FIELD_EMPTY_MESSAGE);
                    statusLabel.setText(message);
                    Toast.makeText(ApplyJobActivity.this, message ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ready && !DataValidator.isValidEmail(email)) {
                    setMessage(AppConstants.INVALID_EMAIL_MESSAGE);
                    statusLabel.setText(message);
                    Toast.makeText(ApplyJobActivity.this, message ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ready && !DataValidator.isValidName(name)) {
                    setMessage(AppConstants.INVALID_NAME_MESSAGE);
                    statusLabel.setText(message);
                    Toast.makeText(ApplyJobActivity.this, message ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ready && !DataValidator.isValidPhone(phone)) {
                    setMessage(AppConstants.INVALID_PHONE_MESSAGE);
                    statusLabel.setText(message);
                    Toast.makeText(ApplyJobActivity.this, message ,Toast.LENGTH_SHORT).show();
                    return;
                }
                statusLabel.setText(AppConstants.EMPTY_STRING);

                if(ready) {
                    setMessage("Success");
                    statusLabel.setText(message);
                    Toast.makeText(ApplyJobActivity.this, message ,Toast.LENGTH_SHORT).show();

                    String status = "applying";
                    Map<String, Object> map = new HashMap<>();
                    map.put("jobName", jobName);
                    map.put("employeeName", name);
                    map.put("employeePhone", phone);
                    map.put("employeeEmail", email);
                    map.put("status", status);
                    FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL)
                            .getReference()
                            .child("JobApplication")
                            .push()
                            .setValue(map)
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(ApplyJobActivity.this, message ,Toast.LENGTH_SHORT).show();
                                finish();
                                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                                startActivity(intent);
                            })
                            .addOnFailureListener(e ->
                                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show());
                }
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String errorMessage) {
        this.message = errorMessage;
    }
}
