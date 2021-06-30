package com.hm.capstone.retrofit

import com.hm.capstone.entities.UserCRUDResponse
import com.hm.capstone.entities.UsersResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserDaoInterface {

    @POST("giris_yap.php")
    @FormUrlEncoded
    fun login(@Field("mail_adres") e_mail:String,
              @Field("sifre") password:String):Call<UsersResponse>

    @POST("uye_ol.php")
    @FormUrlEncoded
    fun signup(
        @Field("mail_adres") e_mail:String,
        @Field("sifre") password:String,
        @Field("ad_soyad") name:String,
        @Field("telefon") phone_number:String):Call<UserCRUDResponse>
}