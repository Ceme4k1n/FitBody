package com.example.fitness.login_singin

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

data class Users_dannie (
    var name : String="",
    var phone: String="",
    var age: String="",
    var sex:String="",
    var height:String="",
    var weight:String="",
    var goal: String="",
    var activity_lvl:String="",
    var email_adress:String=""
)

{
    fun update_class(
        newName: String,
        newPhone: String,
        newage: String,
        newsex: String,
        newheight: String,
        newweight: String,
        newgoal: String,
        newactivity_lvl: String,
        newemail_adress: String
    )
    {
        name = newName
        phone = newPhone
        age = newage
        sex = newsex
        height = newheight
        weight = newweight
        goal = newgoal
        activity_lvl = newactivity_lvl
        email_adress=newemail_adress
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
                "activity_lvl" to user.activity_lvl,
                "email_adress" to user.email_adress
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
            val email_adress=new.getString("email_adress")?:""

            val getData = Users_dannie(
                name,
                phone,
                age,
                sex,
                height,
                weight,
                goal,
                activity_lvl ,
                email_adress
                )

            callback(getData)
            Log.d(TAG, "Успешно получены данные:  \n $getData")
        }
        .addOnFailureListener{
            Log.d(TAG, "Ошибка получения данных")
        }

}




