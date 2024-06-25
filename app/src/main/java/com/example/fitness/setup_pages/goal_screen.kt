package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.login_singin.Users_dannie

class goal_screen : AppCompatActivity() {

    private var currentBackgroundResource: Int = R.drawable.rounded_goal_button

    override fun onCreate(savedInstanceState: Bundle?) {
        var user = Users_dannie()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal_screen)

        val button_other : TextView = findViewById(R.id.button_other_goalPage)
        val button_shape_body : TextView = findViewById(R.id.button_shape_body_goalPage)
        val button_muscle_mass_gain : TextView = findViewById(R.id.button_muscle_mass_gain_goalPage)
        val button_gain_weight : TextView = findViewById(R.id.button_gain_weight_goalPage)
        val button_lose_weight : TextView = findViewById(R.id.button_lose_weight_goalPage)

        val button_back : TextView = findViewById(R.id.textback_button_goalPage)
        val button_continue : TextView = findViewById(R.id.button_continue_goalPage)

        val phone_goal=intent.extras?.getString("phone_to_goal") ?: "No message found"
        val sex_goal=intent.extras?.getString("sex_to_goal") ?: "No message found"
        val age_goal=intent.extras?.getString("age_to_goal") ?: "No message found"
        val weight_goal=intent.extras?.getString("age_to_goal") ?: "No message found"

        var selecteble = -2 // -2 ничего не выбрано -1 other_bool 0 - shape_bool 1 - mass_bool 2 - gain_bool 3 - lose_bool


        button_continue.setOnClickListener {
            if(selecteble != -2) {
                var intent4 = Intent(this, physical_act_screen::class.java)
                intent4.putExtra("phone_to_act",phone_goal)
                intent4.putExtra("sex_to_act",sex_goal)
                intent4.putExtra("phone_to_act",age_goal)
                intent4.putExtra("weight_to_act",weight_goal)
                intent4.putExtra("goal_to_act",selecteble)
                startActivity(intent4)
            }
        }


        button_back.setOnClickListener {
            var intent = Intent(this, select_weight_screen::class.java)
            startActivity(intent)
        }


        button_other.setOnClickListener {
            if(selecteble != -1){
                selecteble= -1
                button_other.setBackgroundResource(R.drawable.rounded_button_green)

                button_shape_body.setBackgroundResource(R.drawable.rounded_goal_button)
                button_muscle_mass_gain.setBackgroundResource(R.drawable.rounded_goal_button)
                button_gain_weight.setBackgroundResource(R.drawable.rounded_goal_button)
                button_lose_weight.setBackgroundResource(R.drawable.rounded_goal_button)

            }
        }

        button_shape_body.setOnClickListener {
            if(selecteble != 0){
                selecteble = 0
                button_shape_body.setBackgroundResource(R.drawable.rounded_button_green)

                button_other.setBackgroundResource(R.drawable.rounded_goal_button)
                button_muscle_mass_gain.setBackgroundResource(R.drawable.rounded_goal_button)
                button_gain_weight.setBackgroundResource(R.drawable.rounded_goal_button)
                button_lose_weight.setBackgroundResource(R.drawable.rounded_goal_button)
            }
        }

        button_muscle_mass_gain.setOnClickListener {
            if(selecteble != 1){
                selecteble = 1
                button_muscle_mass_gain.setBackgroundResource(R.drawable.rounded_button_green)

                button_other.setBackgroundResource(R.drawable.rounded_goal_button)
                button_shape_body.setBackgroundResource(R.drawable.rounded_goal_button)
                button_gain_weight.setBackgroundResource(R.drawable.rounded_goal_button)
                button_lose_weight.setBackgroundResource(R.drawable.rounded_goal_button)
            }
        }

        button_gain_weight.setOnClickListener {
            if(selecteble != 2){
                selecteble = 2
                button_gain_weight.setBackgroundResource(R.drawable.rounded_button_green)

                button_other.setBackgroundResource(R.drawable.rounded_goal_button)
                button_shape_body.setBackgroundResource(R.drawable.rounded_goal_button)
                button_muscle_mass_gain.setBackgroundResource(R.drawable.rounded_goal_button)
                button_lose_weight.setBackgroundResource(R.drawable.rounded_goal_button)
            }
        }

        button_lose_weight.setOnClickListener {
            if(selecteble != 3){
                button_lose_weight.setBackgroundResource(R.drawable.rounded_button_green)

                button_other.setBackgroundResource(R.drawable.rounded_goal_button)
                button_shape_body.setBackgroundResource(R.drawable.rounded_goal_button)
                button_muscle_mass_gain.setBackgroundResource(R.drawable.rounded_goal_button)
                button_gain_weight.setBackgroundResource(R.drawable.rounded_goal_button)
            }
        }
    }
}