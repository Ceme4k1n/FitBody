package com.example.fitness.setup_pages

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R
import com.example.fitness.floating_menus.home_page_screen

class select_height : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_height)

        val button_back : TextView = findViewById(R.id.textback_button_selectHeight)
        val button_cont : TextView = findViewById(R.id.button_continue_selectHeight)
        val select_height : EditText = findViewById(R.id.number_confirm_text_selectHeight)

        var height: Int

        button_cont.setOnClickListener{
            var intent = Intent(this, goal_screen::class.java)
            startActivity(intent)
        }

        button_back.setOnClickListener{
            var intent = Intent(this, select_weight_screen::class.java)
            startActivity(intent)
        }
    }
}