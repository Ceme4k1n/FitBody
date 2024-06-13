package com.example.fitness.floating_menus

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.navigateToFavoritePage
import com.example.fitness.navigateToHomePage
import com.example.fitness.navigateToNotePage
import com.example.fitness.navigateToProfilePage
import com.example.fitness.navigateToResoursePage
import com.example.fitness.navigateToSearchPage
import com.example.fitness.navigateToSupportPage

class setting_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_screen)

        val zakladka_button : ImageView = findViewById(R.id.image_zakladkaButton_settingPage)
        val home_button : ImageView = findViewById(R.id.image_homeButton_settingPage)
        val supp_button : ImageView = findViewById(R.id.image_operatorButton_settingPage)
        val fav_button : ImageView = findViewById(R.id.image_buttmarkButton_settingPage)


        val default_settings_group : RelativeLayout = findViewById(R.id.default_settings_group)
        val not_settings_group : RelativeLayout = findViewById(R.id.not_setting_group_settingPage)
        val pass_setting_group : RelativeLayout = findViewById(R.id.password_settings_group)

        val not_button : ImageView = findViewById(R.id.strela1_settingPage)
        val pass_button : ImageView = findViewById(R.id.strela2_settingPage)
        val delete_acc_button : ImageView = findViewById(R.id.strela3_settingPage)

        val not_button_back : ImageView = findViewById(R.id.strelka_notification_settingsPage)
        val pass_button_back : ImageView = findViewById(R.id.strelka_pass_settingsPage)


        setGroupProperties(default_settings_group, View.VISIBLE, isEnabled = true)
        setGroupProperties(not_settings_group, View.INVISIBLE, isEnabled = false)
        setGroupProperties(pass_setting_group, View.INVISIBLE, isEnabled = false)

        not_button.setOnClickListener {
            setGroupProperties(not_settings_group, View.VISIBLE, isEnabled = true)
            setGroupProperties(default_settings_group, View.INVISIBLE, isEnabled = false)
            setGroupProperties(pass_setting_group, View.INVISIBLE, isEnabled = false)
        }

        pass_button.setOnClickListener {
            setGroupProperties(pass_setting_group, View.VISIBLE, isEnabled = true)
            setGroupProperties(not_settings_group, View.INVISIBLE, isEnabled = false)
            setGroupProperties(default_settings_group, View.INVISIBLE, isEnabled = false)
        }

        not_button_back.setOnClickListener {
            setGroupProperties(default_settings_group, View.VISIBLE, isEnabled = true)
            setGroupProperties(not_settings_group, View.INVISIBLE, isEnabled = false)
            setGroupProperties(pass_setting_group, View.INVISIBLE, isEnabled = false)
        }

        pass_button_back.setOnClickListener {
            setGroupProperties(default_settings_group, View.VISIBLE, isEnabled = true)
            setGroupProperties(not_settings_group, View.INVISIBLE, isEnabled = false)
            setGroupProperties(pass_setting_group, View.INVISIBLE, isEnabled = false)
        }



        navigateToResoursePage(this, zakladka_button)
        navigateToHomePage(this, home_button)
        navigateToSupportPage(this, supp_button)
        navigateToFavoritePage(this, fav_button)



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