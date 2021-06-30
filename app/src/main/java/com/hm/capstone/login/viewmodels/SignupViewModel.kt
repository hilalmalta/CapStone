package com.hm.capstone.login.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hm.capstone.repo.UserDaoRepository

class SignupViewModel : ViewModel() {

    val uDaoRepo = UserDaoRepository()

    fun upload(mail: String, password:String, name:String, phone:String){
        uDaoRepo.addUser(mail, password, name, phone)
    }
}