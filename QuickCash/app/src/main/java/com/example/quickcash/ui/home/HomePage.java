package com.example.quickcash.ui.home;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.R;
import com.example.quickcash.ui.Job.JobSearch;
import com.example.quickcash.ui.Job.ModifyJob;

import com.example.quickcash.ui.PayPal.Payment;
import com.example.quickcash.ui.Profile.EmployerProfile;
import com.example.quickcash.ui.preferenceSystem.preferenceSystem;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Button add = (Button) findViewById(R.id.button);
        Bundle extras = getIntent().getExtras();
        String emailId = extras.getString("email");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModifyJob.class);
                intent.putExtra("emailid",emailId);
                startActivity(intent);
            }
        });
        Button search = (Button) findViewById(R.id.buttonSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JobSearch.class);
                startActivity(intent);
            }
        });

        /*
        The following code is for the "Profile" button which directs Employers to their page
        once clicked.
        */
        Button goToProfileButton = findViewById(R.id.goToProfile);
        goToProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmployerProfile.class);
                startActivity(intent);
            }
        });

        Button preference = findViewById(R.id.preference);
        preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), preferenceSystem.class);
                startActivity(intent);
            }
        });
        Button goToPayment = findViewById(R.id.PayEmploye);
        goToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);
                startActivity(intent);
            }
        });
    }
}
