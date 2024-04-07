package com.example.quickcash.adapter;

import com.example.quickcash.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.example.quickcash.models.Job;
import com.firebase.ui.database.FirebaseRecyclerOptions;

/**
 * Adapter class for displaying Job items in a RecyclerView.
 */
public class JobAdapter extends FirebaseRecyclerAdapter<Job, JobAdapter.JobViewHolder> {

    /**
     * Constructor for JobAdapter.
     *
     * @param options Options to configure the adapter.
     */
    public JobAdapter(@NonNull FirebaseRecyclerOptions<Job> options) {
        super(options);
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.preference_job_item, parent, false);
        return new JobViewHolder(view);
    }

    /**
     * ViewHolder class for holding views of a Job item.
     */
    public class JobViewHolder extends RecyclerView.ViewHolder {

        private final TextView name, timeZone, location, wage;

        private final Context context;

        /**
         * Constructor for JobViewHolder.
         *
         * @param itemView The view containing the job item layout.
         */
        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.RecommendName);
            timeZone = itemView.findViewById(R.id.RecommendTimeZone);
            location = itemView.findViewById(R.id.RecommendLocation);
            wage = itemView.findViewById(R.id.RecommendWage);
            context = itemView.getContext();
        }
    }

    /**
     * @param holder
     * @param position
     * @param job the model object containing the data that should be used to populate the view.
     */
    @Override
    protected void onBindViewHolder(@NonNull JobViewHolder holder, int position, @NonNull Job job) {
        holder.name.setText(job.getName());
        holder.timeZone.setText(job.getTimeZone());
        holder.location.setText(job.getLocation());
        holder.wage.setText(job.getWage());
    }
}
