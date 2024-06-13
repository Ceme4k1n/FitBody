package com.example.fitness

import android.content.Context
import android.provider.Settings
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.fitness.setup_pages.select_gender_screen
import com.example.fitness.setup_pages.set_up_screen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SetUpScreenTest {

    @Before
    fun setUp() {
        Intents.init()
        ActivityScenario.launch(set_up_screen::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testTextViewClickNavigatesToSelectGenderScreen() {
        // Найдите TextView по его ID и выполните клик
        onView(withId(R.id.button_next_setupPage)).perform(click())

        // Проверьте, что произошел переход на SelectGenderScreenActivity
        Intents.intended(hasComponent(select_gender_screen::class.java.name))
    }


}
