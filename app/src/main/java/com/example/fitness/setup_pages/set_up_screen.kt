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
        var message5: String
        var message6: String
        button_back.setOnClickListener {
            var intent = Intent(this, login_screen::class.java)
            startActivity(intent)
        }
        message5 = intent.extras?.getString("message_to_set_up") ?: "No message found"
        message6 = intent.extras?.getString("fullname_to_setup") ?: "No message found"



        button_continue.setOnClickListener {
            var intent2 = Intent(this, select_gender_screen::class.java)
            intent2.putExtra("phone_number_to_gender",message5)
            intent2.putExtra("fullname_to_gender",message6)
            startActivity(intent2)
        }
    }
}