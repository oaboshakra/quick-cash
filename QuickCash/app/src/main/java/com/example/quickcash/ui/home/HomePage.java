package com.example.quickcash.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.R;
import com.example.quickcash.ui.Job.JobSearch;
import com.example.quickcash.ui.Job.ModifyJob;
import com.example.quickcash.ui.Profile.EmployerProfile;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifyjob); // Ensure this is your HomePage layout, not ModifyJob

        Button rateEmployeeButton = findViewById(R.id.rateEmployee);
        rateEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, RateEmployeeActivity.class);
                startActivity(intent);
            }
        });

        Button add = findViewById(R.id.button);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String emailId = extras.getString("email");

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomePage.this, ModifyJob.class);
                    intent.putExtra("emailid", emailId);
                    startActivity(intent);
                }
            });
        }

        Button search = findViewById(R.id.buttonSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, JobSearch.class);
                startActivity(intent);
            }
        });

        Button goToProfileButton = findViewById(R.id.goToProfile);
        goToProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, EmployerProfile.class);
                startActivity(intent);
            }
        });
    }
}
