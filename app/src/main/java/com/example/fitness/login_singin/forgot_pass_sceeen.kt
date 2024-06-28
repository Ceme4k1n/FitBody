package com.example.fitness.login_singin

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.google.firebase.auth.FirebaseAuth

class forgot_pass_sceeen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass_sceeen)

        val continue_button_setup_pass : Button = findViewById(R.id.button_continue_forgotpassPage)
        val email_vosstanovit : EditText=findViewById(R.id.email_text_forgotpassPage)

        val button_back : ImageView = findViewById(R.id.imagebutton_back_forgotpassPage)

        button_back.setOnClickListener {
            var intent = Intent(this, login_screen::class.java)
            startActivity(intent)
            finish()
        }

        continue_button_setup_pass.setOnClickListener {
            passRecovery(email_vosstanovit.text.toString())
        }

    }
}

fun passRecovery(
    email: String
){
    FirebaseAuth.getInstance().sendPasswordResetEmail(email)
        .addOnSuccessListener {
            Log.d(TAG, "Pass Recovery Link sent")
        }
        .addOnFailureListener{
            Log.d(TAG, "Error sending pass recovery email")
        }
}