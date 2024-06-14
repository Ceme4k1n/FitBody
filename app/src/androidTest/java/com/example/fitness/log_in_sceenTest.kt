package com.example.fitness

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitness.login_singin.login_screen
import com.example.fitness.login_singin.singin_screen
import com.example.fitness.on_boarding.start_screen
import com.example.fitness.setup_pages.goal_screen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class log_in_screenTest {

    @Before
    fun setUp() {
        Intents.init()
        ActivityScenario.launch(login_screen::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun back_toOnBoarding() {
        Espresso.onView(ViewMatchers.withId(R.id.imagebutton_back_loginpage)).perform(ViewActions.click())

        //Intents.intended(IntentMatchers.hasComponent(start_screen::class.java.name))

    }

    @Test
    fun press_sing_in() {

        Espresso.onView(ViewMatchers.withId(R.id.button_sing_in_loginpage)).perform(ViewActions.click())

        Intents.intended(IntentMatchers.hasComponent(singin_screen::class.java.name))

    }
}