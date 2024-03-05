package com.example.quickcash;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.quickcash.R;
import com.example.quickcash.ui.employerProfile.EmployerProfile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ProfileUITest {

    private static final String INDUSTRY_TYPE = "Technology";
    private static final String ID_NUMBER = "123456";
    private static final String HIRING_STATUS = "Yes";
    private static final String PHONE_NUMBER = "1234567890";

    @Before
    public void launchActivity() {
        ActivityScenario.launch(EmployerProfile.class);
    }

    @Test
    public void testIndustryTypeInput() {
        Espresso.onView(withId(R.id.industryTypeTitle)).perform(typeText(INDUSTRY_TYPE), closeSoftKeyboard());
        Espresso.onView(withId(R.id.industryTypeTitle)).check(matches(withText(INDUSTRY_TYPE)));
    }

    @Test
    public void testIdNumberInput() {
        Espresso.onView(withId(R.id.idNumTitle)).perform(typeText(ID_NUMBER), closeSoftKeyboard());
        Espresso.onView(withId(R.id.idNumTitle)).check(matches(withText(ID_NUMBER)));
    }

    @Test
    public void testHiringStatusInput() {
        Espresso.onView(withId(R.id.hiringStatusTitle)).perform(typeText(HIRING_STATUS), closeSoftKeyboard());
        Espresso.onView(withId(R.id.hiringStatusTitle)).check(matches(withText(HIRING_STATUS)));
    }

    @Test
    public void testPhoneNumberInput() {
        Espresso.onView(withId(R.id.phoneNumTitle)).perform(typeText(PHONE_NUMBER), closeSoftKeyboard());
        Espresso.onView(withId(R.id.phoneNumTitle)).check(matches(withText(PHONE_NUMBER)));
    }
}




//package com.example.quickcash;
//
//import androidx.test.core.app.ActivityScenario;
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.action.ViewActions.typeText;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.example.quickcash.ui.employerProfile.EmployerProfile;
//import com.example.quickcash.util.AppConstants;
//
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//
//import static org.junit.Assert.assertFalse;
//
//import org.junit.runner.RunWith;
//
//
//@RunWith(AndroidJUnit4.class)
//public class ProfileUITest {
//
//    ActivityScenario<EmployerProfile> employerProfileActivityScenario;
//
//    @Before
//    public void setUp(){
//
//        employerProfileActivityScenario = ActivityScenario.launch(EmployerProfile.class);
//        employerProfileActivityScenario.onActivity(activity -> {
//
//        });
//    }
//    @Test
//    public void testValidIndustry() {
//        onView(withId(R.id.industryType)).perform(typeText("Painting"));
//        onView(withId(R.id.industryType)).check(matches(withText("Painting")));
//    }
//
//    @Test
//    public void testValidIDNum(){
//        onView(withId(R.id.idNum)).perform(typeText("123456"));
//        onView(withId(R.id.idNum)).check(matches(withText("123456")));
//    }
//    @Test
//    public void testHiringStatus() {
//        onView(withId(R.id.hiringStatus)).perform(typeText(AppConstants.VALID_HIRING_STATUS[0]));
//        onView(withId(R.id.hiringStatus)).check(matches(withText(AppConstants.VALID_HIRING_STATUS[0])));
//    }
//
//    @Test
//    public void testValidPhoneNum(){
//        onView(withId(R.id.phoneNum)).perform(typeText("7199209"));
//        onView(withId(R.id.phoneNum)).check(matches(withText("7199209")));
//    }
//}