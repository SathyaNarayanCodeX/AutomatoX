package com.mytaxi.android_demo.Landing;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Root;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.KeyEvent;

import com.mytaxi.android_demo.Login.LoginScreen;
import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isCompletelyBelow;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftAlignedWith;
import static android.support.test.espresso.assertion.PositionAssertions.isPartiallyLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isPartiallyRightOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightAlignedWith;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.*;
import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.tapOnItemWithId;
import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.tapOnNativeBackButton;
import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.verifyText;

import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.verifyTextWithDescendant;
import static com.mytaxi.android_demo.reusableComponents.CustomViewInteractions.verifyTextWithDescendantInputString;
import static org.hamcrest.core.AllOf.allOf;

public class LandingScreen {

    public LandingScreen() {

        verifyTextWithDescendant(R.id.toolbar, R.string.app_name);
    }

    public LandingScreen verifyUserInLandingScreen(String username) {
        verifyTextWithDescendant(R.id.toolbar, R.string.app_name);
        onView(allOf(withContentDescription(R.string.navigation_drawer_open))).perform(click());
        verifyTextWithInputString(R.id.nav_username, username);
//        onView(allOf(withId(R.id.nav_username), (withText(username)))).check(matches(isDisplayed()));
        tapOnNativeBackButton();
        return this;
    }

    public LandingScreen enterTextInSearchDriverTextBox(String driverName) throws InterruptedException {
        sendKeysCloseKeyboard(R.id.textSearch, driverName);
        Thread.sleep(3000);
        //onView(withId(R.id.textSearch)).check(matches(isDisplayed())).perform(typeText(" "), pressKey(KeyEvent.KEYCODE_DEL));
        return this;
    }

    public LandingScreen selectDriverFromPopUP(String driverFullName) {
        onView(withText(driverFullName)).inRoot(isPopupWindow()).perform(click());
        return this;
    }

    public LandingScreen verifyDriverDetailsAlingment() {
        onView(allOf(withId(R.id.textViewDriverName))).check(isCompletelyAbove(withId(R.id.textViewDriverLocation)));
        onView(allOf(withId(R.id.textViewDriverLocation))).check(isCompletelyAbove(withId(R.id.textViewDriverDate)));
        onView(allOf(withId(R.id.textViewDriverDate))).check(isCompletelyBelow(withId(R.id.textViewDriverLocation)));
        return this;
    }

    public LandingScreen verifyDriver(String driverFullName, String location, String driverDate) {
        verifyTextWithInputString(R.id.textViewDriverName, driverFullName);
        verifyTextWithInputString(R.id.textViewDriverLocation, location);
        verifyTextWithInputString(R.id.textViewDriverDate, driverDate);
        return this;
    }

    public LandingScreen tapOnCallIcon() {
        tapOnItemWithId(R.id.fab);
        return this;
    }

    public LoginScreen logout() {
        onView(allOf(withContentDescription(R.string.navigation_drawer_open))).perform(click());
        tapOnItemWithText(R.string.text_item_title_logout);
        return new LoginScreen();
    }

    public static Matcher<Root> isPopupWindow() {
        return isPlatformPopup();
    }

}
