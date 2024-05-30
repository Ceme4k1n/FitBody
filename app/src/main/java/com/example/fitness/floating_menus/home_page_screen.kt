package com.example.fitness.floating_menus

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R
import com.example.fitness.navigateToHomePage

class home_page_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_screen)

        var bool_squart = false
        var bool_fullBody = false
        var bool_supplement = false
        var bool_daily = false


        val squartFavorite_Button : ImageView = findViewById(R.id.image_squatFavorite_homePage)
        val fullBodyFavorite_Button : ImageView = findViewById(R.id.image_fullBodyFavorite_homePage)
        val supplementFavorite_Button : ImageView = findViewById(R.id.image_favoriteButton_supplement_homePage)
        val dailyFavorite_Button : ImageView = findViewById(R.id.image_favoriteButton_daily_rountines_homePage)

        squartFavorite_Button.setOnClickListener {
            if(bool_squart == false)
            {
                squartFavorite_Button.setImageResource(R.drawable.bookmark_on_button)
                bool_squart = true
            }else{
                squartFavorite_Button.setImageResource(R.drawable.bookmark_off_button)
                bool_squart = false
            }
        }

        fullBodyFavorite_Button.setOnClickListener {
            if(bool_fullBody == false) {
                fullBodyFavorite_Button.setImageResource(R.drawable.bookmark_on_button)
                bool_fullBody = true
            }else{
                fullBodyFavorite_Button.setImageResource(R.drawable.bookmark_off_button)
                bool_fullBody = false
            }
        }

        supplementFavorite_Button.setOnClickListener {
            if(bool_supplement == false) {
                supplementFavorite_Button.setImageResource(R.drawable.bookmark_on_button)
                bool_supplement = true
            }else
            {
                supplementFavorite_Button.setImageResource(R.drawable.bookmark_off_button)
                bool_supplement = false
            }
        }

        dailyFavorite_Button.setOnClickListener {
            if(bool_daily == false) {
                dailyFavorite_Button.setImageResource(R.drawable.bookmark_on_button)
                bool_daily = true
            }else
            {
                dailyFavorite_Button.setImageResource(R.drawable.bookmark_off_button)
                bool_daily = false
            }
        }

    }
}