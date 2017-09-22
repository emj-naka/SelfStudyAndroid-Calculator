package com.example.emj.selfstudyandroid_calculator;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private Activity mActivity;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule(MainActivity.class);

    @Before
    public void setUp(){
        // Activityの取得
        mActivity = mActivityRule.getActivity();
    }

    @Test
    public void useAppContext() throws Exception {


        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//        onView(withText("0.0"));
//
//        assertEquals("com.example.emj.selfstudyandroid_calculator", appContext.getPackageName());
    }
}
