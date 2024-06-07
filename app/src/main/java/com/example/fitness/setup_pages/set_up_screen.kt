package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class set_up_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_screen)

        val button_continue : Button = findViewById(R.id.button_next_setupPage)

        button_continue.setOnClickListener {
            var intent = Intent(this, select_weight_screen::class.java)
            startActivity(intent)
        }


    }
}