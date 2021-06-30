package com.hm.capstone.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductsResponse(
    @SerializedName("urunler")
    @Expose
    var products:List<Products>,
    @SerializedName("success")
    @Expose
    var success:Int,
    @SerializedName("message")
    @Expose
    var message:String) {}