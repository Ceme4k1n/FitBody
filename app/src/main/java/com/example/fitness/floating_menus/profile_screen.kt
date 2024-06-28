package com.example.fitness.floating_menus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.login_singin.getUserFromDb
import com.example.fitness.navigateToFavoritePage
import com.example.fitness.navigateToHomePage
import com.example.fitness.navigateToResoursePage
import com.example.fitness.navigateToSupportPage
import com.example.fitness.setup_pages.set_up_screen

class profile_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        //функция для получения данных из бд
        getUserFromDb { frombd ->

            println("GOOOOOOOOOOOOOOOOOOL1 " + frombd.height)
            println("GOOOOOOOOOOOOOOOOOOL2" + frombd.age)


            val birthday_text : TextView = findViewById(R.id.birrthday_text_profilePage)
            val weight_Text : TextView = findViewById(R.id.weight_text_profilePage)
            val years_old_text : TextView = findViewById(R.id.years_old_text_profilePage)
            val heighttext : TextView = findViewById(R.id.height_text_profilePage)
            val FI_text : TextView = findViewById(R.id.text_FI_profilePage)
            val email_text : TextView = findViewById(R.id.email_profilePage)

            //Кнопки навигации
            val home_button : ImageView = findViewById(R.id.image_homeButton_profilePage)
            val resourse_button : ImageView = findViewById(R.id.image_zakladkaButton_profilePage)
            val zvezda_button : ImageView = findViewById(R.id.image_buttmarkButton_profilePage)
            val suppor_button : ImageView = findViewById(R.id.image_operatorButton_profilePage)

            //Кнопки выхода
            val back_button : ImageView = findViewById(R.id.strelka_profilePage)

            val profile_button : ImageView = findViewById(R.id.strela1_profilePage)
            val favorite_button : ImageView = findViewById(R.id.strela2_profilePage)
            val setting_button : ImageView = findViewById(R.id.strela4_profilePage)
            val help_button : ImageView = findViewById(R.id.strela5_profilePage)
            val logout_button : ImageView = findViewById(R.id.strela6_profilePage)


            val logout_box : View = findViewById(R.id.logout_purple_box_profilePage)
            val logout_text : TextView = findViewById(R.id.text_log_out_profilePage)
            val logout_cansel_button : TextView = findViewById(R.id.button_cancel_logout_profilePage)
            val logout_confirm_button : TextView = findViewById(R.id.button_yes_logout_profilePage)


            //Группа кнопок
            val buttons_group : RelativeLayout = findViewById(R.id.profile_group_buttons)
            val scroll_group : ScrollView = findViewById(R.id.scroll_group_profilePage)

            val age = frombd.age.toInt()

            FI_text.text = frombd.name
            heighttext.text = frombd.height
            weight_Text.text = frombd.weight
            years_old_text.text = frombd.age.toInt().toString()
            birthday_text.text = (2024-age).toString()
            email_text.text = frombd.email_adress



            //updateEmail(email_text, frombd.phone) // предположим, что в поле phone у вас хранится email

            navigateToHomePage(this, home_button)
            navigateToResoursePage(this, resourse_button)
            navigateToFavoritePage(this, zvezda_button)
            navigateToSupportPage(this, suppor_button)

            profile_button.setOnClickListener {
                setGroupProperties(buttons_group, visibility = View.INVISIBLE, isEnabled = false)
                setGroupProperties(scroll_group, visibility = View.VISIBLE, isEnabled = true)
                scroll_group.visibility = View.VISIBLE
            }

            back_button.setOnClickListener {
                var intent = Intent(this, home_page_screen::class.java)
                startActivity(intent)
                finish()
            }

            favorite_button.setOnClickListener {
                var intent = Intent(this, favorite_screen::class.java)
                startActivity(intent)
                finish()
            }

            help_button.setOnClickListener {
                var intent = Intent(this, help_screen::class.java)
                startActivity(intent)
                finish()
            }

            setting_button.setOnClickListener {
                var intent = Intent(this, setting_screen::class.java)
                startActivity(intent)
                finish()
            }

            logout_button.setOnClickListener {
                logout_box.visibility = View.VISIBLE
                logout_text.visibility = View.VISIBLE
                logout_cansel_button.visibility = View.VISIBLE
                logout_confirm_button.visibility = View.VISIBLE
            }

            logout_cansel_button.setOnClickListener {
                logout_box.visibility = View.INVISIBLE
                logout_text.visibility = View.INVISIBLE
                logout_cansel_button.visibility = View.INVISIBLE
                logout_confirm_button.visibility = View.INVISIBLE
            }

            logout_confirm_button.setOnClickListener {
                var intent = Intent(this, set_up_screen::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun setGroupProperties(
        group: ViewGroup,
        visibility: Int? = null,
        isEnabled: Boolean? = null
    ) {
        for (i in 0 until group.childCount) {
            val child = group.getChildAt(i)
            visibility?.let {
                child.visibility = it
            }
            isEnabled?.let {
                child.isEnabled = it
            }
            if (child is RelativeLayout) {
                setGroupProperties(child, visibility, isEnabled)
            }
        }
    }
}
