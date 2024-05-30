package com.example.fitness

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import com.example.fitness.floating_menus.home_page_screen

fun navigateToHomePage(context: Context, button: ImageView) {
    button.setOnClickListener {
        val intent = Intent(context, home_page_screen::class.java)
        context.startActivity(intent)
    }
}


fun navigateToResoursePage(context: Context, button: ImageView) {
    button.setOnClickListener {
        //val intent = Intent(context, home_page_screen::class.java)
        //context.startActivity(intent)
    }
}


fun navigateToFavoritePage(context: Context, button: ImageView) {
    button.setOnClickListener {
        //val intent = Intent(context, home_page_screen::class.java)
        //context.startActivity(intent)
    }
}


fun navigateToSupportPage(context: Context, button: ImageView) {
    button.setOnClickListener {
        //val intent = Intent(context, home_page_screen::class.java)
        //context.startActivity(intent)
    }
}


