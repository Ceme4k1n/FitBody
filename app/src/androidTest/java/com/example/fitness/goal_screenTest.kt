package com.example.fitness

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitness.setup_pages.goal_screen
import com.example.fitness.setup_pages.physical_act_screen
import com.example.fitness.setup_pages.select_weight_screen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class goal_screenTest {

    @Before
    fun setUp() {
        Intents.init()
        ActivityScenario.launch(goal_screen::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun back_toWeight() {
        Espresso.onView(ViewMatchers.withId(R.id.textback_button_goalPage)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(select_weight_screen::class.java.name))

    }

    @Test
    fun selectOther_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.button_other_goalPage)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_goalPage)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(physical_act_screen::class.java.name))

    }

    @Test
    fun selectShapeBody_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.button_shape_body_goalPage)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_goalPage)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(physical_act_screen::class.java.name))

    }

    @Test
    fun selectMuscule_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.button_muscle_mass_gain_goalPage)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_goalPage)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(physical_act_screen::class.java.name))

    }

    @Test
    fun selectGainWeight_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.button_gain_weight_goalPage)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_goalPage)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(physical_act_screen::class.java.name))

    }

    @Test
    fun selectLoseWeight_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.button_lose_weight_goalPage)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_goalPage)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(physical_act_screen::class.java.name))

    }



}