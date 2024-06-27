package com.example.fitness.setup_pages

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.login_singin.Users_dannie
import com.example.fitness.login_singin.addUsertodb

class physical_act_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physical_act_screen)

        val button_begginer : TextView = findViewById(R.id.button_begginer_physAct)
        val button_intermediate : TextView = findViewById(R.id.button_Intermediate_physAct)
        val button_advance : TextView = findViewById(R.id.button_Advance_physAct)
        val button_continue : TextView = findViewById(R.id.button_continue_physAct)
        val button_back : TextView = findViewById(R.id.textback_button_physAcrt)
        val tobd = Users_dannie()

        var selecteble = -1 // -1 ничего не нажато 0 - begginer 1 - intermediate 2 - advance //TODO ВОТ ЭТО НАДО ВСТАВИТЬ В PutExtra
        var activity_lvl: String =""

        val phone_physical_act=intent.extras?.getString("phone_to_act") ?: "No message found"
        val sex_physical_act=intent.extras?.getString("sex_to_act") ?: "No message found"
        val age_physical_act=intent.extras?.getString("age_to_act") ?: "No message found"
        val weight_physical_act=intent.extras?.getString("age_to_act") ?: "No message found"
        val goal_physical_act=intent.extras?.getString("goal_to_act") ?: "No message found"
        val fullname_physical_act=intent.extras?.getString("fullname_to_act") ?: "No message found"

        button_begginer.setOnClickListener {
            if(selecteble != 0){
                button_begginer.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
                button_begginer.setTextColor(Color.BLACK)
                button_intermediate.setBackgroundResource(R.drawable.round_button_phys_act)
                button_intermediate.setTextColor(Color.parseColor("#B3A0FF"))
                button_advance.setBackgroundResource(R.drawable.round_button_phys_act)
                button_advance.setTextColor(Color.parseColor("#B3A0FF"))
                selecteble = 0
                activity_lvl="Начинающий"
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
                activity_lvl="Сильный"
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
                activity_lvl="Средний"
            }
        }

        button_continue.setOnClickListener {
            if(selecteble != -1) {
                var intent5 = Intent(this, set_up_profile_screen::class.java)
                startActivity(intent5)
            }
            tobd.updatePhone(
                newPhone = phone_physical_act
            )
            tobd.updateSex(
                newsex = sex_physical_act.toBoolean()
            )
            tobd.updateAge(
                newage = age_physical_act.toInt()
            )
            tobd.updateweight(
                newweight = weight_physical_act.toDouble()
            )
            tobd.updateGoal(
                newgoal =  goal_physical_act
            )
            tobd.updateActivity_lvl(
                newactivity_lvl = activity_lvl
            )
            tobd.updateName(
                newName = fullname_physical_act
            )
            addUsertodb(tobd)
        }

        button_back.setOnClickListener {
            var intent = Intent(this, goal_screen::class.java)
            startActivity(intent)
        }

    }
}