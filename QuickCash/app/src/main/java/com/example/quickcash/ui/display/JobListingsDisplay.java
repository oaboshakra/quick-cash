package com.example.quickcash;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quickcash.adapters.JobListingAdapter;
import java.util.ArrayList;
// Import your Job data model

public class JobListingsDisplay extends AppCompatActivity {

    private RecyclerView rvJobListings;
    private JobListingAdapter jobListingAdapter;
    private ArrayList<Job> jobListings; // Replace Job with your actual data model

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_listings_display);

        tvJobRecommendations = findViewById(R.id.tvJobRecommendations);
        tvResults = findViewById(R.id.tvResults);
        rvJobListings = findViewById(R.id.rvJobListings);

        // Initialize your jobListings ArrayList
        jobListings = new ArrayList<>();
        // Add Job items to the list

        jobListingAdapter = new JobListingAdapter(jobListings);
        rvJobListings.setAdapter(jobListingAdapter);
        rvJobListings.setLayoutManager(new LinearLayoutManager(this));
    }
}
