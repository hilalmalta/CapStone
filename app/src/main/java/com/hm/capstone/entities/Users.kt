package com.hm.capstone.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Users (  @SerializedName("deger")
               @Expose
               var user_val:Int,
               @SerializedName("mail_adres")
               @Expose
               var user_mail:String,
               @SerializedName("sifre")
               @Expose
               var user_password:String,
               @SerializedName("ad_soyad")
               @Expose
               var user_name:String,
               @SerializedName("telefon")
               @Expose
               var user_phone:String) : Serializable {}