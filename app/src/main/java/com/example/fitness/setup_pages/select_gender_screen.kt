package com.example.fitness.setup_pages

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R

class select_gender_screen : AppCompatActivity() {

    private lateinit var buttonMale: ImageButton
    private lateinit var buttonFemale: ImageButton

    var isSelectMale = false
    var isSelectFemale = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_gender_screen)
        buttonMale = findViewById(R.id.imageButton_male_gender_genderPage)
        buttonFemale = findViewById(R.id.imageButton_female_gender_genderPage)


        buttonMale.setOnClickListener {
                buttonMale.isPressed = true
                buttonFemale.isPressed = false
        }

    }

}