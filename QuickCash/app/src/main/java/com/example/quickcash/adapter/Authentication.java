//package com.example.quickcash.adapter;
//
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//
//import com.example.quickcash.models.User;
//import com.example.quickcash.ui.Authentication.LoginActivity;
//import com.example.quickcash.util.AppConstants;
//import com.example.quickcash.util.DataValidator;
//import com.example.quickcash.util.FireBaseConstants;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;
//
//public class Authentication {
//
//    private FirebaseAuth auth;
//
//    public Authentication (){
//        auth = FirebaseAuth.getInstance();
//    }
//    public interface RegistrationCallback {
//        void onRegistrationSuccess();
//        void onRegistrationFailure(String errorMessage);
//    }
//
//    public void register(String email, String password, RegistrationCallback callback) {
//        auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Registration successful
//                            callback.onRegistrationSuccess();
//                        } else {
//                            // Registration failed
//                            callback.onRegistrationFailure(task.getException().getMessage());
//                        }
//                    }
//                });
//    }
//
//
//
//}
////    private DatabaseReference firebaseDBRef;
////    private String userCollection;
////    private AuthenticationResultCallback authenticationResultCallback;
////
////    public interface AuthenticationResultCallback {
////        void onLoginSuccess();
////        void onLoginFailure();
////    }
////
////    public Authentication(AuthenticationResultCallback callback) {
////        this.authenticationResultCallback = callback;
////        this.firebaseDBRef = FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL).getReference();
////        this.userCollection = FireBaseConstants.USER_COLLECTION;
////    }
////
////    public void login(String email, String password) {
////        getUserByEmail(email, password);
////    }
////
////    private void getUserByEmail(String email, final String password) {
////        final Query getUserByEmailQuery = firebaseDBRef.child(this.userCollection)
////                .orderByChild("Email")
////                .equalTo(email);
////
////        getUserByEmailQuery.addListenerForSingleValueEvent(new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot snapshot) {
////                for (DataSnapshot currentSnapShot : snapshot.getChildren()) {
////                    String userEmail = currentSnapShot.child("Email").getValue(String.class);
////                    String userPassword = currentSnapShot.child("Password").getValue(String.class);
////
////                    authenticationResultCallback.onLoginSuccess();
////
//////                    if ( userEmail.equals(email) && userPassword.equals(password)) {
//////                        authenticationResultCallback.onLoginSuccess();
//////                        return; // Exit the loop once a matching user is found
//////                    }
////                }
////                //authenticationResultCallback.onLoginFailure();
////            }
////
////
////            @Override
////            public void onCancelled(@NonNull DatabaseError error) {
////                authenticationResultCallback.onLoginFailure();
////            }
////        });
////    }
