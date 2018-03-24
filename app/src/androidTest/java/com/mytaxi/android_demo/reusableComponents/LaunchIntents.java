package com.mytaxi.android_demo.reusableComponents;


import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import java.io.File;

import static android.support.test.InstrumentationRegistry.getTargetContext;

public final class LaunchIntents {
    private LaunchIntents() {
        throw new UnsupportedOperationException("No instance allowed!");
    }


    public static void launchMainActivity() {
        ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
        private IdlingResource mIdlingResource = mActivityRule.getActivity().isActivityTransitionRunning();
        // To prove that the test fails, omit this call:
        Espresso.registerIdlingResources(mIdlingResource);
        Intent intent = new Intent(getTargetContext(), MainActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        clearSharedPreferences();
        mActivityRule.launchActivity(intent);
    }


    public static void clearSharedPreferences() {
        File root = InstrumentationRegistry.getTargetContext().getFilesDir().getParentFile();
        String[] sharedPreferencesFileNames = new File(root, "shared_prefs").list();
        if (sharedPreferencesFileNames == null) {
            return;
        }
        for (String fileName : sharedPreferencesFileNames) {
            String preferenceFileName = fileName.replace(".xml", "");
            InstrumentationRegistry.getTargetContext()
                    .getSharedPreferences(preferenceFileName, Context.MODE_PRIVATE)
                    .edit()
                    .clear()
                    .commit();
        }
    }

    public static TypeSafeMatcher<View> isVisible() {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                return item.getVisibility() == View.VISIBLE;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("is VISIBLE");
            }
        };
    }



}
