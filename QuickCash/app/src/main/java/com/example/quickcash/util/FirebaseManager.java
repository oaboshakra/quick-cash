package com.example.quickcash.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Singleton class to manage Firebase database instance.
 */
public class FirebaseManager {

    private static FirebaseManager instance;
    private DatabaseReference databaseReference;

    /**
     * Private constructor to prevent instantiation outside this class.
     */
    private FirebaseManager() {
        // Set the database reference
        databaseReference = FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL).getReference();

    }

    /**
     * Method to get the singleton instance of FirebaseManager.
     *
     * @return The singleton instance of FirebaseManager.
     */
    public static synchronized FirebaseManager getInstance() {
        if (instance == null) {
            instance = new FirebaseManager();
        }
        return instance;
    }

    /**
     * Method to get the database reference.
     *
     * @return The DatabaseReference object for Firebase database.
     */
    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }
}
