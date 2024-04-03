package com.example.quickcash.ui.Rating;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quickcash.R;
import com.example.quickcash.models.User;
import com.example.quickcash.ui.home.HomePage;
import com.example.quickcash.util.FireBaseConstants;
import com.example.quickcash.util.FirebaseManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * This activity allows users to rate other users by searching their name,
 * selecting them from the search results, and providing a rating using a RatingBar.
 */
public class rating extends AppCompatActivity {
    private EditText searchByName;
    private Button search, submit, back;
    private TextView name, email;
    private RatingBar ratingBar;
    private DatabaseReference firebaseDBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        init();
        search.setOnClickListener(view -> {
            final String searchByNameString = searchByName.getText().toString();
            if (!searchByNameString.trim().isEmpty()) {
                searchUser(searchByNameString);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Initialize UI elements and Firebase database reference.
     */
    private void init() {
        ratingBar=findViewById(R.id.ratingBar);
        searchByName = findViewById(R.id.searchName);
        search = findViewById(R.id.searchBUTTON);
        name = findViewById(R.id.rateName);
        email = findViewById(R.id.rateEmail);
        // Get database reference using Singleton pattern
        firebaseDBRef = FirebaseManager.getInstance().getDatabaseReference();
        submit = findViewById(R.id.buttonSubmit);
        submit.setVisibility(View.GONE);
        back = findViewById(R.id.back);
    }

    /**
     * Search for a user by their name in the Firebase database.
     * This fucntion executes the auery to search the user by his name to provide rating for him.
     * @param searchByNameString The name string to search for.
     */
    private void searchUser(String searchByNameString) {
        final Query nameQuery = firebaseDBRef.child("Users")
                .orderByChild("firstName")
                .equalTo(searchByNameString);

        nameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists() && snapshot.getChildrenCount() > 0) {
                    final User user;

                    for (DataSnapshot currentSnapShot : snapshot.getChildren()) {
                        user = currentSnapShot.getValue(User.class);
                        if (user != null) {
                            submit.setVisibility(View.VISIBLE);
                            name.setText(String.format(user.getFirstName() + " " + user.getLastName()));
                            email.setText(String.format(user.getEmail()));
                            submit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    float rating=ratingBar.getRating();
                                    Map<String, Object> map = new HashMap<>();
                                    map.put("name", name.getText().toString());
                                    map.put("Email", email.getText().toString());
                                    map.put("Rating", rating);
                                    FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL)
                                            .getReference()
                                            .child("Rating")
                                            .push()
                                            .setValue(map)
                                            .addOnSuccessListener(aVoid -> {
                                                Toast.makeText(getApplicationContext(), "Rating "+ Float.toString(rating)+" successfully", Toast.LENGTH_SHORT).show();
                                                finish();
                                            })
                                            .addOnFailureListener(e ->
                                                    Toast.makeText(getApplicationContext(), "Rating failed", Toast.LENGTH_SHORT).show());
                                }
                            });
                        }
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Rating", error.getMessage());
            }
        });
    }
}
