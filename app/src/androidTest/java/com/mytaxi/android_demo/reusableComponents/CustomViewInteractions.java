package com.mytaxi.android_demo.reusableComponents;

import android.support.annotation.StringRes;
import android.support.test.espresso.ViewInteraction;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

public final class CustomViewInteractions {

    private CustomViewInteractions() {
        // no instances
    }

    public static ViewInteraction tapOnItemWithText(@StringRes int textResourceId) {
        return onView(withText(textResourceId)).perform(click());
    }

    public static ViewInteraction tapOnNativeBackButton() {
        return onView(isRoot()).perform(pressBack());
    }

    public static ViewInteraction tapOnItemWithId(int itemName) {
        return onView(withId(itemName)).check(matches(isDisplayed())).perform(click());
    }

    public static ViewInteraction verifyText(int itemNameWithId, int textToVerify) {
        return onView(allOf(withId(itemNameWithId), withText(textToVerify))).check(matches(isDisplayed()));
    }
    public static ViewInteraction verifyTextWithDescendant(int itemNameWithId, int textToVerify) {
        return onView(allOf(withId(itemNameWithId), hasDescendant(withText(textToVerify)))).check(matches(isDisplayed()));
    }


    public static ViewInteraction verifyTextWithDescendantInputString(int itemNameWithId, String textToVerify) {
        return onView(allOf(withId(itemNameWithId), hasDescendant(withText(textToVerify)))).check(matches(isDisplayed()));
    }

    public static void sendKeysCloseKeyboard(int itemNameWithId,String itemTextToInput)
    {
         onView(withId(itemNameWithId)).perform(typeText(itemTextToInput), closeSoftKeyboard());
    }

//    public static ViewInteraction scrollToTextAndVerifyText(int itemNameWithId, int textToVeriy) {
//        return onView(withId(itemNameWithId)).perform(scrollTo(hasDescendant(withText(textToVeriy))));
//    }
}
