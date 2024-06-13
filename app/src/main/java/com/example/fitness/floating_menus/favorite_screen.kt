package com.example.fitness.floating_menus

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.navigateToFavoritePage
import com.example.fitness.navigateToHomePage
import com.example.fitness.navigateToNotePage
import com.example.fitness.navigateToProfilePage
import com.example.fitness.navigateToResoursePage
import com.example.fitness.navigateToSearchPage
import com.example.fitness.navigateToSupportPage

class favorite_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_screen)

        val profile_button : ImageView = findViewById(R.id.image_profile_favoritePage)
        val search_button : ImageView = findViewById(R.id.image_search_favoritePage)
        val not_button : ImageView = findViewById(R.id.image_colokol_favoritePage)

        val zakladka_button : ImageView = findViewById(R.id.image_zakladkaButton_favoritePage)
        val home_button : ImageView = findViewById(R.id.image_homeButton_favoritePage)
        val supp_button : ImageView = findViewById(R.id.image_operatorButton_favoritePage)




        navigateToProfilePage(this, profile_button)
        navigateToNotePage(this, not_button)
        navigateToSearchPage(this, search_button)

        navigateToResoursePage(this, zakladka_button)
        navigateToHomePage(this, home_button)
        navigateToSupportPage(this, supp_button)

    }
}