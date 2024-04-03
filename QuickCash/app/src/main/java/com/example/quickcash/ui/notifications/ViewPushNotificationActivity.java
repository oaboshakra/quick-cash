package com.example.quickcash.ui.notifications;

import com.example.quickcash.R;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewPushNotificationActivity extends AppCompatActivity {

    private TextView titleTV;
    private TextView bodyTV;
    private TextView jobNameTV;
    private TextView jobLocationTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        init();
        setData();
    }

    private void init() {
        //binding the views with the variables
        titleTV = findViewById(R.id.titleTV);
        bodyTV = findViewById(R.id.bodyTV);
        jobNameTV = findViewById(R.id.jobName);
        jobLocationTV = findViewById(R.id.jobLocationTV);
    }

    private void setData() {
        //whatever data is received in the push notification, the variables are being set to that
        final Bundle extras = getIntent().getExtras();
        final String title = extras.getString("title");
        final String body = extras.getString("body");
        final String jobId = extras.getString("jobName");
        final String jobLocation = extras.getString("jobLocation");

        titleTV.setText(title);
        bodyTV.setText(body);
        jobNameTV.setText(jobId);
        jobLocationTV.setText(jobLocation);
    }
}