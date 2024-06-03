package com.example.fitness.notification

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class search_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_screen)

        val all_group : RelativeLayout = findViewById(R.id.all_group_seacrhPage)
        val workout_group : RelativeLayout = findViewById(R.id.workout_group_searchPage)
        val nut_group : RelativeLayout = findViewById(R.id.nutrition_group_searchPage)

        val all_button : TextView = findViewById(R.id.all_button_seacrhPage)
        val workout_button : TextView = findViewById(R.id.workout_button_seacrhPage)
        val nut_button : TextView = findViewById(R.id.nutrition_button_seacrhPage)

        val squat_stat : ImageView = findViewById(R.id.squat_star_seacthPage)
        val yogurt_star: ImageView = findViewById(R.id.yogurt_star_seacthPage)
        val ful_body_star : ImageView = findViewById(R.id.ful_body_star_seacthPage)
        val circuit_train_star : ImageView = findViewById(R.id.circuit_train_star_seacthPage)
        val split_srt_star : ImageView = findViewById(R.id.split_srt_star_seacthPage)

        var squat_bool = false
        var yogurt_bool = false
        var ful_body_bool = false
        var circuit_train_bool = false
        var split_srt_bool = false


        squat_stat.setOnClickListener {
            if(!squat_bool){
                squat_stat.setImageResource(R.drawable.bookmark_on_button)
                squat_bool = true
            }else{
                squat_stat.setImageResource(R.drawable.bookmark_off_button)
                squat_bool = false
            }
        }

        yogurt_star.setOnClickListener {
            if(!yogurt_bool){
                yogurt_star.setImageResource(R.drawable.bookmark_on_button)
                yogurt_bool = true
            }else{
                yogurt_star.setImageResource(R.drawable.bookmark_off_button)
                yogurt_bool = false
            }
        }

        ful_body_star.setOnClickListener {
            if(!ful_body_bool){
                ful_body_star.setImageResource(R.drawable.bookmark_on_button)
                ful_body_bool = true
            }else{
                ful_body_star.setImageResource(R.drawable.bookmark_off_button)
                ful_body_bool = false
            }
        }

        circuit_train_star.setOnClickListener {
            if(!circuit_train_bool){
                circuit_train_star.setImageResource(R.drawable.bookmark_on_button)
                circuit_train_bool = true
            }else{
                circuit_train_star.setImageResource(R.drawable.bookmark_off_button)
                circuit_train_bool = false
            }
        }

        split_srt_star.setOnClickListener {
            if(!split_srt_bool){
                split_srt_star.setImageResource(R.drawable.bookmark_on_button)
                split_srt_bool = true
            }else{
                split_srt_star.setImageResource(R.drawable.bookmark_off_button)
                split_srt_bool = false
            }
        }





        setGroupProperties(workout_group, View.INVISIBLE, isEnabled = false)
        setGroupProperties(nut_group, View.INVISIBLE, isEnabled = false)


        all_button.setOnClickListener {
            setGroupProperties(all_group, View.VISIBLE, isEnabled = true)
            setGroupProperties(workout_group, View.INVISIBLE, isEnabled = false)
            setGroupProperties(nut_group, View.INVISIBLE, isEnabled = false)
            enabled_or_not(all_button, workout_button, nut_button)
        }

        workout_button.setOnClickListener{
            setGroupProperties(workout_group, View.VISIBLE, isEnabled = true)
            setGroupProperties(all_group, View.INVISIBLE, isEnabled = false)
            setGroupProperties(nut_group, View.INVISIBLE, isEnabled = false)
            enabled_or_not(workout_button, all_button, nut_button)
        }

        nut_button.setOnClickListener {
            setGroupProperties(nut_group, View.VISIBLE, isEnabled = true)
            setGroupProperties(all_group, View.INVISIBLE, isEnabled = false)
            setGroupProperties(workout_group, View.INVISIBLE, isEnabled = false)
            enabled_or_not(nut_button, all_button, workout_button)
        }


    }

    fun enabled_or_not(button_main: TextView, button_not_main: TextView, button_else: TextView) {
        button_main.setBackgroundResource(R.drawable.round_button_phys_act_yellow)
        button_main.setTextColor(Color.BLACK)
        button_not_main.setBackgroundResource(R.drawable.round_button_phys_act)
        button_not_main.setTextColor(getResources().getColor(R.color.purple))
        button_else.setBackgroundResource(R.drawable.round_button_phys_act)
        button_else.setTextColor(getResources().getColor(R.color.purple))
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