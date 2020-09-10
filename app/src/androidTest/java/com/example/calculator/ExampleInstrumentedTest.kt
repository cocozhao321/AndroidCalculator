package com.example.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
/*@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun simplePlus() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.calculator", appContext.packageName)
    }

}*/
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentatedTest {

    @Rule @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun simplePlus() {
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.answer)).check(matches(withText("2")))
        onView(withId(R.id.plus)).perform(click())
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.equals)).perform(click())
        onView(withId(R.id.answer)).check(matches(withText("4")))
    }
    @Test
    fun simpleMinus() {
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.answer)).check(matches(withText("2")))
        onView(withId(R.id.minus)).perform(click())
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.equals)).perform(click())
        onView(withId(R.id.answer)).check(matches(withText("0")))
    }
    @Test
    fun PlusMinus() {
        onView(withId(R.id.seven)).perform(click())
        onView(withId(R.id.plus)).perform(click())
        onView(withId(R.id.eight)).perform(click())
        onView(withId(R.id.plus)).perform(click())
        onView(withId(R.id.answer)).check(matches(withText("15")))
        onView(withId(R.id.one)).perform(click())
        onView(withId(R.id.zero)).perform(click())
    }
    @Test
    fun LongPress(){
        onView(withId(R.id.zero)).perform(click())
        onView(withId(R.id.plus)).perform(click())
        onView(withId(R.id.seven)).perform(click())
        onView(withId(R.id.equals)).perform(longClick())
        onView(withId(R.id.answer)).check(matches(withText("0")))
    }
    @Test
    fun PlusEqual(){
        onView(withId(R.id.nine)).perform(click())
        onView(withId(R.id.plus)).perform(click())
        onView(withId(R.id.equals)).perform(click())
        onView(withId(R.id.answer)).check(matches(withText("9")))
    }
    @Test
    fun EqualMinus(){
        onView(withId(R.id.nine)).perform(click())
        onView(withId(R.id.plus)).perform(click())
        onView(withId(R.id.three)).perform(click())
        onView(withId(R.id.equals)).perform(click())
        onView(withId(R.id.minus)).perform(click())
        onView(withId(R.id.one)).perform(click())
        onView(withId(R.id.two)).perform(click())
        onView(withId(R.id.equals)).perform(click())
        onView(withId(R.id.answer)).check(matches(withText("0")))
    }
}
