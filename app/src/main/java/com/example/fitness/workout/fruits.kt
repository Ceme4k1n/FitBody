  package com.example.fitness.workout

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R
import com.example.fitness.navigateToFavoritePage
import com.example.fitness.navigateToHomePage
import com.example.fitness.navigateToNotePage
import com.example.fitness.navigateToProfilePage
import com.example.fitness.navigateToResoursePage
import com.example.fitness.navigateToSearchPage
import com.example.fitness.navigateToSupportPage

  class fruits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        val button_chees : ImageView = findViewById(R.id.bool_cheesecakes_nutrPage)
        val button_caesar : ImageView = findViewById(R.id.bool_caesar_nutrPage)
        val button_boobs : ImageView = findViewById(R.id.bool_boobs_nutrPage)
        val button_protein : ImageView = findViewById(R.id.bool_protein_nutrPage)

        var ches_bool = false
        var caesar_bool = false
        var boobs_bool = false
        var protein_bool = false


        val profile_button : ImageView = findViewById(R.id.image_profile_nutrPage)
        val search_button : ImageView = findViewById(R.id.image_search_nutrPage)
        val not_button : ImageView = findViewById(R.id.image_colokol_nutrPage)

        val home_button : ImageView = findViewById(R.id.image_homeButton_nutrPage)
        val zakladka_button : ImageView = findViewById(R.id.image_zakladkaButton_nutrPage)
        val favor_button : ImageView = findViewById(R.id.image_buttmarkButton_nutrPage)
        val supp_button : ImageView = findViewById(R.id.image_operatorButton_nutrPage)

        navigateToProfilePage(this, profile_button)
        navigateToNotePage(this, not_button)
        navigateToSearchPage(this, search_button)

        navigateToHomePage(this, home_button)
        navigateToResoursePage(this, zakladka_button)
        navigateToFavoritePage(this, favor_button)
        navigateToSupportPage(this, supp_button)



        button_chees.setOnClickListener{
            if(!ches_bool) {
                button_chees.setImageResource(R.drawable.fruits_true)
                ches_bool = true
            }else{
                button_chees.setImageResource(R.drawable.fruits_false)
                ches_bool = false
            }
        }

        button_caesar.setOnClickListener {
            if(!caesar_bool) {
                button_caesar.setImageResource(R.drawable.fruits_true)
                caesar_bool = true
            }else{
                button_caesar.setImageResource(R.drawable.fruits_false)
                caesar_bool = false
            }
        }

        button_boobs.setOnClickListener {
            if(!boobs_bool) {
                button_boobs.setImageResource(R.drawable.fruits_true)
                boobs_bool = true
            }else{
                button_boobs.setImageResource(R.drawable.fruits_false)
                boobs_bool = false
            }
        }

        button_protein.setOnClickListener {
            if(!protein_bool) {
                button_protein.setImageResource(R.drawable.fruits_true)
                protein_bool = true
            }else{
                button_protein.setImageResource(R.drawable.fruits_false)
                protein_bool = false
            }
        }

    }
}