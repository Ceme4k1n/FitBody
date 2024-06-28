package com.example.fitness

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitness.setup_pages.goal_screen
import com.example.fitness.setup_pages.how_old_screen
import com.example.fitness.setup_pages.select_weight_screen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class weight_screenTest {

    @Before
    fun setUp() {
        Intents.init()
        ActivityScenario.launch(select_weight_screen::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun back_toHowOld() {
        Espresso.onView(ViewMatchers.withId(R.id.textback_button_selectWeight)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(how_old_screen::class.java.name))

    }

    @Test
    fun selectWeight_swipeLeft_toContinue() {
        Espresso.onView(ViewMatchers.withId(R.id.horizontalScrollView_selectWeight)).perform(ViewActions.swipeLeft())

        Espresso.onView(ViewMatchers.withId(R.id.button_continue_selectWeight)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(goal_screen::class.java.name))

    }
}