package com.example.quickcash.ui.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quickcash.R;
import com.example.quickcash.models.User;
import com.example.quickcash.ui.home.HomePage;
import com.example.quickcash.util.AppConstants;
import com.example.quickcash.util.DataValidator;
import com.example.quickcash.util.FireBaseConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;


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



                   User user = new User(firstName , lastName , email , password , " employer ");
                   FirebaseDatabase.getInstance().getReference().child(FireBaseConstants.USER_COLLECTION).child(UUID.randomUUID().toString())
                           .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                               @Override
                               public void onComplete(@NonNull Task<Void> task) {
                                   if (task.isSuccessful()) {
                                       Toast.makeText(getApplicationContext(), "Signed up successfully!", Toast.LENGTH_LONG).show();
                                       Intent intent = new Intent(getApplicationContext() , HomePage.class);
                                       intent.putExtra("UserEmail" , email);
                                       intent.putExtra("Role" , "employer");
                                       startActivity(intent);
                                       return;
                                   }
                                   else {
                                       Toast.makeText(getApplicationContext(), "Sign up failed", Toast.LENGTH_LONG).show();
                                   }
                               }
                           });



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

