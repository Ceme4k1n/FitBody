package com.example.fitness.login_singin

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

data class Users (
    var name : String="",
    var surname:String="",
    var phone: String="",
    var age: Int=0,
    var sex:Boolean=true,
    var height:Double=0.0,
    var weight:Int=0,
    var goal: String="",
    var activity_lvl:String="")
{
    fun updateUser(
        newName: String,
        newsurname:String,
        newphone: String,
        newage: Int,
        newsex:Boolean,
        newheight:Double,
        newweight:Int,
        newgoal: String,
        newactivity_lvl:String

    )   {
        name = newName
        surname=newsurname
        phone=newphone
        age=newage
        height=newheight
        weight=newweight
        goal=newgoal
        sex=newsex
        activity_lvl=newactivity_lvl
    }

}

fun addUsertodb(
    user:Users
){
    val userid=FirebaseAuth.getInstance().currentUser?.uid
    val userref=FirebaseFirestore.getInstance().collection("users").document(userid!!)

    userref.set(
        mapOf(
            "name" to user.name,
            "surname" to user.surname,
            "phone" to user.surname,
            "age" to user.age,
            "height" to user.height,
            "weight" to user.weight,
            "goal" to user.goal,
            "activity_lvl" to user.activity_lvl
        )
    )
        .addOnSuccessListener {
            Log.d(TAG,"zaebis dobavil")
        }
}