package evotor.ru.qatester;

/**
 * Created by User on 25.06.2016.
 */

import android.support.test.filters.SmallTest;
import android.test.ActivityInstrumentationTestCase2;

import com.google.android.libraries.cloudtesting.screenshots.ScreenShotter;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@SmallTest

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivityTestData mainActivityTestData = new MainActivityTestData();// Подгружаем эталонный текст (текст получаем в конструкторе класса)


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    @Test
    public void testMainActivity() {

        onView(withId(R.id.textView)).check(matches(withText("TextView"))); //Проверяем TextView на наличие и текст
        onView(withId(R.id.button)).perform(click());// Клик по кнопке
        onView(withId(R.id.textView)).check(matches(withText(mainActivityTestData.getTestdata())));// сравниваем полученный текст и эталонный
        ScreenShotter.takeScreenshot("main_screen", getActivity());
    }



}
