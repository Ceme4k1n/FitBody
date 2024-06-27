package com.example.fitness.login_singin

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitness.R
import com.example.fitness.setup_pages.set_up_screen
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.database

class singin_screen : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_singup_screen)
        val user_name : EditText = findViewById(R.id.email_text_singupPage)
        val email_adress : EditText = findViewById(R.id.phone_text_singupPage)
        val password_registry : EditText = findViewById(R.id.password_text_singinPage)
        val phone_number : EditText = findViewById(R.id.number_confirm_text_singinPage)
        var button_next_registry : Button = findViewById(R.id.button_sing_in_singinPage)
        val button_back :   ImageView = findViewById(R.id.imagebutton_back_singupPage)

        val database = Firebase.database
        val ref = database.getReference("users")

        button_back.setOnClickListener {
            var intent = Intent(this, login_screen::class.java)
            startActivity(intent)
        }



        fun regViaEmail(
            email_adress: String,
            password_base: String
        ){
            auth.createUserWithEmailAndPassword(email_adress,password_base)
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
//            if (password_registry.text.toString()==confirm_password_registry.text.toString()){
                regViaEmail(email_adress.text.toString(),password_registry.text.toString())
                var intent1 = Intent(this, set_up_screen::class.java)
            intent1.putExtra("mobile_number_to_setup",phone_number.text.toString())
            intent1.putExtra("email_to_setup",email_adress.text.toString())
            intent1.putExtra("nickname_to_setup",user_name.text.toString())
                startActivity(intent1)
//        }else{
//            print("parol ne parol")
//            }
        }

        }
    }


