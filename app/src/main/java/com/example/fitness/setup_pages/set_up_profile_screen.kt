package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class set_up_profile_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_profile_screen)

        val button_back : TextView = findViewById(R.id.textback_button_setupProfile)
        val button_start : Button = findViewById(R.id.button_start_setupProfile)

        button_start.setOnClickListener {
            //var intent = Intent(this, physical_act_screen::class.java)
            //startActivity(intent)
        }

        button_back.setOnClickListener {
            var intent = Intent(this, physical_act_screen::class.java)
            startActivity(intent)
        }

    }
}