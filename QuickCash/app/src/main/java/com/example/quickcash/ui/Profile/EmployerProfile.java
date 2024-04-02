package com.example.quickcash.ui.Profile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.util.AppConstants;
import com.example.quickcash.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

/**
 * This class represents the employer profile feature within the application.
 * Employers can manage their profile details using this functionality.
 */
public class EmployerProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private FirebaseAuth authentication;
    DatabaseReference databaseReference;

    /**
     * Is called when the activity is starting.
     * Initializes UI elements and sets click listeners for the save button.
     *
     * @param savedInstanceState If the activity is being initialized again after previously being closed
     *                           then this bundle will contain the data it recently provided in
     *                           onSaveInstanceState.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Below, it sets the view of this activity to the layout file called "employer_profile_page".
        this.setContentView(R.layout.employer_profile_page);

        // Connecting the relevant UI elements from the xml files.
        TextInputLayout industryTypeField = findViewById(R.id.industryType);
        TextInputLayout idNumField = findViewById(R.id.idNum);
        TextInputLayout hiringStatusField = findViewById(R.id.hiringStatus);
        TextInputLayout phoneNumField = findViewById(R.id.phoneNum);
        Button theSaveButton = findViewById(R.id.saveButton);

        /**
         * Enables the EditText field for interaction and sets it focusable.
         */
        hiringStatusField.getEditText().setFocusable(true);
        hiringStatusField.getEditText().setFocusableInTouchMode(true);

        /**
         * Sets a click listener to the save button.
         * When clicked, this listener gets the values entered by the user from various input fields
         * (industry type, ID number, hiring status, phone number).
         * It then validates these inputs using helper methods and displays a success or failure message appropriately.
         */
        theSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get values entered by the user from input fields
                String industryTypeX = industryTypeField.getEditText().getText().toString();
                String idNumX = idNumField.getEditText().getText().toString();
                String hiringStatusX = hiringStatusField.getEditText().getText().toString();
                String phoneNumX = phoneNumField.getEditText().getText().toString();

                // Creating Snackbar objects for success and failure messages
                Snackbar successSnackbar = Snackbar.make(findViewById(android.R.id.content),"SUCCESS!", Snackbar.LENGTH_SHORT);
                Snackbar failSnackbar = Snackbar.make(findViewById(android.R.id.content),"FAILURE!", Snackbar.LENGTH_SHORT);

                // Validates the inputs using helper methods and display appropriate message
                if (isValidIndustryType(industryTypeX) && isValidHiringStatus(hiringStatusX) &&
                        isValidPhoneNumber(phoneNumX) && isValidIdNumber(idNumX)) {
                    successSnackbar.show();
                }
                else {
                    failSnackbar.show();
                }
            }
        });
    }

    /**
     * Validates the provided industry type with a list of valid industry types.
     *
     * @param industryType The industry type to be validated.
     * @return true if the industry type is valid, false otherwise.
     */
    public static boolean isValidIndustryType(String industryType) {
        for (int i = 0; i < AppConstants.VALID_INDUSTRIES.length; i++) {
            if (AppConstants.VALID_INDUSTRIES[i].equalsIgnoreCase(industryType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates the provided industry type against a list of valid industry types.
     *
     * @param hiringStatus The hiring status to be validated.
     * @return true if the hiring status is valid, false otherwise.
     */
    public static boolean isValidHiringStatus(String hiringStatus) {
        for (int i = 0; i < AppConstants.VALID_HIRING_STATUS.length; i++) {
            if (AppConstants.VALID_HIRING_STATUS[i].equalsIgnoreCase(hiringStatus)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates the provided industry type against a list of valid industry types.
     *
     * @param idNumber The id number to be validated.
     * @return true if the id number is valid, false otherwise.
     */
    public static boolean isValidIdNumber(String idNumber) {
        for (int i = 0; i < AppConstants.VALID_ID.length; i++) {
            if (AppConstants.VALID_ID[i].equalsIgnoreCase(idNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates the provided industry type against a list of valid industry types.
     *
     * @param phoneNumber The phone number to be validated.
     * @return true if the phone number is valid, false otherwise.
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        for (int i = 0; i < AppConstants.VALID_PHONE_NUM.length; i++) {
            if (AppConstants.VALID_PHONE_NUM[i].equalsIgnoreCase(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
