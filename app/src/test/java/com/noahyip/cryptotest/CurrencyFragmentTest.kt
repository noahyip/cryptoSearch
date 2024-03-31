package com.noahyip.cryptotest.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test
import org.junit.runner.RunWith

class CurrencyListFragmentTest {

    @Test
    fun testCurrencyListFragment() {
        launchFragmentInContainer<CurrencyListFragment>()

        Espresso.onView(ViewMatchers.withId(R.id.rvCurrencyList))
            .check(matches(isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.etSearch))
            .check(matches(isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.ivSearch))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.etSearch))
            .perform(ViewActions.typeText("Bitcoin"))

        Espresso.onView(ViewMatchers.withId(R.id.rvCurrencyList))
            .check(matches(hasDescendant(withText("Bitcoin"))))

        Espresso.onView(ViewMatchers.withId(R.id.ivClose))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.etSearch))
            .check(matches(withText("")))

        Espresso.onView(ViewMatchers.withId(R.id.ivBack))
            .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.etSearch))
            .check(matches(withText("")))
    }
}