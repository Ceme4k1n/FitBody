package com.example.fitness.login_singin

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

data class Users_dannie (
    var name : String="143",
    var phone: String="12435",
    var age: Int=4,
    var sex:Boolean=true,
    var height:Double=0.0,
    var weight:Double=0.0,
    var goal: String="414",
    var activity_lvl:String="515"
)

{
    fun updateName(newName: String) {
        name = newName
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
        userRef.set(
            mapOf(
                "name" to user.name,
                "phone" to user.phone,
                "age" to user.age,
                "sex" to user.sex,
                "height" to user.height,
                "weight" to user.weight,
                "goal" to user.goal,
                "activity_lvl" to user.activity_lvl
            )
        )
            .addOnSuccessListener {
                Log.d(TAG, "Данные добавлены")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Ошибка при добавлении данных", e)
            }
    } ?: Log.w(TAG, "Пользователь не аутентифицирован")
}


fun getUserFromDb(callback: (Users_dannie) -> Unit){

    val userID = FirebaseAuth.getInstance().currentUser?.uid

    FirebaseFirestore.getInstance()
        .collection("users")
        .document(userID!!)
        .get()
        .addOnSuccessListener { new ->
            val name = new.getString("name")?: ""
            val phone = new.getString("phone")?: ""
            val age = new.getString("age")?: ""
            val sex = new.getString("sex")?: ""
            val height = new.getString("height")?: ""
            val weight = new.getString("weight")?: ""
            val goal = new.getString("goal")?: ""
            val activity_lvl = new.getString("activity_lvl")?: ""

            val getData = Users_dannie(
                name,
                phone,
                age.toInt(),
                sex.toBoolean(),
                height.toDouble(),
                weight.toDouble(),
                goal,
                activity_lvl
                )

            callback(getData)
            Log.d(TAG, "Успешно получены данные:  \n $getData")
        }
        .addOnFailureListener{
            Log.d(TAG, "Ошибка получения данных")
        }

}




