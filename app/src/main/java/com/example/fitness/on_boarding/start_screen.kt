package com.example.fitness.on_boarding

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class start_screen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        val welcome_to_fitbody : ImageView = findViewById(R.id.imagewelcome_to_fitbody)
        val woman_on_board_back_one : ImageView = findViewById(R.id.imagewoman_on_board)
        val start_journey : ImageView = findViewById(R.id.imagepurple_start_journey)
        val man_on_board_two : ImageView = findViewById(R.id.imageman_on_board)
        val button_next_man_on_board_one : ImageView = findViewById(R.id.imageButton_next_on_man)
        val skip_button_text : TextView = findViewById(R.id.textskip_man_on_board_man_one)
        val skip_button_svg : ImageView = findViewById(R.id.imageskip_arrow_svg)


        welcome_to_fitbody.visibility = View.VISIBLE
        woman_on_board_back_one.visibility = View.VISIBLE


        skip_button_svg.visibility = View.INVISIBLE
        skip_button_text.visibility = View.INVISIBLE
        start_journey.visibility = View.INVISIBLE
        man_on_board_two.visibility = View.INVISIBLE
        button_next_man_on_board_one.visibility = View.INVISIBLE




        welcome_to_fitbody.setOnClickListener {
            woman_on_board_back_one.visibility = View.INVISIBLE
            welcome_to_fitbody.visibility = View.INVISIBLE

            start_journey.visibility = View.VISIBLE
            man_on_board_two.visibility = View.VISIBLE
            button_next_man_on_board_one.visibility = View.VISIBLE
            skip_button_svg.visibility = View.VISIBLE
            skip_button_text.visibility = View.VISIBLE
        }

        button_next_man_on_board_one.setOnClickListener {
            start_journey.visibility = View.INVISIBLE
            man_on_board_two.visibility = View.INVISIBLE
            button_next_man_on_board_one.visibility = View.INVISIBLE
        }

        skip_button_text.setOnClickListener{
            start_journey.visibility = View.INVISIBLE
            man_on_board_two.visibility = View.INVISIBLE
            button_next_man_on_board_one.visibility = View.INVISIBLE


        }

    }
}