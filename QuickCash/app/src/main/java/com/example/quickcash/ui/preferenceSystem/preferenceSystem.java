package com.example.quickcash.ui.preferenceSystem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.quickcash.R;
import com.example.quickcash.adapter.JobAdapter;
import com.example.quickcash.models.Job;
import com.example.quickcash.ui.WrapLinearLayoutManager.WrapLinearLayoutManager;
import com.example.quickcash.ui.home.HomePage;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.example.quickcash.util.FireBaseConstants;
public class preferenceSystem extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JobAdapter viewJobAdapter;

    private FloatingActionButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        init();
        connectToFirebaseRTDB();
        attachListeners();
    }

    private void init() {
        recyclerView = findViewById(R.id.job_recyclerView);
        recyclerView.setLayoutManager(new WrapLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        backButton = findViewById(R.id.back);
    }

    private void attachListeners() {
        backButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), HomePage.class)));
    }
    private void connectToFirebaseRTDB() {
        final FirebaseRecyclerOptions<Job> options = new FirebaseRecyclerOptions.Builder<Job>()
                .setQuery(FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL)
                        .getReference()
                        .child("Jobs"), Job.class)
                .build();
        viewJobAdapter = new JobAdapter(options);
        recyclerView.setAdapter(viewJobAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        viewJobAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewJobAdapter.stopListening();
    }
}
