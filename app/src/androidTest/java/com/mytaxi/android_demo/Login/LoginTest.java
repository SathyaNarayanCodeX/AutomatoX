package com.mytaxi.android_demo.Login;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.ContactsContract;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.filters.LargeTest;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.AuthenticatedActivity;
import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;

import java.io.File;

import static android.support.test.InstrumentationRegistry.getArguments;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static com.mytaxi.android_demo.reusableComponents.DataFeeder.*;
import static com.mytaxi.android_demo.reusableComponents.LaunchIntents.clearSharedPreferences;
import static com.mytaxi.android_demo.reusableComponents.LaunchIntents.launchMainActivity;

@RunWith(AndroidJUnit4.class)
public class LoginTest {
    @Before
    public void setup() {
        launchMainActivity();
    }

    @Test
    public void validLogin() throws InterruptedException {
        new LoginScreen()
                .enterCredentials(VALID_USERNAME, VALID_PASSWORD)
                .tapLoginButton()
                .verifyUserInLandingScreen(VALID_USERNAME);
    }

    @Test
    public void invalidLoginVerifyErrorMessage() throws Exception {
        new LoginScreen()
                .enterCredentials(INVALID_USERNAME, INVALID_PASSWORD)
                .checkInvalidLoginErrorMessage();
    }

    @Test
    public void emptyCredentials() throws InterruptedException {
        new LoginScreen()
                .enterCredentials(EMPTY_USERNAME, EMPTY_PASSWORD)
                .checkInvalidLoginErrorMessage();
    }

    @Test
    public void logout() throws InterruptedException {
        new LoginScreen()
                .enterCredentials(VALID_USERNAME, VALID_PASSWORD)
                .tapLoginButton()
                .verifyUserInLandingScreen(VALID_USERNAME)
                .logout();
    }
}
