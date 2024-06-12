package com.example.fitness.floating_menus

import android.graphics.Color
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
import com.example.fitness.navigateToResoursePage
import com.example.fitness.navigateToSupportPage

class help_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_screen)

        val zakladka_button : ImageView = findViewById(R.id.image_zakladkaButton_helpPage)
        val favor_button : ImageView = findViewById(R.id.image_buttmarkButton_helpPage)
        val supp_button : ImageView = findViewById(R.id.image_operatorButton_helpPage)
        val home_button : ImageView = findViewById(R.id.image_homeButton_helpPage)

        navigateToResoursePage(this, zakladka_button)
        navigateToFavoritePage(this, favor_button)
        navigateToSupportPage(this, supp_button)
        navigateToHomePage(this, home_button)


        val faq_button : TextView = findViewById(R.id.button_faq_help_and_faqs)
        val contact_us_button : TextView = findViewById(R.id.button_contact_us_helpPage)

        val faq_group : RelativeLayout = findViewById(R.id.buttons_group_helpPage)
        val contact_us_group : RelativeLayout = findViewById(R.id.contact_us_group_helpPage)

        setGroupProperties(contact_us_group, View.INVISIBLE, isEnabled = true)


        contact_us_button.setOnClickListener{
            setGroupProperties(faq_group, visibility = View.INVISIBLE, isEnabled = false)
            setGroupProperties(contact_us_group, View.VISIBLE, isEnabled = true)
            contact_us_button.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
            contact_us_button.setTextColor(Color.BLACK)
            faq_button.setBackgroundResource(R.drawable.round_button_phys_act)
            faq_button.setTextColor(getResources().getColor(R.color.purple))
        }

        faq_button.setOnClickListener {
            setGroupProperties(faq_group, visibility = View.VISIBLE, isEnabled = true)
            setGroupProperties(contact_us_group, View.INVISIBLE, isEnabled = false)
            contact_us_button.setBackgroundResource(R.drawable.round_button_phys_act)
            contact_us_button.setTextColor(getResources().getColor(R.color.purple))
            faq_button.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
            faq_button.setTextColor(Color.BLACK)
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