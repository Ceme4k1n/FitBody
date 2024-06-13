package com.example.fitness

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @Test
    fun testSplashScreenOpens() {
        // Запускаем Splash_Screen
        val scenario = ActivityScenario.launch(Splash_Screen::class.java)

        // Проверяем, что активность запущена
        assertNotNull(scenario)

        // Закрываем сценарий
        scenario.close()
    }
}
