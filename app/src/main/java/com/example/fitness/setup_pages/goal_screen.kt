package com.example.fitness.setup_pages

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class goal_screen : AppCompatActivity() {

    private var currentBackgroundResource: Int = R.drawable.rounded_goal_button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal_screen)

        val button_other : Button = findViewById(R.id.button_other_goalPage)
        val button_shape_body : Button = findViewById(R.id.button_shape_body_goalPage)
        val button_muscle_mass_gain : Button = findViewById(R.id.button_muscle_mass_gain_goalPage)
        val button_gain_weight : Button = findViewById(R.id.button_gain_weight_goalPage)
        val button_lose_weight : Button = findViewById(R.id.button_lose_weight_goalPage)

        val button_back : TextView = findViewById(R.id.textback_button_goalPage)
        val button_continue : Button = findViewById(R.id.button_continue_goalPage)


        var other_bool = false
        var shape_bool = false
        var mass_bool = false
        var gain_bool = false
        var lose_bool = false


        button_continue.setOnClickListener {
            if(other_bool || shape_bool || mass_bool || gain_bool || lose_bool) {
                var intent = Intent(this, physical_act_screen::class.java)
                startActivity(intent)
            }
        }


        button_back.setOnClickListener {
            //var intent = Intent(this, goal_screen::class.java)
            //startActivity(intent)
        }


        button_other.setOnClickListener {
            if(other_bool == false){
                button_other.setBackgroundResource(R.drawable.rounded_button_green)
                other_bool = true
            }else{
                button_other.setBackgroundResource(R.drawable.rounded_goal_button)
                other_bool = false
            }
        }

        button_shape_body.setOnClickListener {
            if(shape_bool == false){
                button_shape_body.setBackgroundResource(R.drawable.rounded_button_green)
                shape_bool = true
            }else{
                button_shape_body.setBackgroundResource(R.drawable.rounded_goal_button)
                shape_bool = false
            }
        }

        button_muscle_mass_gain.setOnClickListener {
            if(mass_bool == false){
                button_muscle_mass_gain.setBackgroundResource(R.drawable.rounded_button_green)
                mass_bool = true
            }else{
                button_muscle_mass_gain.setBackgroundResource(R.drawable.rounded_goal_button)
                mass_bool = false
            }
        }

        button_gain_weight.setOnClickListener {
            if(gain_bool == false){
                button_gain_weight.setBackgroundResource(R.drawable.rounded_button_green)
                gain_bool = true
            }else{
                button_gain_weight.setBackgroundResource(R.drawable.rounded_goal_button)
                gain_bool = false
            }
        }

        button_lose_weight.setOnClickListener {
            if(lose_bool == false){
                button_lose_weight.setBackgroundResource(R.drawable.rounded_button_green)
                lose_bool = true
            }else{
                button_lose_weight.setBackgroundResource(R.drawable.rounded_goal_button)
                lose_bool = false
            }
        }
    }
}