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
import com.example.fitness.navigateToFavoritePage
import com.example.fitness.navigateToHomePage
import com.example.fitness.navigateToNotePage
import com.example.fitness.navigateToProfilePage
import com.example.fitness.navigateToResoursePage
import com.example.fitness.navigateToSearchPage
import com.example.fitness.navigateToSupportPage
import com.example.fitness.setup_pages.set_up_screen

class profile_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)
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


        //Иди нахуй
        //Сообщение Георгию. В date надо вставлять только String
        val email = "georgpidor@gmail.com"// Вставлять сюда, только String

        //Сообщение Георгию. В date надо вставлять только String
        val FI = "Govnoed Popoedov" // Вставлять сюда, только String

        //Сообщение Георгию. В date надо вставлять только день рождения и месяц, по типу "April 1st"
        val date = "govno" // Вставлять сюда, только String

        //Сообщение Георгию. В weight надо вставлять только цифру
        val weight = 50 //Только Int

        //Сообщение Георгию. В height надо вставлять только цифру с 2 после ,
        val height = 1.95 //Только Double

        //Сообщение Георгию. В old надо вставлять только цифру
        val old = 20 //TODO(Только Int)

        updateBirthdayText(birthday_text, date)
        updateWeight(weight_Text, weight)
        updateHeight(heighttext, height)
        updateYearsOld(years_old_text, old)
        updateFI(FI_text, FI)
        updateEmail(email_text, email)

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
        }

        favorite_button.setOnClickListener {
            var intent = Intent(this, favorite_screen::class.java)
            startActivity(intent)
        }

        help_button.setOnClickListener {
            var intent = Intent(this, help_screen::class.java)
            startActivity(intent)
        }

        setting_button.setOnClickListener {
            var intent = Intent(this, setting_screen::class.java)
            startActivity(intent)
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
        }
    }

    private fun updateEmail(textView: TextView, email: String){
        val email_text = "$email"
        textView.text = email_text
    }

    private fun updateFI(textView: TextView, FI: String){
        val FI_text = "$FI"
        textView.text = FI_text
    }

    private fun updateYearsOld(textView: TextView, old: Int){
        val year_text = "$old"
        textView.text = year_text
    }

    private fun updateWeight(textView: TextView, weight: Int){
        val weight_text = "$weight"
        textView.text = weight_text + " Kg"
    }

    private fun updateHeight(textView: TextView, height: Double){
        val height_text = "$height"
        textView.text = height_text + " CM"
    }


    private fun updateBirthdayText(textView: TextView, date: String) {
        val birthdayText = "$date"
        textView.text = birthdayText
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
