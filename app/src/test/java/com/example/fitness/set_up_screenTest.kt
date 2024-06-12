package com.example.fitness

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import com.example.fitness.setup_pages.select_gender_screen
import com.example.fitness.setup_pages.set_up_screen
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SetUpScreenTest {

    @Test
    fun testButtonContinueClick() {
        // Запускаем MainActivity
        val scenario = ActivityScenario.launch(set_up_screen::class.java)

        // Нажимаем на кнопку

        // Проверяем, что StartScreen активити была запущена
        scenario.onActivity { activity ->
            val expectedIntent = Intent(activity, select_gender_screen::class.java)
            val actualIntent = activity.intent
            assertEquals(expectedIntent.component, actualIntent.component)
        }
    }
}


