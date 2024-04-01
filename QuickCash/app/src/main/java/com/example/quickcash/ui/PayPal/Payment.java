package com.example.quickcash.ui.PayPal;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import com.example.quickcash.R;
import java.math.BigDecimal;

import com.example.quickcash.util.AppConstants;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
/**
 * This class represents the PayPal payment functionality within the application.
 * It allows users to make payments using PayPal.
 */

public class Payment extends AppCompatActivity {

    private static final String TAG = Payment.class.getName();

    //launching a previously-prepared call to start the process of executing an ActivityResultContract.
    private ActivityResultLauncher<Intent> activityResultLauncher;
    private PayPalConfiguration payPalConfig;

    //UI Elements
    private EditText enterAmtET;
    private Button payNowBtn;
    private TextView paymentStatusTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutpaypal);
        init();
        configPayPal();
        initActivityLauncher();
        setListeners();
    }

    /**
     * Initialize UI elements.
     * Text field : enterAmt , payment status
     * Button : payNow button
     */
    private void init() {
        enterAmtET = findViewById(R.id.enterAmtET);
        payNowBtn = findViewById(R.id.payNowBtn);
        paymentStatusTV = findViewById(R.id.paymentStatusTV);
    }

    /**
     * Configure PayPal settings.
     */
    private void configPayPal() {
        payPalConfig = new PayPalConfiguration()
                .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
                .clientId(AppConstants.PAYAPAL_CLIENTID);
    }

    /**
     * Initialize ActivityResultLauncher for handling activity results.
     */
    private void initActivityLauncher() {
        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        final PaymentConfirmation confirmation = result.getData().getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                        if (confirmation != null) {
                            try {
                                // Get the payment details
                                String paymentDetails = confirmation.toJSONObject().toString(4);
                                Log.i(TAG, paymentDetails);
                                // Extract json response and display it in a text view.
                                JSONObject payObj = new JSONObject(paymentDetails);
                                String payID = payObj.getJSONObject("response").getString("id");
                                String state = payObj.getJSONObject("response").getString("state");
                                paymentStatusTV.setText(String.format("Payment %s%n with payment id is %s", state, payID));
                            } catch (JSONException e) {
                                Log.e("Error", "an extremely unlikely failure occurred: ", e);
                            }
                        }
                    } else if (result.getResultCode() == PaymentActivity.RESULT_EXTRAS_INVALID) {
                        Log.d(TAG, "Launcher Result Invalid");
                    } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        Log.d(TAG, "Launcher Result Cancelled");
                    }
                });
    }

    /**
     * Set listeners for UI elements.
     */
    private void setListeners() {
        payNowBtn.setOnClickListener(v -> processPayment());
    }

    /**
     * This method takes the user to the page which can perform transactoion
     * towards the employee where they can finish the payments.
     */
    private void processPayment() {
        final String amount = enterAmtET.getText().toString();
        final PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(
                amount), "CAD", "Purchase Goods", PayPalPayment.PAYMENT_INTENT_SALE);

        // Create Paypal Payment activity intent
        final Intent intent = new Intent(this, PaymentActivity.class);
        // Adding paypal configuration to the intent
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfig);
        // Adding paypal payment to the intent
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        // Starting Activity Request launcher
        activityResultLauncher.launch(intent);
    }
}
