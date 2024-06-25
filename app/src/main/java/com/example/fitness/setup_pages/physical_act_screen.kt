package com.example.fitness.setup_pages

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R

class physical_act_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physical_act_screen)

        val button_begginer : TextView = findViewById(R.id.button_begginer_physAct)
        val button_intermediate : TextView = findViewById(R.id.button_Intermediate_physAct)
        val button_advance : TextView = findViewById(R.id.button_Advance_physAct)
        val button_continue : TextView = findViewById(R.id.button_continue_physAct)
        val button_back : TextView = findViewById(R.id.textback_button_physAcrt)

        var selecteble = -1 // -1 ничего не нажато 0 - begginer 1 - intermediate 2 - advance //TODO ВОТ ЭТО НАДО ВСТАВИТЬ В PutExtra

        val phone_physical_act=intent.extras?.getString("phone_to_act") ?: "No message found"
        val sex_physical_act=intent.extras?.getString("sex_to_act") ?: "No message found"
        val age_physical_act=intent.extras?.getString("age_to_act") ?: "No message found"
        val weight_physical_act=intent.extras?.getString("age_to_act") ?: "No message found"

        button_begginer.setOnClickListener {
            if(selecteble != 0){
                button_begginer.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
                button_begginer.setTextColor(Color.BLACK)
                button_intermediate.setBackgroundResource(R.drawable.round_button_phys_act)
                button_intermediate.setTextColor(Color.parseColor("#B3A0FF"))
                button_advance.setBackgroundResource(R.drawable.round_button_phys_act)
                button_advance.setTextColor(Color.parseColor("#B3A0FF"))
                selecteble = 0
            }
        }

        button_intermediate.setOnClickListener {
            if(selecteble != 1){
                button_intermediate.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
                button_intermediate.setTextColor(Color.BLACK)
                button_begginer.setBackgroundResource(R.drawable.round_button_phys_act)
                button_begginer.setTextColor(Color.parseColor("#B3A0FF"))
                button_advance.setBackgroundResource(R.drawable.round_button_phys_act)
                button_advance.setTextColor(Color.parseColor("#B3A0FF"))
                selecteble = 1
            }
        }

        button_advance.setOnClickListener {
            if(selecteble != 2){
                button_advance.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
                button_advance.setTextColor(Color.BLACK)
                button_begginer.setBackgroundResource(R.drawable.round_button_phys_act)
                button_begginer.setTextColor(Color.parseColor("#B3A0FF"))
                button_intermediate.setBackgroundResource(R.drawable.round_button_phys_act)
                button_intermediate.setTextColor(Color.parseColor("#B3A0FF"))
                selecteble = 2
            }
        }

        button_continue.setOnClickListener {
            if(selecteble != -1) {
                var intent5 = Intent(this, set_up_profile_screen::class.java)
                intent5.putExtra("phone_to_profile",phone_physical_act)
                intent5.putExtra("sex_to_profile",sex_physical_act)
                intent5.putExtra("phone_to_profile",age_physical_act)
                intent5.putExtra("weight_to_profile",weight_physical_act)
                intent5.putExtra("goal_to_profile",selecteble)
                startActivity(intent5)
            }
        }

        button_back.setOnClickListener {
            var intent = Intent(this, goal_screen::class.java)
            startActivity(intent)
        }

    }
}