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

        var dataMap = mutableMapOf<String, Any>()

        if (!user.name.isBlank()) dataMap["name"] = user.name
        if (!user.phone.isBlank()) dataMap["phone"] = user.phone
        if (!user.age.isBlank()) dataMap["age"] = user.age
        if (!user.sex.isBlank()) dataMap["sex"] = user.sex
        if (!user.height.isBlank()) dataMap["height"] = user.height
        if (!user.weight.isBlank()) dataMap["weight"] = user.weight
        if (!user.goal.isBlank()) dataMap["goal"] = user.goal
        if (!user.activity_lvl.isBlank()) dataMap["activity_lvl"] = user.activity_lvl
        if (!user.email_adress.isBlank()) dataMap["email_adress"] = user.email_adress

        userRef.set(dataMap)
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




