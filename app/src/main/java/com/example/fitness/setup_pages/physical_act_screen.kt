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
        val tobd=Users_dannie()
        var selecteble = -1 // -1 ничего не нажато 0 - begginer 1 - intermediate 2 - advance //TODO ВОТ ЭТО НАДО ВСТАВИТЬ В PutExtra

        val phone_physical_act=intent.extras?.getString("phone_to_act") ?: "No message found"
        val sex_physical_act=intent.extras?.getString("sex_to_act") ?: "No message found"
        val age_physical_act=intent.extras?.getString("age_to_act") ?: "No message found"
        val weight_physical_act=intent.extras?.getString("weight_to_act") ?: "No message found"
        val nickname_physical_act=intent.extras?.getString("nickname_to_act") ?: "No message found"
        val goal_physical_act=intent.extras?.getString("goal_to_act") ?: "No message found"
        val height_goal=intent.extras?.getString("height_to_act") ?: "No message found"
        var physical_act: String=""
        var user_email= intent.extras?.getString("email_to_act") ?: "No message found"
        button_begginer.setOnClickListener {
            if(selecteble != 0){
                button_begginer.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
                button_begginer.setTextColor(Color.BLACK)
                button_intermediate.setBackgroundResource(R.drawable.round_button_phys_act)
                button_intermediate.setTextColor(Color.parseColor("#B3A0FF"))
                button_advance.setBackgroundResource(R.drawable.round_button_phys_act)
                button_advance.setTextColor(Color.parseColor("#B3A0FF"))
                selecteble = 0
                physical_act="begginer"

                println(phone_physical_act)
                println(sex_physical_act)
                println(age_physical_act)
                println(weight_physical_act)
                println(nickname_physical_act)
                println(goal_physical_act)
                println(height_goal)
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
                physical_act="intermediate"
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
                physical_act="advance"
            }
        }

        button_continue.setOnClickListener {
            if(selecteble != -1) {
                var intent5 = Intent(this, set_up_profile_screen::class.java)
                tobd.update_class(
                    newPhone = phone_physical_act,
                    newsex = sex_physical_act,
                    newage = age_physical_act,
                    newName = nickname_physical_act,
                    newgoal = goal_physical_act,
                    newheight = height_goal,
                    newweight = weight_physical_act,
                    newactivity_lvl = physical_act,
                    newemail_adress = user_email
                )
                addUsertodb(tobd)
                startActivity(intent5)
            }
        }

        button_back.setOnClickListener {
            var intent = Intent(this, goal_screen::class.java)
            startActivity(intent)
        }

    }
}