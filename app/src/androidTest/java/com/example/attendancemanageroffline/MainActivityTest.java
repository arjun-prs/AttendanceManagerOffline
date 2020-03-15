package com.example.attendancemanageroffline;

import android.app.Activity;
import android.app.Instrumentation;
import android.widget.EditText;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(adminInterface.class.getName(),null,false);
    public ActivityTestRule<adminInterface> adminActivityTestRule = new ActivityTestRule<adminInterface>(adminInterface.class);
    private adminInterface adminActivity = null;
    Instrumentation.ActivityMonitor adminmonitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
        adminActivity = adminActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOfAdminInterfaceOnButton()
    {
        assertNotNull(mActivity.findViewById(R.id.edButLogin));
        onView(withId(R.id.edButLogin)).perform(click());
        Activity adminInterface = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(adminInterface);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}
