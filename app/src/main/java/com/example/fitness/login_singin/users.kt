package com.example.fitness.login_singin

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

data class Users_dannie (
    var name : String="143",
    var surname:String="1545",
    var phone: String="12435",
    var age: Int=4,
    var sex:Boolean=true,
    var height:Double=0.0,
    var weight:Double=0.0,
    var goal: String="414",
    var activity_lvl:String="515")

{
    fun updateName(newName: String) {
        name = newName
    }

    fun updateSurname(newSurname: String) {
        surname = newSurname
    }

    fun updatePhone(newPhone: String) {
        phone = newPhone
    }
    fun updateAge(newage: Int) {
        age = newage
    }
    fun updateSex(newsex: Boolean) {
        sex = newsex
    }
    fun updateHeight(newheight: Double) {
        height = newheight
    }
    fun updateweight(newweight: Double) {
        weight = newweight
    }
    fun updateGoal(newgoal: String) {
        goal = newgoal
    }
    fun updateActivity_lvl(newactivity_lvl: String) {
        activity_lvl = newactivity_lvl
    }
}
fun addUsertodb(user: Users_dannie) {
    val currentUser = FirebaseAuth.getInstance().currentUser
    currentUser?.uid?.let { userId ->
        val userRef = FirebaseFirestore.getInstance().collection("users").document(userId)
        userRef.set(user)
            .addOnSuccessListener {
                Log.d(TAG, "Данные добавлены")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Ошибка при добавлении данных", e)
            }
    } ?: Log.w(TAG, "Пользователь не аутентифицирован")
}




