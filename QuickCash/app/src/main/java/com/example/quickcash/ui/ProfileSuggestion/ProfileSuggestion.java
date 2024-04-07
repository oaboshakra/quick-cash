package com.example.quickcash.ui.ProfileSuggestion;

import com.example.quickcash.R;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quickcash.adapter.EmployeeAdapter;
import com.example.quickcash.models.User;
import com.example.quickcash.ui.WrapLinearLayoutManager.WrapLinearLayoutManager;
import com.example.quickcash.ui.home.HomePage;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.example.quickcash.util.FireBaseConstants;

/**
 * Activity responsible for displaying profile suggestions fetched from Firebase Realtime Database.
 */
public class ProfileSuggestion extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmployeeAdapter viewEmployeeAdapter;
    private FloatingActionButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_suggestion);
        init();
        connectToFirebaseRTDB();
        attachListeners();
    }

    /**
     * Initializes UI elements.
     */
    private void init() {
        recyclerView = findViewById(R.id.employee_recyclerView);
        recyclerView.setLayoutManager(new WrapLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        backButton = findViewById(R.id.back2);
    }

    /**
     * Attaches listeners to UI elements.
     */
    private void attachListeners() {
        backButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), HomePage.class)));
    }

    /**
     * Connects to Firebase Realtime Database and populates RecyclerView with user profiles.
     */
    private void connectToFirebaseRTDB() {
        final FirebaseRecyclerOptions<User> options = new FirebaseRecyclerOptions.Builder<User>()
                .setQuery(FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL)
                        .getReference()
                        .child("Users"), User.class)
                .build();
        viewEmployeeAdapter = new EmployeeAdapter(options);
        recyclerView.setAdapter(viewEmployeeAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewEmployeeAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewEmployeeAdapter.stopListening();
    }
}
