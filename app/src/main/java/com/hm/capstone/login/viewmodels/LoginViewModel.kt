package com.hm.capstone.login.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hm.capstone.repo.UserDaoRepository

class LoginViewModel : ViewModel() {

    val uDaoRepo = UserDaoRepository()

    fun getVal(): Int? {
        val uVal = uDaoRepo.getUserVal()
        return uVal.value
    }


    fun login(mail: String, password:String){
        uDaoRepo.getUser(mail, password)
    }


//    fun getVal(){
//        uDaoRepo.getUserVal()
//    }

}