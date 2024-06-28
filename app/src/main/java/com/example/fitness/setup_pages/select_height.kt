package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R

class select_height : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_height)

        val button_back : TextView = findViewById(R.id.textback_button_selectHeight)
        val button_cont : TextView = findViewById(R.id.button_continue_selectHeight)
        val select_height : EditText = findViewById(R.id.number_confirm_text_selectHeight)
        val phone_height=intent.extras?.getString("phone_to_height") ?: "No message found"
        val sex_height=intent.extras?.getString("sex_to_height") ?: "No message found"
        val age_height=intent.extras?.getString("age_to_height") ?: "No message found"
        val nickname_height=intent.extras?.getString("nickname_to_height") ?: "No message found"
        val weight_height=intent.extras?.getString("weight_to_height") ?: "No message found"
        var user_email= intent.extras?.getString("email_to_height") ?: "No message found"

        button_cont.setOnClickListener{
            var intent99 = Intent(this, goal_screen::class.java)
            intent99 .putExtra("phone_to_goal",phone_height)
            intent99 .putExtra("sex_to_goal",sex_height)
            intent99 .putExtra("age_to_goal",age_height)
            intent99 .putExtra("weight_to_goal",weight_height)
            intent99 .putExtra("nickname_to_goal",nickname_height)
            intent99 .putExtra("height_to_goal",select_height.text.toString())
            intent99 .putExtra("email_to_goal",user_email)
            startActivity(intent99)
            finish()
        }

        button_back.setOnClickListener{
            var intent = Intent(this, select_weight_screen::class.java)
            startActivity(intent)
            finish()
        }
    }
}