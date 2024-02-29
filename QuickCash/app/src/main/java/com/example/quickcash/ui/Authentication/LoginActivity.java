package com.example.quickcash.ui.Authentication;
//import static com.example.quickcash.adapter.Authentication.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.quickcash.databinding.ActivityLoginBinding;
import com.example.quickcash.R;
import com.example.quickcash.ui.MainActivity;
import com.example.quickcash.ui.home.WelcomePage;
import com.example.quickcash.util.AppConstants;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    //private Authentication authInstance;

    private FirebaseAuth auth;


    private String errorMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toast.makeText(LoginActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
        TextView signUpLink = findViewById(R.id.SignUpLink);
        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterationActivity.class);
                startActivity(intent);
            }
        });

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

                Intent intent = new Intent(getApplicationContext() , WelcomePage.class);
                intent.putExtra("UserEmail" , "nith2411@gmail.com");
                intent.putExtra("Role" , "employer");
                startActivity(intent);
                return;



//                if (email.equals(AppConstants.EMPTY_STRING) || password.equals(AppConstants.EMPTY_STRING)) {
//                    setErrorMessage(AppConstants.FIELD_EMPTY_MESSAGE);
//                    statusLabel.setText(errorMessage);
//                    Toast.makeText(LoginActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if ( !DataValidator.isValidEmail(email) ) {
//                    setErrorMessage(AppConstants.INVALID_EMAIL_MESSAGE);
//                    statusLabel.setText(errorMessage);
//                    Toast.makeText(LoginActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if ( !DataValidator.isValidPassword(password) ) {
//                    setErrorMessage(AppConstants.INVALID_PASSWORD_MESSAGE);
//                    statusLabel.setText(errorMessage);
//                    Toast.makeText(LoginActivity.this, errorMessage ,Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                statusLabel.setText(AppConstants.EMPTY_STRING);


//                FirebaseApp.initializeApp(LoginActivity.this);
//                auth = FirebaseAuth.getInstance();
//                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
//                    if(task.isSuccessful()){
//                        //redirect to user profile or home page for employee or employer
//                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//
//                    }else{
//                        //Toast.makeText(LoginPageActivity.this,"Failed to login! Please check your credentials.",Toast.LENGTH_LONG).show();
//                    }
//                });
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
