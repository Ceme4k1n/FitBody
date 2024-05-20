package com.example.fitness.login_singin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R
import com.example.fitness.on_boarding.start_screen

class login_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val sing_in_button : TextView = findViewById(R.id.button_sing_in_loginpage)
        val forgott_pass_button : TextView = findViewById(R.id.button_forgot_pass_loginpage)


        sing_in_button.setOnClickListener {
            var intent = Intent(this, singin_screen::class.java)
            startActivity(intent)
        }

        forgott_pass_button.setOnClickListener {
            var intent = Intent(this, forgot_pass_sceeen::class.java)
            startActivity(intent)
        }
    }
}