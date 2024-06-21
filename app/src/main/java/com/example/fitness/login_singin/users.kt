package com.example.fitness.login_singin

import android.content.ContentValues.TAG
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

data class Users (
    var name : String="",
    var surname:String="",
    var phone: String="",
    var age: Int=0,
    var sex:Boolean=true,
    var height:Double=0.0,
    var weight:Double=0.0,
    var goal: String="",
    var activity_lvl:String="")
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
    }}
fun addUsertodb(user: Users) {
    val userid = FirebaseAuth.getInstance().currentUser?.uid
    val userref = FirebaseFirestore.getInstance().collection("users").document(userid!!)
    userref.set(
        mapOf(
            "name" to user.name,
            "surname" to user.surname,
            "phone" to user.phone, // Изменено на user.phone
            "age" to user.age,
            "sex" to user.sex,
            "height" to user.height,
            "weight" to user.weight,
            "goal" to user.goal,
            "activity_lvl" to user.activity_lvl
        )
    ).addOnSuccessListener {
        Log.d(TAG, "Данные добавлены")
    }
}



