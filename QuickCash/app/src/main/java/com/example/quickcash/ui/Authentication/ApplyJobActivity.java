package com.example.quickcash.ui.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.example.quickcash.adapter.Authentication;
import com.example.quickcash.MainActivity;
import com.example.quickcash.databinding.ActivityApplyjobBinding;
import com.example.quickcash.R;
import com.example.quickcash.models.User;
import com.example.quickcash.util.AppConstants;
import com.example.quickcash.util.DataValidator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ApplyJobActivity extends AppCompatActivity {

    private ActivityApplyjobBinding binding;
    private FirebaseAuth auth;
    private String errorMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApplyjobBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button applyBtn = findViewById(R.id.apply_btn);
        applyBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText nameTextBox = findViewById(R.id.apply_Name);
                EditText phoneTextBox = findViewById(R.id.apply_Phone);
                EditText emailTextBox = findViewById(R.id.apply_Email);

                TextView statusLabel = findViewById(R.id.statusLabel);
                setErrorMessage(AppConstants.EMPTY_STRING);

                String name = nameTextBox.getText().toString();
                String phone = phoneTextBox.getText().toString();
                String email = emailTextBox.getText().toString();


                boolean ready = true;
                if (email.equals(AppConstants.EMPTY_STRING) || name.equals(AppConstants.EMPTY_STRING)|| phone.equals(AppConstants.EMPTY_STRING)) {
                    setErrorMessage(AppConstants.FIELD_EMPTY_MESSAGE);
                    statusLabel.setText(errorMessage);
                    Toast.makeText(ApplyJobActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ready && !DataValidator.isValidEmail(email)) {
                    setErrorMessage(AppConstants.INVALID_EMAIL_MESSAGE);
                    statusLabel.setText(errorMessage);
                    Toast.makeText(ApplyJobActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ready && !DataValidator.isValidPassword(name)) {
                    setErrorMessage(AppConstants.INVALID_NAME_MESSAGE);
                    statusLabel.setText(errorMessage);
                    Toast.makeText(ApplyJobActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ready && !DataValidator.isValidPassword(phone)) {
                    setErrorMessage(AppConstants.INVALID_PHONE_MESSAGE);
                    statusLabel.setText(errorMessage);
                    Toast.makeText(ApplyJobActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
                    return;
                }
                statusLabel.setText(AppConstants.EMPTY_STRING);


                FirebaseApp.initializeApp(ApplyJobActivity.this);
                auth = FirebaseAuth.getInstance();
                if(ready) {
                    Toast.makeText(ApplyJobActivity.this, "Submit" ,Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(ApplyJobActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
