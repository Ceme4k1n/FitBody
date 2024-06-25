package com.example.fitness

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitness.floating_menus.home_page_screen
import com.example.fitness.workout.first_train_screen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class train_screenTest {

    @Before
    fun setUp() {
        Intents.init()
        ActivityScenario.launch(first_train_screen::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun back_toHomePage() {
        Espresso.onView(ViewMatchers.withId(R.id.text_train_trainPage)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(home_page_screen::class.java.name))
    }

    @Test
    fun selectPause_Button() {
        Espresso.onView(ViewMatchers.withId(R.id.pause_button_trainPage)).perform(ViewActions.click())
    }

    @Test
    fun selectStart_Button() {
        Espresso.onView(ViewMatchers.withId(R.id.play_button_trainPage)).perform(ViewActions.click())
    }
}