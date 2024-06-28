package com.example.fitness.workout

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class chiken : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chiken)

        val save_res : TextView = findViewById(R.id.button_save_res_chik)
        val back_button : TextView = findViewById(R.id.text_meal_plans_chik)


        save_res.setOnClickListener {
            var intent = Intent(this, fruits::class.java)
            startActivity(intent)
            finish()
        }

        back_button.setOnClickListener {
            var intent = Intent(this, fruits::class.java)
            startActivity(intent)
            finish()
        }


    }
}