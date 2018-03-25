package com.mytaxi.android_demo.reusableComponents;


import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.action.ViewActions.click;

public final class LaunchIntents {
    private LaunchIntents() {
        throw new UnsupportedOperationException("No instance allowed!");
    }


    public static void launchMainActivity() {
        ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
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


}
