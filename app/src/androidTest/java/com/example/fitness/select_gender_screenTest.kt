package com.example.fitness

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fitness.setup_pages.how_old_screen
import com.example.fitness.setup_pages.select_gender_screen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SetGenderScreenTest {

    @Before
    fun setUp() {
        Intents.init()
        ActivityScenario.launch(select_gender_screen::class.java)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testTextViewClickNavigatesToHowOldScreen() {
        // Найдите TextView по его ID и выполните клик
        onView(withId(R.id.button_next_setupPage)).perform(click())

        // Проверьте, что произошел переход на how_old_screen
        Intents.intended(hasComponent(how_old_screen::class.java.name))
    }


}
