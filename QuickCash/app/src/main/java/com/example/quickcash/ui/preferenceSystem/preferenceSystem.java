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

/**
 * This class represents the preference system functionality within the application.
 * It recommends the appropriate jobs to the user using the app as an employee.
 */
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

    /**
     * Initializes UI elements.
     * recyclerView: Initializes the RecyclerView to display job preferences.
     * Button: back button.
     */
    private void init() {
        recyclerView = findViewById(R.id.job_recyclerView);
        recyclerView.setLayoutManager(new WrapLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        backButton = findViewById(R.id.back);
    }

    /**
     * Attaches listeners to UI components.
     * backButton: Navigates back to the HomePage activity when clicked.
     */
    private void attachListeners() {
        backButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), HomePage.class)));
    }

    /**
     * Connects to the Firebase Realtime Database and populates the RecyclerView with job preferences.
     */
    private void connectToFirebaseRTDB() {
        final FirebaseRecyclerOptions<Job> options = new FirebaseRecyclerOptions.Builder<Job>()
                .setQuery(FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL)
                        .getReference()
                        .child("Jobs"), Job.class)
                .build();
        viewJobAdapter = new JobAdapter(options);
        recyclerView.setAdapter(viewJobAdapter);
    }


    /**
     * Is called when the activity is becoming visible to the user.
     * Connects the adapter to the Firebase Database.
     * and starts listening for changes in the source of the data.
     */
    @Override
    protected void onStart() {
        super.onStart();
        viewJobAdapter.startListening();
    }

    /**
     * Is called when the activity is no longer visible to the user.
     * Stops listening for changes in the source of the data.
     */
    @Override
    protected void onStop() {
        super.onStop();
        viewJobAdapter.stopListening();
    }
}
