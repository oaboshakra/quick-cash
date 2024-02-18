package com.example.quickcash.ui.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quickcash.MainActivity;
import com.example.quickcash.R;
import com.example.quickcash.models.User;
import com.example.quickcash.util.AppConstants;
import com.example.quickcash.util.DataValidator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterationActivity extends AppCompatActivity {
    FirebaseAuth auth;
    DatabaseReference databaseReference;
    EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    Spinner roleSpinner;
    Button registerButton;
    TextView singInNav;
    private FirebaseAuth authentication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();// initiaize ui components
        setUpListeners();



    }
    public void setUpListeners(){
       singInNav.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(RegisterationActivity.this , LoginActivity.class));
           }
       });
       registerButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String firstName =firstNameEditText.getText().toString();
               String lastName =lastNameEditText.getText().toString();
               String email = emailEditText.getText().toString();
               String password = passwordEditText.getText().toString();
               String role = roleSpinner.getSelectedItem().toString();

               if( !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty() && !role.isEmpty() ){
                   if(  !DataValidator.isValidPassword(password) ){  Toast.makeText(getApplicationContext(), AppConstants.INVALID_PASSWORD_MESSAGE ,Toast.LENGTH_SHORT).show(); return;}
                   if(  !DataValidator.isValidEmail(email) ){  Toast.makeText(getApplicationContext(), AppConstants.INVALID_EMAIL_MESSAGE ,Toast.LENGTH_SHORT).show(); return;}
                   authentication.createUserWithEmailAndPassword(email , password);
                   startActivity(new Intent(getApplicationContext() , MainActivity.class));
               }
               else {
                   Toast.makeText(getApplicationContext(), AppConstants.FIELD_EMPTY_MESSAGE ,Toast.LENGTH_SHORT).show();
               }

           }
       });

    }
    public void init(){

       firstNameEditText = findViewById(R.id.first_Name);
        lastNameEditText = findViewById(R.id.last_Name);
        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.Password);
        roleSpinner = (Spinner) findViewById(R.id.role_Spinner);
        registerButton = findViewById(R.id.button);
        singInNav = findViewById(R.id.SignInLink);

    }
}

//        // Initialize Firebase Auth and Database Reference
//        auth = FirebaseAuth.getInstance();
//        databaseReference = FirebaseDatabase.getInstance().getReference();
//
//        TextView loginLink = findViewById(R.id.loginLink);
//        loginLink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RegisterationActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        // Initialize UI components
//        firstNameEditText = findViewById(R.id.first_Name);
//        lastNameEditText = findViewById(R.id.last_Name);
//        emailEditText = findViewById(R.id.Email);
//        passwordEditText = findViewById(R.id.Password);
//        confirmPasswordEditText = findViewById(R.id.confirmPassword);
//        roleSpinner = findViewById(R.id.dropDownMenu);
//        registerButton = findViewById(R.id.registerButton);
//
//        // Setup spinner (dropdown) for role selection
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.role_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        roleSpinner.setAdapter(adapter);
//
//        registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String firstName = firstNameEditText.getText().toString().trim();
//                String lastName = lastNameEditText.getText().toString().trim();
//                String email = emailEditText.getText().toString().trim();
//                String password = passwordEditText.getText().toString().trim();
//                String confirmPassword = confirmPasswordEditText.getText().toString().trim();
//                String role = roleSpinner.getSelectedItem().toString();
//
//                if (!validateForm(firstName, lastName, email, password, confirmPassword, role)) {
//                    return; // Validation failed
//                }
//
//                // Proceed with Firebase registration
//                registerUser(email, password, firstName, lastName, role);
//            }
//        });
//    }
//
//    private boolean validateForm(String firstName, String lastName, String email, String password, String confirmPassword, String role) {
//        // Add your validation logic here. For simplicity, only basic checks are performed.
//        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || !password.equals(confirmPassword)) {
//            Toast.makeText(RegisterationActivity.this, "Please fill all fields correctly and confirm your password.", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (!DataValidator.isValidEmail(email)) {
//            Toast.makeText(RegisterationActivity.this, AppConstants.INVALID_EMAIL_MESSAGE, Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (!DataValidator.isValidPassword(password)) {
//            Toast.makeText(RegisterationActivity.this, AppConstants.INVALID_PASSWORD_MESSAGE, Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }
//
//    private void registerUser(final String email, String password, final String firstName, final String lastName, final String role) {
//        auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            String userId = auth.getCurrentUser().getUid();
//                            User newUser = new User(firstName, lastName, email, role);
//                            databaseReference.child("users").child(userId).setValue(newUser)
//                                    .addOnCompleteListener(task1 -> {
//                                        if (task1.isSuccessful()) {
//                                            Toast.makeText(RegisterationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
//                                            // Navigate to login or main activity
//                                            // Intent intent = new Intent(RegisterationActivity.this, LoginActivity.class);
//                                            // startActivity(intent);
//                                            // finish();
//                                        } else {
//                                            Toast.makeText(RegisterationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
//                                        }
//                                    });
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Toast.makeText(RegisterationActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                });
//