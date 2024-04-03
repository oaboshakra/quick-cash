package com.example.quickcash.ui.Job;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.quickcash.R;
import com.example.quickcash.models.User;
import com.example.quickcash.ui.home.HomePage;
import com.example.quickcash.util.FireBaseConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Activity for modifying job details.
 * This activity allows users to modify job details such as name, location, time zone, and wage.
 */
public class ModifyJob extends AppCompatActivity {
    private EditText name, Location, TimeZone, Wage;
    private Button add;
    private DatabaseReference firebaseDBRef;

    private String userName;
    private String emailId;

    //path
    private static final String CREDENTIALS_FILE_PATH = "key.json";
    //OAuth Client 2 key
    private static final String FIREBASE_SERVER_KEY = "ya29.c.c0AY_VpZj4kpzoigiqz_RLku9TjnXBx9a2L_8lOaP5PqnY1SNIdXCLHh08urtPhfvsh2LFM5eyPYLBaGl7GJVhHgtZvq7JxXrWV5ex_xUSqS1XLztl1t5taQwZdrtlSbN9r6_Lt7GUm0qmCE7FUFqGtOUJtToDdfoKsre_lP4VLH27dTG8ACzPuBCJ2Iwl3y_VJugWvQMBOfOD35hY_EsOl125V7E0mJtbHruTBdpzD359zrF_70Rz4EU6adyBuYdnvuWSbyDL7IkGTcleonk68oyqquS9jXO-kYMr0riBx2VZWIm9fl3jxDlAzxlHc8o0-46fqmXNExEFj5l9vBeqtgSxejT2MjcsZshdwaaaQZ5aJX1CfcjGI-jAC6rf6Zrcudz9aQEG400A4OkmeJgqup53-u_JkFSXFJyOsXYksU6_V2wv0c_Sx4dBOxvuR4OZwetS_VBYefwv0VcOVhk13UYhpyfiM3tQptsppXY-xub7ZW0iZS4_z3t6MSuS_aFrBjFIJJFW9XI8h79dw0vQpU2awfhq_fQs4321mZjd1wdJwkw70233mbOjS1sihy3X2JVBcfnWexOXjVuo5Ia_cwOdOdq1UY6QlOl-cVfhvnmvheBtSQBb3dx_fJMXo8xgX3vy5MXks5UeeRyjh0QBXBsk_0g1oZ1Xmd6OlkdfXOrirIphJ1JYyp_-6_JW8xxFYSQcikO2xavjl7BcQm7wZ7FjQposRyUz9k_p415Mjv6wqw2bc3JwZpkU3ca3kzbltFtJkyWItackhehjWfjdX4kRWkgpmS2nwMFIoUMmaZ0wsZ0j2Mde5pyVqpVYUnOu3rpchlnYbfSuJhary8xzJYVneaszfivvxa-nMQanZJXMUyVgUBJSoRXw-FtI8lg1Mt1QnWexgkVIxiUpgbtJ1du50lx0l1cY858Bxxj9eMOdORb7F13ueidef8cdUpUu3XB7Fd7Z8JUIy6bU0slfo_o4YWMJ7pVWlnWYRW7dpZe2R9nrw05t3lj";
    //provided by google for sending notification
    //new endpoint
    private static final String PUSH_NOTIFICATION_ENDPOINT ="https://fcm.googleapis.com/v1/projects/quickcash-77956/messages:send";
    //provided by volley library to make a network request
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addjob);
        init();
        attachListeners();
    }

    /**
     * This method initializes all the  UI elements of the registeratio page.
     * UI elements initialized :
     *       |----> Text field : name , location , timeZone , wage
     *       |----> Button : add
     *       |----> Spinner : NIL.
     */
    private void init() {
        name = findViewById(R.id.name);
        Location = findViewById(R.id.Location);
        TimeZone = findViewById(R.id.TimeZone);
        Wage = findViewById(R.id.Wage);
        add = findViewById(R.id.add);
        firebaseDBRef = FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL).getReference();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            emailId = extras.getString("emailid");
            searchNameByEmail(emailId);
        }
        //For notification
        requestQueue = Volley.newRequestQueue(this);
        FirebaseMessaging.getInstance().subscribeToTopic("jobs");
        sendNotification();
    }

    /**
     * Attaches click listener to the add button.
     */
    private void attachListeners() {
        add.setOnClickListener(view -> addDataToFRTD());
    }

    /**
     * This function holds the query to add a job to the firebase collection .
     * It create a hashmap with these field : name, location, timezone, jobowner, wage of the job
     * If the job was added properly in the firebase , a proper message is notified to the user properly
     * else a unSuccessfull message is also notified to the user using Toast.
     */
    private void addDataToFRTD() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("Location", Location.getText().toString());
        map.put("TimeZone", TimeZone.getText().toString());
        map.put("jobOwner", userName);
        map.put("Wage", Wage.getText().toString());
        FirebaseDatabase.getInstance(FireBaseConstants.FIREBASE_URL)
                .getReference()
                .child("Jobs")
                .push()
                .setValue(map)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(getApplicationContext(), "Job added successfully", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(getApplicationContext(), "Job insertion failed", Toast.LENGTH_SHORT).show());
    }

    /**
     * Searches for the user's name based on the email.
     * This function holds the firebase query to search in the Users collection.
     * If teh user the user is found , the user is returned else  a proper error message is displayed.
     * @param email The user's email
     */
    private void searchNameByEmail(String email) {
        final Query emailQuery = firebaseDBRef.child("Users")
                .orderByChild("email")
                .equalTo(email);

        emailQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists() && snapshot.getChildrenCount() > 0) {
                    final User user;

                    for (DataSnapshot currentSnapShot : snapshot.getChildren()) {
                        user = currentSnapShot.getValue(User.class);
                        if (user != null) {
                            getUserName(user.getFirstName(), user.getLastName());
                        }
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ModifyJob", error.getMessage());
            }
        });
    }

    /**
     * Concatenates the user's first name and last name to get the full name.
     * @param fname The user's first name
     * @param Lname The user's last name
     */
    private void getUserName(String fname, String Lname){
        userName = fname + " " + Lname;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void sendNotification() {
        //try catch block for JSON exception
        try {
            //the first json object - to
            JSONObject notificationJSONBody = new JSONObject();
            notificationJSONBody.put("title", "New Job Created");
            notificationJSONBody.put("body", "A new job is created in your city.");

            // Create the data JSON object
            JSONObject dataJSONBody = new JSONObject();
            dataJSONBody.put("jobLocation", "Halifax");
            dataJSONBody.put("jobName", "HF-128369");

            // Create the message JSON object and attach notification and data
            JSONObject messageJSONBody = new JSONObject();
            messageJSONBody.put("topic", "jobs");
            messageJSONBody.put("notification", notificationJSONBody);
            messageJSONBody.put("data", dataJSONBody);

            // Create the final push notification JSON object and attach the message
            JSONObject pushNotificationJSONBody = new JSONObject();
            pushNotificationJSONBody.put("message", messageJSONBody);
            //parameters sent in the request:
            //type of request - post- sending data to firebase
            //url - push notification endpoint
            //data - body of the notification
            //toast message
            //error listener
            Log.d("LOG", pushNotificationJSONBody.toString());
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                    PUSH_NOTIFICATION_ENDPOINT,
                    pushNotificationJSONBody,
                    //lamda syntax
                    response ->
                            Toast.makeText(ModifyJob.this,
                                    "Notification Sent",
                                    Toast.LENGTH_SHORT).show(),
                    //method reference
                    Throwable::printStackTrace) {

                //adding the header to the endpoint
                //parameters used:
                //type of data
                //using the bearer token for authentication of the network request
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headers = new HashMap<>();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + FIREBASE_SERVER_KEY);
                    Log.d("headers", headers.toString());
                    return headers;
                }
            };
            //add the request to the queue
            requestQueue.add(request);
        } catch (JSONException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
