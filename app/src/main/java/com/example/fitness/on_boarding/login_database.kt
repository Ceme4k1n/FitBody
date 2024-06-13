package com.example.fitness

import android.app.Application
import android.content.ContentValues
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class login_database : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        fun regViaEmail(
            email_base: String,
            password_base: String
        ){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email_base,password_base,)
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "Successfully registered a user")
                }

        }

    }


}