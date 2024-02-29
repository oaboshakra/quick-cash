package com.example.quickcash.adapter;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.quickcash.models.User;
import com.example.quickcash.ui.Authentication.LoginActivity;
import com.example.quickcash.ui.Authentication.RegisterationActivity;
import com.example.quickcash.util.FireBaseConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class AuthenticationAdaptor {
    boolean isRegistered = false;
    public AuthenticationAdaptor(){}
    public boolean register (User user ){

        FirebaseDatabase.getInstance().getReference(FireBaseConstants.USER_COLLECTION)
                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            isRegistered = true;
                        }
                    }
                });
        return isRegistered;

    }

}
