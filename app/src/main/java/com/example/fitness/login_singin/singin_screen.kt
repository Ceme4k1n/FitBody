package com.example.fitness.login_singin

import android.app.Application
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.on_boarding.start_screen
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.database
import com.google.firebase.database.DatabaseReference
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
class singin_screen : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_singup_screen)
        val name_reg : EditText = findViewById(R.id.email_text_singupPage)
        val email_registry : EditText = findViewById(R.id.phone_text_singupPage)
        val password_registry : EditText = findViewById(R.id.password_text_singinPage)
        val confirm_password_registry : EditText = findViewById(R.id.password_confirm_text_singinPage)
        var button_next_registry : Button = findViewById(R.id.button_sing_in_singinPage)
        val button_back :   ImageView = findViewById(R.id.imagebutton_back_singupPage)

        val database = Firebase.database
        val ref = database.getReference("users")

        button_back.setOnClickListener {
            var intent = Intent(this, login_screen::class.java)
            startActivity(intent)
        }



        fun regViaEmail(
            email_base: String,
            password_base: String
        ){
            auth.createUserWithEmailAndPassword(email_base,password_base)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }

        button_next_registry.setOnClickListener() {
            if (password_registry==confirm_password_registry){
                regViaEmail(email_registry.text.toString(),password_registry.text.toString())
                //button_next_registry.setBackgroundColor(color.BLACK)
                //startActivity() переход сделать
        }else{
            print("parol ne parol")
            }
        }

        }
    }

