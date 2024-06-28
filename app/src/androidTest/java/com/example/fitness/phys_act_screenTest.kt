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
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class phys_act_screenTest {

    @Before
    fun setUp() {
        Intents.init()
        ActivityScenario.launch(physical_act_screen::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun back_toGoal() {
        Espresso.onView(ViewMatchers.withId(R.id.textback_button_physAcrt)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(goal_screen::class.java.name))

    }

    @Test
    fun selectBegginer_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.button_begginer_physAct)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_physAct)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(set_up_profile_screen::class.java.name))

    }

    @Test
    fun selectIntermediate_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.button_Intermediate_physAct)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_physAct)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(set_up_profile_screen::class.java.name))

    }

    @Test
    fun selectAdvance_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.button_Advance_physAct)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_physAct)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(set_up_profile_screen::class.java.name))

    }
}
