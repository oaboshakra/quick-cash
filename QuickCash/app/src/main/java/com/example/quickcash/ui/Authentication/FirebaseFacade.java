package com.example.quickcash.ui.Authentication;

import androidx.annotation.NonNull;

import com.example.quickcash.models.User;
import com.example.quickcash.util.FireBaseConstants;
import com.example.quickcash.util.FirebaseManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import java.util.UUID;

/**
 * This class represents a Facade structural design pattern which aims to hide the complexity behind
   registration logic from the class Registeration activity.
 */
public class FirebaseFacade {

    // Reference to the Firebase Database
    private final DatabaseReference firebaseDBRef = FirebaseManager.getInstance().getDatabaseReference();

    /**
     * Registers a new user in the Firebase Database.
     *
     * @param user     The user object to register.
     * @param callback The callback interface for handling registration success or failure.
     */
    public void register(User user, IAuthenticationCallBack callback) {
        // Generate a unique UUID for the user
        String userId = UUID.randomUUID().toString();

        // Save user data to the Firebase Database
        firebaseDBRef.child(FireBaseConstants.USER_COLLECTION).child(userId)
                .setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Check if registration was successful
                        if (task.isSuccessful()) {
                            // Notify success through the callback
                            callback.onSuccess();
                        } else {
                            // Notify failure through the callback
                            callback.onFailure();
                        }
                    }
                });
    }
}
