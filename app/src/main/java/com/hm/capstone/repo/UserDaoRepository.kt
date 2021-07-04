package com.hm.capstone.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hm.capstone.entities.*
import com.hm.capstone.retrofit.ApiUtils
import com.hm.capstone.retrofit.UserDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDaoRepository {
    private val userList: MutableLiveData<List<Users>> = MutableLiveData()
    private val userVal: MutableLiveData<Int> = MutableLiveData()
    private val uDaoInterface: UserDaoInterface = ApiUtils.getUserDaoInterface()
    private val loggedUser: MutableLiveData<Users> = MutableLiveData()

    fun getUserVal(): MutableLiveData<Int> {
        return userVal
    }

    fun getLoggedUser(): MutableLiveData<Users>{

        return loggedUser
    }

    fun getUser(mail: String, password:String){
        uDaoInterface.login(mail, password).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>?, response: Response<UsersResponse>) {
                Log.e("Başarı", response.body().users.toString())
                val _userList = response.body().users
                userList.value = _userList
                val _loggedUser = response.body().users[0]
                loggedUser.value = _loggedUser

                val _userVal = response.body().users[0].user_val
                userVal.value = _userVal
                println("liste size: " + userList.value!!.size)
                println("kullanıcı adı: " + userList.value!![0].user_name)
                println("kullanıcı değer: " + userVal.value)

            }
            override fun onFailure(call: Call<UsersResponse>?, t: Throwable?) {
                Log.e("getUser",t?.localizedMessage.toString())
            }
        })
    }

    fun addUser(mail: String, password:String, name:String, phone:String ){
        uDaoInterface.signup(mail, password, name, phone).enqueue(object: Callback<UserCRUDResponse> {
            override fun onResponse(call: Call<UserCRUDResponse>?, response: Response<UserCRUDResponse>) {
                Log.e("Başarı", response.body().success.toString())
                Log.e( "Mesaj", response.body().message)
            }
            override fun onFailure(call: Call<UserCRUDResponse>?, t: Throwable?) {
                Log.e("addUser",t?.localizedMessage.toString())
            }
        })
    }
}