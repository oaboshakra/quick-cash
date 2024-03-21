package com.example.quickcash.adapter;

import com.example.quickcash.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quickcash.models.User;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class EmployeeAdapter extends FirebaseRecyclerAdapter<User, EmployeeAdapter.EmployeeViewHolder> {

    public EmployeeAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggested_profile, parent, false);
        return new EmployeeViewHolder(view);
    }


    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private final TextView FirstName, email;

        private final Context context;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            FirstName = itemView.findViewById(R.id.profileName);
            email = itemView.findViewById(R.id.profileEmail);
            context = itemView.getContext();
        }
    }

    @Override
    protected void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position, @NonNull User employee) {
        holder.FirstName.setText(employee.getFirstName());
        holder.email.setText(employee.getEmail());
    }
}
