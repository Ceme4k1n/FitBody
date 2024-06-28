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
import com.example.fitness.setup_pages.set_up_screen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SetGenderScreenTest {

    @Before
    fun setUpp() {
        Intents.init()
        ActivityScenario.launch(select_gender_screen::class.java)
    }

    @After
    fun tearDownn() {
        Intents.release()
    }

    @Test
    fun testTextViewClickNavigatesToHowOldScreen_Male() {
        // Найдите TextView по его ID и выполните клик
        onView(withId(R.id.imageButton_male_inactive_genderPage)).perform(click())
        onView(withId(R.id.button_continue_genderPage)).perform(click())

        // Проверьте, что произошел переход на how_old_screen
        Intents.intended(hasComponent(how_old_screen::class.java.name))
    }

    @Test
    fun testTextViewClickNavigatesToHowOldScreen_Female() {
        // Найдите TextView по его ID и выполните клик
        onView(withId(R.id.imageButton_female_inactive_genderPage)).perform(click())
        onView(withId(R.id.button_continue_genderPage)).perform(click())

        // Проверьте, что произошел переход на how_old_screen
        Intents.intended(hasComponent(how_old_screen::class.java.name))
    }

    @Test
    fun testTextViewClickNavigatesToBack() {
        // Найдите TextView по его ID и выполните клик
        onView(withId(R.id.textback_button_genderPage)).perform(click())

        // Проверьте, что произошел переход на how_old_screen
        Intents.intended(hasComponent(set_up_screen::class.java.name))
    }

    @Test
    fun testTextViewClickNavigatesToHowOldScreen_Without() {
        // Найдите TextView по его ID и выполните клик
        onView(withId(R.id.button_continue_genderPage)).perform(click())

    }
}
