package com.example.fitness

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitness.on_boarding.start_screen
import com.example.fitness.setup_pages.select_gender_screen
import com.example.fitness.setup_pages.set_up_screen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class start_screenTest {

    @Before
    fun setUp() {
        Intents.init()
        ActivityScenario.launch(start_screen::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testTextViewClickNavigatesToNext_Woman() {
        onView(withId(R.id.imagewelcome_to_fitbody)).perform(click())

    }


    @Test
    fun testTextViewClickNavigatesToNext_ManTwo() {
        onView(withId(R.id.imageButton_get_started)).perform(click())
    }


    @Test
    fun testTextViewClickNavigatesToNext_Man() {
        onView(withId(R.id.imageButton_next_on_man)).perform(click())
    }

    @Test
    fun testTextViewClickNavigatesToNext_WomanTwo() {
        onView(withId(R.id.button_next_woman_on_board)).perform(click())
    }



    @Test
    fun testTextViewClickSkip() {
        onView(withId(R.id.textskip_man_on_board_man_one)).perform(click())
    }



}