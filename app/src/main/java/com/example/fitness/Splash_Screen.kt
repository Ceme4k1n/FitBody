package com.example.fitness

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.floating_menus.home_page_screen
import com.example.fitness.floating_menus.profile_screen
import com.example.fitness.on_boarding.start_screen
import com.example.fitness.setup_pages.physical_act_screen
import com.example.fitness.setup_pages.set_up_screen
import com.example.fitness.workout.caesar_salat
import com.example.fitness.workout.cheeskeks
import com.example.fitness.workout.chiken
import com.example.fitness.workout.fruits
import com.example.fitness.workout.protein

class Splash_Screen : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        handler = Handler()
        handler.postDelayed({
            var intent = Intent(this, physical_act_screen::class.java)
            startActivity(intent)
            finish()
        }, 0)
    }

}
