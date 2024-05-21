package com.example.fitness.login_singin

import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitness.R
import com.example.fitness.on_boarding.start_screen
import com.example.fitness.setup_pages.set_up_screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class login_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val sing_in_button : Button = findViewById(R.id.button_log_in_loginnpage)
        val forgott_pass_button : TextView = findViewById(R.id.button_forgot_pass_loginpage)
        val email_vhod : EditText =findViewById(R.id.email_text_loginpage)
        val parol_vhod : EditText =findViewById(R.id.password_text_loginpage)


        fun loginViaEmail(
            email: String,
            password: String
        ){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG,"Succecfully singed in")
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
        sing_in_button.setOnClickListener(){
            if(email_vhod.text.isNotEmpty()&& parol_vhod.text.isNotEmpty()) {
                loginViaEmail(email_vhod.text.toString(), parol_vhod.text.toString())
                sing_in_button.setBackgroundColor(Color.parseColor("#7576D6"))
                var intent = Intent(this, set_up_screen::class.java)
            startActivity(intent)
            }else{
            sing_in_button.setBackgroundColor(Color.GRAY)
            }
        }


        sing_in_button.setOnClickListener {
            var intent = Intent(this, singin_screen::class.java)
            startActivity(intent)
        }

        forgott_pass_button.setOnClickListener {
            var intent = Intent(this, forgot_pass_sceeen::class.java)
            startActivity(intent)
        }
    }
}