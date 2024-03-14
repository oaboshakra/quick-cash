package com.example.quickcash;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.example.quickcash.ui.PayPal.Payment;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PaymentActivityTest {

    @Rule
    public ActivityScenarioRule<Payment> activityScenarioRule =
            new ActivityScenarioRule<>(Payment.class);

    @Test
    public void testEnterValidEmployeeName() {
        // Enter valid employee name
        Espresso.onView(ViewMatchers.withId(R.id.employeeNameET))
                .perform(ViewActions.typeText("John Doe"), ViewActions.closeSoftKeyboard());

        // Check if entered employee name is displayed
        Espresso.onView(ViewMatchers.withId(R.id.employeeNameET))
                .check(matches(withText("John Doe")));
    }

    @Test
    public void testEnterValidAccountDetails() {
        // Enter valid account details
        Espresso.onView(ViewMatchers.withId(R.id.accountDetailsET))
                .perform(ViewActions.typeText("1234567890"), ViewActions.closeSoftKeyboard());

        // Check if entered account details are displayed
        Espresso.onView(ViewMatchers.withId(R.id.accountDetailsET))
                .check(matches(withText("1234567890")));
    }

    @Test
    public void testEnterValidAmount() {
        // Enter valid amount
        Espresso.onView(ViewMatchers.withId(R.id.enterAmtET))
                .perform(ViewActions.typeText("100"), ViewActions.closeSoftKeyboard());

        // Check if entered amount is displayed
        Espresso.onView(ViewMatchers.withId(R.id.enterAmtET))
                .check(matches(withText("100")));
    }

    @Test
    public void testClickPayButton() {
        // Click on the pay button
        Espresso.onView(ViewMatchers.withId(R.id.payNowBtn)).perform(ViewActions.click());

        // Check if payment status is displayed
        Espresso.onView(ViewMatchers.withId(R.id.paymentStatusTV))
                .check(matches(isDisplayed()));

        // Check if payment status indicates success
        Espresso.onView(ViewMatchers.withId(R.id.paymentStatusTV))
                .check(matches(withText("Payment successful"))); // You might adjust this according to your app logic
    }
}
