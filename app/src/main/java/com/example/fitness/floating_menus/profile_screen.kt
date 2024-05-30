package com.example.fitness.floating_menus

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R
import com.example.fitness.navigateToHomePage

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
        val old = 20 //Только Int

        updateBirthdayText(birthday_text, date)
        updateWeight(weight_Text, weight)
        updateHeight(heighttext, height)
        updateYearsOld(years_old_text, old)
        updateFI(FI_text, FI)
        updateEmail(email_text, email)

        navigateToHomePage(this, home_button)

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



}