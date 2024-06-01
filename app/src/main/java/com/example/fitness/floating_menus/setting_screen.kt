package com.example.fitness.floating_menus

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class setting_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_screen)

        val default_settings_group : RelativeLayout = findViewById(R.id.default_settings_group)
        val not_settings_group : RelativeLayout = findViewById(R.id.not_setting_group_settingPage)
        val pass_setting_group : RelativeLayout = findViewById(R.id.password_settings_group)

        setGroupProperties(default_settings_group, visibility = View.INVISIBLE, isEnabled = false)
        setGroupProperties(not_settings_group, visibility = View.INVISIBLE, isEnabled = false)
        setGroupProperties(pass_setting_group, visibility = View.VISIBLE, isEnabled = true)

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