package com.example.quickcash.ui.Authentication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.R;
import com.example.quickcash.ui.employerProfile.EmployerProfile;

import android.widget.Toast;
public class AddAndSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifyjob);
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



    }
}
