package com.example.fitness

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import com.example.fitness.floating_menus.favorite_screen
import com.example.fitness.floating_menus.help_screen
import com.example.fitness.floating_menus.home_page_screen
import com.example.fitness.floating_menus.profile_screen
import com.example.fitness.notification.notifications_workout
import com.example.fitness.notification.search_screen
import com.example.fitness.tips_screens.resources_screen


fun navigateToHomePage(context: Context, button: ImageView) {
    button.setOnClickListener {
        val intent = Intent(context, home_page_screen::class.java)
        context.startActivity(intent)
    }
}


fun navigateToResoursePage(context: Context, button: ImageView) {
    button.setOnClickListener {
        val intent = Intent(context, resources_screen::class.java)
        context.startActivity(intent)
    }
}


fun navigateToFavoritePage(context: Context, button: ImageView) {
    button.setOnClickListener {
        val intent = Intent(context, favorite_screen::class.java)
        context.startActivity(intent)
    }
}


fun navigateToSupportPage(context: Context, button: ImageView) {
    button.setOnClickListener {
        val intent = Intent(context, help_screen::class.java)
        context.startActivity(intent)
    }
}

fun navigateToProfilePage(context: Context, button: ImageView) {
    button.setOnClickListener {
        val intent = Intent(context, profile_screen::class.java)
        context.startActivity(intent)
    }
}

fun navigateToNotePage(context: Context, button: ImageView) {
    button.setOnClickListener {
        val intent = Intent(context, notifications_workout::class.java)
        context.startActivity(intent)
    }
}

fun navigateToSearchPage(context: Context, button: ImageView) {
    button.setOnClickListener {
        val intent = Intent(context, search_screen::class.java)
        context.startActivity(intent)
    }
}

fun <T> navigateOnClick(view: View, context: Context, destinationActivity: Class<T>) {
    view.setOnClickListener {
        val intent = Intent(context, destinationActivity)
        context.startActivity(intent)
    }
}
