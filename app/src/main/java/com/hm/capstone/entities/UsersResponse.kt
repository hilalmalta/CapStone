package com.hm.capstone.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UsersResponse(
    @SerializedName("kullanicilar")
    @Expose
    var users:List<Users>) {}