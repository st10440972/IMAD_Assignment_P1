package com.example.imadassignmentp1

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyUnitTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testValidYear() {
        val validYear = "1969"
        onView(withId(R.id.edtYear)).perform(typeText(validYear))
        onView(withId(R.id.btnProceed)).perform(click())
        onView(withId(R.id.txtResult)).check(matches(withText("In 1969: Bith of Alexander McQueen, known as one of the best fashion designer")))
    }

    private fun withId(edtYear: Int) {

    }

    private fun typeText(validYear: String) {

    }

    private fun onView(withId: Any) {

    }

    private fun click() {

    }

    @Test
    fun testInvalidYear() {
        val invalidYear = "abcd"
        onView(withId(R.id.edtYear)).perform(typeText(invalidYear))
        onView(withId(R.id.btnProceed)).perform(click())
        onView(withId(R.id.txtResult)).check(matches(withText("Please enter a valid year.")))
    }

    @Test
    fun testOutOfRangeYear() {
        val outOfRangeYear = "1499"
        onView(withId(R.id.edtYear)).perform(typeText(outOfRangeYear))
        onView(withId(R.id.btnProceed)).perform(click())
        onView(withId(R.id.txtResult)).check(matches(withText("Please enter a birth year between 1500 and 2024.")))
    }

    @Test
    fun testNoYearEntered() {
        onView(withId(R.id.btnProceed)).perform(click())
        onView(withId(R.id.txtResult)).check(matches(withText("Please enter a birth year.")))
    }

    private fun withText(s: String) {

    }

    private fun matches(withText: Unit) {

    }
}
