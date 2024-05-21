package com.example.fitness

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.login_singin.login_screen
import com.example.fitness.login_singin.singin_screen
import com.example.fitness.on_boarding.start_screen
import com.example.fitness.setup_pages.select_gender_screen

class Splash_Screen : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        handler = Handler()
        handler.postDelayed({

            var intent = Intent(this, login_screen::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

}
