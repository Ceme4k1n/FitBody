package com.example.fitness.login_singin

import android.app.Application
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database
import com.google.firebase.firestore.auth.User

class singin_screen : AppCompatActivity() {
    fun regViaEmail(
        email_base: String,
        password_base: String
    ){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email_base,password_base,)
            .addOnSuccessListener {
                Log.d(ContentValues.TAG, "Successfully registered a user")
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_singup_screen)
        val email_registry : EditText = findViewById(R.id.email_text_singupPage)
        val mobile_number_registry : EditText = findViewById(R.id.phone_text_singupPage)
        val password_registry : EditText = findViewById(R.id.password_text_singinPage)
        val confirm_password_registry : EditText = findViewById(R.id.password_confirm_text_singinPage)
        val button_next_registry : Button = findViewById(R.id.button_sing_in_singinPage)
        val database = Firebase.database
        val ref = database.getReference("users")


        button_next_registry.setOnClickListener() {
            if (password_registry==confirm_password_registry){
                regViaEmail(email_registry.text.toString(),password_registry.text.toString())
                //startActivity() переход сделать
        }else{
            print("parol ne parol")
            }
        }

        }
    }


