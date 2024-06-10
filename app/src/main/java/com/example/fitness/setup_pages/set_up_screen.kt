package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R
import com.example.fitness.login_singin.login_screen
import com.example.fitness.on_boarding.start_screen

class set_up_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_screen)

        val button_continue : TextView = findViewById(R.id.button_next_setupPage)
        val button_back : ImageView = findViewById(R.id.imagebutton_back_setupPage)

        button_back.setOnClickListener {
            var intent = Intent(this, login_screen::class.java)
            startActivity(intent)
        }


        button_continue.setOnClickListener {
            var intent = Intent(this, select_gender_screen::class.java)
            startActivity(intent)
        }


    }
}