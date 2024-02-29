package com.example.quickcash.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.quickcash.R;
import com.example.quickcash.ui.JobPosting.PostJobFragment;

public class WelcomePage extends Activity {
    private Button postJobButton, jobSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        postJobButton = findViewById(R.id.postJobButton);
        jobSearchButton = findViewById(R.id.jobSearchButton);

        postJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //showToast("Post a Job button clicked");
                Intent postAJob = new Intent(getApplicationContext() , PostJobFragment.class);
                postAJob.putExtra("Employer" , "nituu2411@gmail.com");
                startActivity(postAJob);
                ;
            }
        });

        jobSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Find a Job button clicked");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
