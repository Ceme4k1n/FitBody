package com.example.fitness.login_singin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firebase.ui.auth.data.model.User

class UserViewModel : ViewModel() {
    private val _user = MutableLiveData<Users>()
    val user: LiveData<Users> = _user
    val User by lazy {

        _user.value ?: Users(
             name="",
         surname="",
         phone="",
         age=0,
         sex=true,
         height=0.0,
         weight=0,
         goal="",
         activity_lvl=""
        )
    }
}