package com.mytaxi.android_demo.Landing;


import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.Login.LoginScreen;
import com.mytaxi.android_demo.Login.LoginTest;
import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.mytaxi.android_demo.reusableComponents.DataFeeder.*;
import static com.mytaxi.android_demo.reusableComponents.LaunchIntents.launchMainActivity;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class LandingTest {

    @Before
    public void setup() {
        launchMainActivity();
    }


    @Test
    @Ignore
    public void searchDriver() throws InterruptedException {
        new LoginTest()
                .validLogin();
        new LandingScreen()
                .enterTextInSearchDriverTextBox(DRIVER_NAME_KEYWORD_SEARCH)
                .selectDriverFromPopUP(DRIVER_FULL_NAME)
                .verifyDriverDetailsAlingment()
                .verifyDriver(DRIVER_FULL_NAME, DRIVER_LOCATION, DRIVER_DATE);
    }

    @Test
    @Ignore
    public void searchDriverTapCallIcon() throws InterruptedException {

        new LoginTest()
                .validLogin();
        new LandingScreen()
                .enterTextInSearchDriverTextBox(DRIVER_NAME_KEYWORD_SEARCH)
                .selectDriverFromPopUP(DRIVER_FULL_NAME)
                .verifyDriver(DRIVER_FULL_NAME, DRIVER_LOCATION, DRIVER_DATE)
                .tapOnCallIcon();

    }

}
