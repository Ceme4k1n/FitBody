package com.example.fitness

import android.app.Application
import com.google.firebase.FirebaseApp

class login_database : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}