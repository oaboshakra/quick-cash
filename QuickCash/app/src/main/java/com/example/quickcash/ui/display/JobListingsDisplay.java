package com.example.quickcash.ui.display;
//import static com.example.quickcash.adapter.Authentication.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.quickcash.adapter.Authentication;
import com.example.quickcash.R;
import com.example.quickcash.util.FireBaseConstants;

import java.util.ArrayList;
import java.util.List;

public class JobListingsDisplay extends AppCompatActivity {

    private RecyclerView jobsRecyclerView;
    private JobsAdapter adapter;
    private DatabaseReference jobsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_listings_display);

        // Initialize RecyclerView
        jobsRecyclerView = findViewById(R.id.jobsRecyclerView);
        jobsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize adapter
        adapter = new JobsAdapter(new ArrayList<>());
        jobsRecyclerView.setAdapter(adapter);

        // Set up Firebase reference
        ArchTaskExecutor FirebaseDatabase = null;
        jobsRef = FirebaseDatabase.getInstance().getReference("Jobs");

        // Load jobs from Firebase
        loadJobsFromFirebase();
    }

    private void loadJobsFromFirebase() {
        jobsRef.addValueEventListener(new ValueEventListener() {
            class DataSnapshot {
                public DataSnapshot[] getChildren() {
                    return new DataSnapshot[0];
                }

                public Job getValue(Class<Job> jobClass) throws IllegalAccessException, InstantiationException {
                    return jobClass.newInstance();
                }
            }


            public void onDataChange(DataSnapshot dataSnapshot) throws IllegalAccessException, InstantiationException {
                List<Job> jobList = new ArrayList<>();
                for (DataSnapshot jobSnapshot: dataSnapshot.getChildren()) {
                    Job job = jobSnapshot.getValue(Job.class);
                    jobList.add(job);
                }
                adapter.updateJobs(jobList);
            }


        });
    }

    private class DatabaseReference {
        public void addValueEventListener(ValueEventListener valueEventListener) {

        }
    }

    private class ValueEventListener {
    }
}

class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.JobViewHolder> {

    private List<Job> jobsList;

    public JobsAdapter(List<Job> jobsList) {
        this.jobsList = jobsList;
    }

    public void updateJobs(List<Job> newJobs) {
        jobsList = newJobs;
        notifyDataSetChanged();
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new JobViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {
        Job job = jobsList.get(position);
        holder.jobTitle.setText(job.getTitle());
        holder.jobDescription.setText(job.getDescription());
        holder.applyButton.setOnClickListener(view -> {
            // Handle apply button click
        });
    }

    @Override
    public int getItemCount() {
        return jobsList.size();
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder {
        public TextView jobTitle, jobDescription;
        public Button applyButton;

        public JobViewHolder(View view) {
            super(view);
            jobTitle = view.findViewById(R.id.jobTitle);
            jobDescription = view.findViewById(R.id.jobDescription);
            applyButton = view.findViewById(R.id.applyButton);
        }
    }
}

// Assuming a Job model with title and description.
class Job {
    private String title;
    private String description;


    public Job() {
    }

    public Job(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
