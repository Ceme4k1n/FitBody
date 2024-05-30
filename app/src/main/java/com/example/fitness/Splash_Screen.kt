package com.example.fitness

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.floating_menus.home_page_screen
import com.example.fitness.floating_menus.profile_screen

class Splash_Screen : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        handler = Handler()
        handler.postDelayed({
            var intent = Intent(this, home_page_screen::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

}
