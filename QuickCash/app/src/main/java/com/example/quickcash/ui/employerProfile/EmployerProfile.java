package com.example.quickcash.ui.employerProfile;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.quickcash.util.AppConstants;
import com.example.quickcash.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class EmployerProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private FirebaseAuth authentication;
    DatabaseReference databaseReference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.employer_profile_page);

        TextInputLayout industryTypeField = findViewById(R.id.industryType);
        TextInputLayout idNumField = findViewById(R.id.idNum);
        TextInputLayout hiringStatusField = findViewById(R.id.hiringStatus);
        TextInputLayout phoneNumField = findViewById(R.id.phoneNum);
        Button theSaveButton = findViewById(R.id.saveButton);
//        phoneNumField.setText

        hiringStatusField.getEditText().setFocusable(true);
        hiringStatusField.getEditText().setFocusableInTouchMode(true);

        theSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String industryTypeX = industryTypeField.getEditText().getText().toString();
                String idNumX = idNumField.getEditText().getText().toString();
                String hiringStatusX = hiringStatusField.getEditText().getText().toString();
                String phoneNumX = phoneNumField.getEditText().getText().toString();
//                String industryTypeX = industryTypeField.getText().toString();
//                String idNumX = idNumField.getText().toString();
//                String hiringStatusX = hiringStatusField.getText().toString();
//                String phoneNumX = phoneNumField.getText().toString();

                Snackbar successSnackbar = Snackbar.make(findViewById(android.R.id.content),"SUCCESS!", Snackbar.LENGTH_SHORT);
                Snackbar failSnackbar = Snackbar.make(findViewById(android.R.id.content),"FAILURE!", Snackbar.LENGTH_SHORT);

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

    public static boolean isValidIndustryType(String industryType) {
        for (int i = 0; i < AppConstants.VALID_INDUSTRIES.length; i++) {
            if (AppConstants.VALID_INDUSTRIES[i].equalsIgnoreCase(industryType)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidHiringStatus(String hiringStatus) {
        for (int i = 0; i < AppConstants.VALID_HIRING_STATUS.length; i++) {
            if (AppConstants.VALID_HIRING_STATUS[i].equalsIgnoreCase(hiringStatus)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidIdNumber(String idNumber) {
        for (int i = 0; i < AppConstants.VALID_ID.length; i++) {
            if (AppConstants.VALID_ID[i].equalsIgnoreCase(idNumber)) {
                return true;
            }
        }
        return false;
    }

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
