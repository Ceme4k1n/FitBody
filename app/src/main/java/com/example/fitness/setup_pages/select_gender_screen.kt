package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.login_singin.addUsertodb
import com.firebase.ui.auth.data.model.User
import com.example.fitness.login_singin.Users_dannie

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
        var getmassage: String
        val button_back : TextView = findViewById(R.id.textback_button_genderPage)
        val button_continue : TextView = findViewById(R.id.button_continue_genderPage)
        getmassage = intent.extras?.getString("message_to_gender") ?: "No message found"
        println(getmassage)
        button_continue.setOnClickListener {
//            if(select_anyone) {
            Users_dannie().updateSex(
                    newsex = male_or_female
                )
            Users_dannie().updatePhone(
                    newPhone = getmassage
                )
                addUsertodb(Users_dannie())
                var intent = Intent(this, how_old_screen::class.java)
                startActivity(intent)
//            }
        }

        button_back.setOnClickListener {
            var intent = Intent(this, set_up_screen::class.java)
            startActivity(intent)
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