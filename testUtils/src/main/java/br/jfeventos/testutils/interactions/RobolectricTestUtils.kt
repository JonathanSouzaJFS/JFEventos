package br.jfeventos.testutils.interactions

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

fun Int.scrollAndClick() {
    onView(withId(this)).perform(scrollTo(), ViewActions.click())
}

fun Int.click() {
    onView(withId(this)).perform(ViewActions.click())
}

fun Int.isDisplayed() {
    onView(withId(this)).check(matches(ViewMatchers.isDisplayed()))
}

fun String.isDisplayed() {
    onView(withText(this)).check(matches(ViewMatchers.isDisplayed()))
}