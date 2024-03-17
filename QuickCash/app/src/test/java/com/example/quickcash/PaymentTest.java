//package com.example.quickcash;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.example.quickcash.R;
//import com.example.quickcash.ui.PayPal.Payment;
//import com.paypal.android.sdk.payments.PayPalConfiguration;
//import com.paypal.android.sdk.payments.PayPalPayment;
//import com.paypal.android.sdk.payments.PaymentActivity;
//import com.paypal.android.sdk.payments.PaymentConfirmation;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.math.BigDecimal;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class PaymentTest {
//
//    @Mock
//    EditText mockEnterAmtET;
//
//    @Mock
//    Button mockPayNowBtn;
//
//    @Mock
//    TextView mockPaymentStatusTV;
//
//    @Mock
//    PaymentConfirmation mockPaymentConfirmation;
//
//    Payment paymentActivity;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        paymentActivity = Mockito.spy(Payment.class);
//        Mockito.doNothing().when(paymentActivity).init();
//        Mockito.doNothing().when(paymentActivity).configPayPal();
//        Mockito.doNothing().when(paymentActivity).initActivityLauncher();
//        Mockito.doNothing().when(paymentActivity).setListeners();
//        when(paymentActivity.findViewById(R.id.enterAmtET)).thenReturn(mockEnterAmtET);
//        when(paymentActivity.findViewById(R.id.payNowBtn)).thenReturn(mockPayNowBtn);
//        when(paymentActivity.findViewById(R.id.paymentStatusTV)).thenReturn(mockPaymentStatusTV);
//    }
//
//    @Test
//    public void testProcessPayment() {
//        // Setup
//        String amount = "100";
//        when(mockEnterAmtET.getText()).thenReturn(new MockEditable(amount));
//
//        PayPalConfiguration payPalConfiguration = new PayPalConfiguration();
//        when(paymentActivity.payPalConfig).thenReturn(payPalConfiguration);
//
//        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(amount), "CAD", "Purchase Goods", PayPalPayment.PAYMENT_INTENT_SALE);
//        Intent expectedIntent = new Intent();
//        expectedIntent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
//        expectedIntent.putExtra(PaymentActivity.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
//
//        // Call method
//        paymentActivity.processPayment();
//
//        // Verify
//        verify(paymentActivity).activityResultLauncher.launch(any(Intent.class));
//    }
//}
