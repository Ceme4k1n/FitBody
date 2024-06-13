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
    fun updateUser_one(
        newName: String,
        newsurname:String,
        newphone: String,
        newage: Int,
        newsex:Boolean,
        newheight:Double,
        newweight:Double,
        newgoal: String,
        newactivity_lvl:String

    )   {
        name = newName
        surname=newsurname
        phone=newphone
        age=newage
        sex=newsex
        height=newheight
        weight=newweight
        goal=newgoal
        sex=newsex
        activity_lvl=newactivity_lvl
    }

}


class UserViewModel : ViewModel() {
    private val _user = MutableLiveData<Users>()
    val currentUser by lazy {
        _user.value ?: Users(
            name = "yep",
            surname = "",
            phone = "",
            age = 0,
            sex = true,
            height = 0.0,
            weight = 0.0,
            goal = "",
            activity_lvl = ""
        )
    }
    fun updateName(newName: String) {
        currentUser.name = newName
    }

    fun updateSurname(newSurname: String) {
        currentUser.surname = newSurname
    }

    fun updatePhone(newPhone: String) {
        currentUser.phone = newPhone
    }
    fun updateAge(newage: Int) {
        currentUser.age = newage
    }

    fun updateSex(newsex: Boolean) {
        currentUser.sex = newsex
    }
    fun updateHeight(newheight: Double) {
        currentUser.height = newheight
    }
    fun updateweight(newweight: Double) {
        currentUser.weight = newweight
    }
    fun updateGoal(newgoal: String) {
        currentUser.goal = newgoal
    }
    fun updateActivity_lvl(newactivity_lvl: String) {
        currentUser.activity_lvl = newactivity_lvl
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



