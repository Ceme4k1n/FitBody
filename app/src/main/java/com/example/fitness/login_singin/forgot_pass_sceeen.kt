package com.example.fitness.login_singin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R
import java.util.Properties


class forgot_pass_sceeen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass_sceeen)
        val continue_button_setup_pass : Button = findViewById(R.id.button_continue_forgotpassPage)
        val emai_forgotten : EditText=findViewById(R.id.email_text_forgotpassPage)









        continue_button_setup_pass.setOnClickListener {
            var intent = Intent(this, set_up_pass_screen::class.java)
            startActivity(intent)
        }

    }

}