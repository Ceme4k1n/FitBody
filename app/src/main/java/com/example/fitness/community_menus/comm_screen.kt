package com.example.fitness.community_menus

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.floating_menus.home_page_screen
import com.example.fitness.on_boarding.start_screen

class comm_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comm_screen)

        val back_button : TextView = findViewById(R.id.text_favorite_commPage)

        back_button.setOnClickListener {
            var intent = Intent(this, home_page_screen::class.java)
            startActivity(intent)
            finish()
        }
    }
}