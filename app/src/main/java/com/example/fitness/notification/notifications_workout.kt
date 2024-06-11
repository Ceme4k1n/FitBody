package com.example.fitness.notification

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
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

class notifications_workout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications_workout)

        val profile_button : ImageView = findViewById(R.id.image_profile_notPage)
        val search_button : ImageView = findViewById(R.id.image_search_notPage)


        val zakladka_button : ImageView = findViewById(R.id.image_zakladkaButton_notPage)
        val favor_button : ImageView = findViewById(R.id.image_buttmarkButton_notPage)
        val supp_button : ImageView = findViewById(R.id.image_operatorButton_notPage)
        val home_button : ImageView = findViewById(R.id.image_homeButton_notPage)

        navigateToProfilePage(this, profile_button)
        navigateToSearchPage(this, search_button)

        navigateToResoursePage(this, zakladka_button)
        navigateToFavoritePage(this, favor_button)
        navigateToSupportPage(this, supp_button)
        navigateToHomePage(this, home_button)



        val systen_group : RelativeLayout = findViewById(R.id.system_group_notPage)
        val rem_group : RelativeLayout = findViewById(R.id.reminders_group_notPage)

        val system_button : TextView = findViewById(R.id.system_button_notPage)
        val rem_button : TextView = findViewById(R.id.rem_button_notPage)

        setGroupProperties(systen_group, visibility = View.INVISIBLE, isEnabled = false)

        system_button.setOnClickListener {
            setGroupProperties(systen_group, View.VISIBLE, isEnabled = true)
            setGroupProperties(rem_group, View.INVISIBLE, isEnabled = false)
            system_button.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
            system_button.setTextColor(getResources().getColor(R.color.real_black))
            rem_button.setBackgroundResource(R.drawable.round_button_phys_act)
            rem_button.setTextColor(getResources().getColor(R.color.purple))
        }

        rem_button.setOnClickListener {
            setGroupProperties(systen_group, View.INVISIBLE, isEnabled = false)
            setGroupProperties(rem_group, View.VISIBLE, isEnabled = true)
            rem_button.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
            rem_button.setTextColor(getResources().getColor(R.color.real_black))
            system_button.setBackgroundResource(R.drawable.round_button_phys_act)
            system_button.setTextColor(getResources().getColor(R.color.purple))
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