package com.example.fitness.floating_menus

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.community_menus.comm_screen
import com.example.fitness.navigateToFavoritePage
import com.example.fitness.navigateToNotePage
import com.example.fitness.navigateToProfilePage
import com.example.fitness.navigateToResoursePage
import com.example.fitness.navigateToSearchPage
import com.example.fitness.navigateToSupportPage
import com.example.fitness.workout.first_train_screen
import com.example.fitness.workout.fruits

class home_page_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_screen)

        var bool_squart = false
        var bool_fullBody = false
        var bool_supplement = false
        var bool_daily = false

        val image_squart_train : ImageView = findViewById(R.id.image_squart_homePage)


        val squartFavorite_Button : ImageView = findViewById(R.id.image_squatFavorite_homePage)
        val fullBodyFavorite_Button : ImageView = findViewById(R.id.image_fullBodyFavorite_homePage)
        val supplementFavorite_Button : ImageView = findViewById(R.id.image_favoriteButton_supplement_homePage)
        val dailyFavorite_Button : ImageView = findViewById(R.id.image_favoriteButton_daily_rountines_homePage)

        val profile_button : ImageView = findViewById(R.id.image_profile_homePage)
        val search_button : ImageView = findViewById(R.id.image_colokol_homePage)
        val not_button : ImageView = findViewById(R.id.image_search_homePage)

        val zakladka_button : ImageView = findViewById(R.id.image_zakladkaButton_homePage)
        val favor_button : ImageView = findViewById(R.id.image_buttmarkButton_homePage)
        val supp_button : ImageView = findViewById(R.id.image_operatorButton_homePage)

        val nutr_button : ImageView = findViewById(R.id.image_nutrition_homePage)
        val progress : ImageView = findViewById(R.id.image_progress_tracking_homePage)

        progress.setOnClickListener {
            var intent = Intent(this, comm_screen::class.java)
            startActivity(intent)
            finish()
        }

        image_squart_train.setOnClickListener {
            var intent = Intent(this, first_train_screen::class.java)
            startActivity(intent)
            finish()
        }

        nutr_button.setOnClickListener {
            var intent = Intent(this, fruits::class.java)
            startActivity(intent)
            finish()
        }


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


        navigateToProfilePage(this, profile_button)
        navigateToNotePage(this, not_button)
        navigateToSearchPage(this, search_button)

        navigateToResoursePage(this, zakladka_button)
        navigateToFavoritePage(this, favor_button)
        navigateToSupportPage(this, supp_button)
    }
}