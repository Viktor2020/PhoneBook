package student.ppjava13v1.itstep.phonebook;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAddNewContact() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_add_record)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.etName)).perform(ViewActions.typeText("nameTest"));
        Espresso.onView(ViewMatchers.withId(R.id.etNumber)).perform(ViewActions.typeText("123456"));
        Espresso.onView(ViewMatchers.withText(R.string.btn_ok)).perform(ViewActions.click());
    }
}
