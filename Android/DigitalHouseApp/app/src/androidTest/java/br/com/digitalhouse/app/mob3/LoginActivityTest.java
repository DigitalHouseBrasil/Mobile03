package br.com.digitalhouse.app.mob3;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testEmailAndPasswordIsValid() {
        onView(withId(R.id.edit_input_email)).perform(replaceText("tairo@digitahouse.com"), closeSoftKeyboard());
        onView(withId(R.id.edit_input_password)).perform(replaceText("123456"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()));
    }

    @Test
    public void testEmailNotValid() {
        onView(withId(R.id.edit_input_email)).perform(replaceText("digitahouse.com"), closeSoftKeyboard());
        onView(withId(R.id.edit_input_password)).perform(replaceText("123456"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("Email ou senha invalidos!")).
                inRoot(
                        withDecorView(not(activityRule.getActivity().getWindow().getDecorView()))
                ).check(matches(isDisplayed()));
    }

    @Test
    public void testPasswordNotValid() {
        onView(withId(R.id.edit_input_email)).perform(replaceText("tairo@digitahouse.com"), closeSoftKeyboard());
        onView(withId(R.id.edit_input_password)).perform(replaceText("123"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withText("Email ou senha invalidos!")).
                inRoot(
                        withDecorView(not(activityRule.getActivity().getWindow().getDecorView()))
                ).check(matches(isDisplayed()));
    }
}