package com.mytaxi.android_demo.Login;

import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.test.espresso.ViewInteraction_Factory;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.espresso.matcher.ViewMatchers.Visibility;
import android.view.View;
import android.widget.TextView;

import com.mytaxi.android_demo.Landing.LandingScreen;
import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.sendKeysCloseKeyboard;
import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.tapOnItemWithId;
import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.verifyText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.AnyOf.anyOf;

import com.mytaxi.android_demo.reusableComponents.*;

public class LoginScreen {

    public LoginScreen() {

        onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
    }

    public LoginScreen enterCredentials(String Username, String Password) {
        sendKeysCloseKeyboard(R.id.edt_username, Username);
        sendKeysCloseKeyboard(R.id.edt_password, Password);
        return this;
    }

    public LandingScreen tapLoginButton() throws InterruptedException {
        tapOnItemWithId(R.id.btn_login);
        Thread.sleep(6000);
        return new LandingScreen();
    }

    public LoginScreen checkInvalidLoginErrorMessage() throws InterruptedException {
        tapOnItemWithId(R.id.btn_login);
        Thread.sleep(2000);
        verifyText(R.id.snackbar_text, R.string.message_login_fail);
        return this;
    }


}
