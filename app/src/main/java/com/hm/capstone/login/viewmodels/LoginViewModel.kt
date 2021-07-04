package com.hm.capstone.login.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hm.capstone.entities.Users
import com.hm.capstone.repo.UserDaoRepository

class LoginViewModel : ViewModel() {

    val uDaoRepo = UserDaoRepository()
    var loggedUser = MutableLiveData<Users>()
    var uVal = MutableLiveData<Int>()

    init {
        loggedUser = uDaoRepo.getLoggedUser()
        uVal = uDaoRepo.getUserVal()
    }



    fun getUUVal():MutableLiveData<Int>{
        return uVal

    }

    fun getUser():MutableLiveData<Users>{
        return loggedUser
    }

    fun login(mail: String, password:String){
        uDaoRepo.getUser(mail, password)
    }


}