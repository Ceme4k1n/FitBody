package com.example.fitness.login_singin

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.floating_menus.profile_screen
import com.example.fitness.on_boarding.start_screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class login_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val sing_in_button : TextView = findViewById(R.id.button_sing_in_loginpage)
        val forgott_pass_button : TextView = findViewById(R.id.button_forgot_pass_loginpage)
        val log_in_button : TextView = findViewById(R.id.button_log_in_loginnpage)
        val email_to_auth : EditText = findViewById(R.id.email_text_loginpage)
        val password_to_auth : EditText=findViewById(R.id.password_text_loginpage)

        val button_back : ImageView = findViewById(R.id.imagebutton_back_loginpage)



        button_back.setOnClickListener {
            var intent = Intent(this, start_screen::class.java)
            startActivity(intent)
        }

        sing_in_button.setOnClickListener {
            var intent = Intent(this, singin_screen::class.java)
            startActivity(intent)
        }

        forgott_pass_button.setOnClickListener {
            var intent = Intent(this, forgot_pass_sceeen::class.java)
            startActivity(intent)
        }

        fun loginViaEmail(
            email: String,
            password: String
        ){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG,"Succecfully singed in")
                    var intent = Intent(this, profile_screen::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener { exception ->
                    if (exception is FirebaseAuthInvalidUserException) {
                        // Обработка несуществующего пользователя
                        println("Пользователь с таким email не существует")
                        println(email)
                        println(password)
                    } else if (exception is FirebaseAuthInvalidCredentialsException) {

                        // Обработка неверного пароля
                        println(email)
                        println(password)
                        println("Неверный пароль")
                    } else {
                        // Обработка других ошибок
                        println(email)
                        println(password)
                        println("Произошла ошибка: ${exception.message}")
                    }
                }
        }

        log_in_button.setOnClickListener {
            loginViaEmail(email_to_auth.text.toString(),password_to_auth.text.toString())
        }
    }
}