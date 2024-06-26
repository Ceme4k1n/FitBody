package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R

class select_gender_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_gender_screen)
        var male_but_active : ImageButton = findViewById(R.id.imageButton_male_active_genderPage)
        var male_but_inactive : ImageButton = findViewById(R.id.imageButton_male_inactive_genderPage)

        var female_but_active : ImageButton = findViewById(R.id.imageButton_female_active_genderPage)
        var female_but_inactive : ImageButton = findViewById(R.id.imageButton_female_inactive_genderPage)

        var male_or_female = false  //  False - женщина True - мужчина
        var select_anyone = false // Показывает что хоть  одно выбрано
        var mobile_number_gender: String
        val button_back : TextView = findViewById(R.id.textback_button_genderPage)
        val button_continue : TextView = findViewById(R.id.button_continue_genderPage)
        val user_name_gender=intent.extras?.getString("nickname_to_gender") ?: "No message found"
        mobile_number_gender = intent.extras?.getString("mobile_number_to_gender") ?: "No message found"
        var user_email= intent.extras?.getString("email_to_gender") ?: "No message found"
        button_continue.setOnClickListener {
//

            var intent1 = Intent(this, how_old_screen::class.java)
            intent1.putExtra("phone_to_howold",mobile_number_gender)
            intent1.putExtra("sex_to_howold",male_or_female.toString())
            intent1.putExtra("nickname_to_howold",user_name_gender)
            intent1.putExtra("email_to_howold",user_email)
            startActivity(intent1)
            finish()
//            }
        }

        button_back.setOnClickListener {
            var intent = Intent(this, set_up_screen::class.java)
            startActivity(intent)
            finish()
        }



        male_but_inactive.setOnClickListener {
            if(!male_or_female){
                female_but_active.visibility = View.INVISIBLE
                female_but_inactive.visibility = View.VISIBLE
                male_or_female = true
            }
            male_but_inactive.visibility = View.INVISIBLE
            male_but_active.visibility = View.VISIBLE
            select_anyone = true
        }


        female_but_inactive.setOnClickListener {
            if(male_or_female){
                male_but_active.visibility = View.INVISIBLE
                male_but_inactive.visibility = View.VISIBLE
                male_or_female = false
            }
            female_but_inactive.visibility = View.INVISIBLE
            female_but_active.visibility = View.VISIBLE
            select_anyone = true
        }





    }

}