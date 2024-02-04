package com.example.quickcash.ui.Authentication;
import android.text.TextUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.MainActivity;
import com.example.quickcash.databinding.ActivityLoginBinding;
import com.example.quickcash.R;
import com.example.quickcash.util.AppConstants;
import com.example.quickcash.util.DataValidator;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;



    private String errorMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button signInRequest = findViewById(R.id.Sign_In_Request);
        signInRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText emailTextBox = findViewById(R.id.Sign_In_Email);
                EditText passwordTextBox = findViewById(R.id.Sign_In_Password);
                TextView statusLabel = findViewById(R.id.statusLabel);
                setErrorMessage(AppConstants.EMPTY_STRING);

                String email = emailTextBox.getText().toString();
                String password = passwordTextBox.getText().toString();

                boolean readyToLogin = true;
                if (email.equals(AppConstants.EMPTY_STRING) || password.equals(AppConstants.EMPTY_STRING)) {
                    setErrorMessage(AppConstants.FIELD_EMPTY_ERROR);
                    readyToLogin = false;
                }
                if (readyToLogin && !DataValidator.isValidEmail(email)) {
                    setErrorMessage(AppConstants.INVALID_EMAIL_ERROR);
                    readyToLogin = false;
                }
                if (readyToLogin && !DataValidator.isValidPassword(password)) {
                    setErrorMessage(AppConstants.INVALID_PASSWORD_ERROR);
                    readyToLogin = false;
                }
                Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                statusLabel.setText(errorMessage);


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
