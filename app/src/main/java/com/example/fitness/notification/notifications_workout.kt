package com.example.fitness.notification

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class notifications_workout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications_workout)

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