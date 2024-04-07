package com.example.quickcash.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quickcash.R;
import com.example.quickcash.ui.Gmaps.MapsActivity;
import com.example.quickcash.ui.Job.JobSearch;
import com.example.quickcash.ui.Job.ModifyJob;
import com.example.quickcash.ui.PayPal.Payment;
import com.example.quickcash.ui.Profile.EmployerProfile;
import com.example.quickcash.ui.ProfileSuggestion.ProfileSuggestion;
import com.example.quickcash.ui.Rating.rating;
import com.example.quickcash.ui.preferenceSystem.preferenceSystem;
import com.example.quickcash.ui.Job.JobAcceptance;

/**
 * The home page activity of the application.
 * This activity displays buttons for various functionalities like job modification,
 * job search, profile view, preferences, job acceptance, payment, profile suggestions, and ratings.
 */
public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Get email ID from intent extras
        Bundle extras = getIntent().getExtras();
        String emailId = extras.getString("email");

        // Button for job modification
        Button add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModifyJob.class);
                intent.putExtra("emailid", emailId);
                startActivity(intent);
            }
        });

        // Button for job search
        Button search = findViewById(R.id.buttonSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JobSearch.class);
                startActivity(intent);
            }
        });

        // Button for profile view
        Button goToProfileButton = findViewById(R.id.goToProfile);
        goToProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmployerProfile.class);
                startActivity(intent);
            }
        });

        Button searhMaps = findViewById(R.id.button4);
        searhMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , MapsActivity.class));
            }
        });

        // Button for preferences
        Button preference = findViewById(R.id.preference);
        preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), preferenceSystem.class);
                startActivity(intent);
            }
        });

        // Button for job acceptance
        Button jobAcceptance = findViewById(R.id.jobAcceptance);
        jobAcceptance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JobAcceptance.class);
                startActivity(intent);
            }
        });

        // Button for payment
        Button goToPayment = findViewById(R.id.PayEmploye);
        goToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);
                startActivity(intent);
            }
        });

        // Button for profile suggestions
        Button goToProfileSuggestion = findViewById(R.id.goToEmployeeSuggestion);
        goToProfileSuggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfileSuggestion.class);
                startActivity(intent);
            }
        });

        // Button for ratings
        Button goRaing = findViewById(R.id.goRating);
        goRaing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), rating.class);
                startActivity(intent);
            }
        });
    }
}
