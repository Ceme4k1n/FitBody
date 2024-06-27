package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.login_singin.login_screen

class set_up_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_screen)

        val button_continue : TextView = findViewById(R.id.button_next_setupPage)
        val button_back : ImageView = findViewById(R.id.imagebutton_back_setupPage)
        var mobile_number_set_up: String
        var user_name_setup: String
        button_back.setOnClickListener {
            var intent = Intent(this, login_screen::class.java)
            startActivity(intent)
        }
        mobile_number_set_up = intent.extras?.getString("mobile_number_to_setup") ?: "No message found"
        user_name_setup = intent.extras?.getString("nickname_to_setup") ?: "No message found"
        var user_email= intent.extras?.getString("email_to_setup") ?: "No message found"


        button_continue.setOnClickListener {
            var intent2 = Intent(this, select_gender_screen::class.java)
            intent2.putExtra("mobile_number_to_gender",mobile_number_set_up)
            intent2.putExtra("nickname_to_gender",user_name_setup)
            intent2.putExtra("email_to_gender",user_email)

            startActivity(intent2)
        }
    }
}