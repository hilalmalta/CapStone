package com.hm.capstone.login.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hm.capstone.entities.Products
import com.hm.capstone.entities.Users
import com.hm.capstone.repo.ProductDaoRepository
import com.hm.capstone.repo.UserDaoRepository

class LoginViewModel : ViewModel() {

    val uDaoRepo = UserDaoRepository()
    var loggedUser = MutableLiveData<Users>()

    init {
        login("hilalmalta@gmail.com", "123456")
        loggedUser = uDaoRepo.getLoggedUser()
    }


//    fun getVal(): Int? {
//        val uVal = uDaoRepo.getUserVal()
//        return uVal.value
//    }
//

    fun login(mail: String, password:String){
        uDaoRepo.getUser(mail, password)
    }


}