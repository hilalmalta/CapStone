package com.hm.capstone.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Products (
    @SerializedName("id")
    @Expose
    var product_id:Int,
    @SerializedName("satici_adi")
    @Expose
    var seller_name:String,
    @SerializedName("urun_adi")
    @Expose
    var product_name:String,
    @SerializedName("urun_fiyat")
    @Expose
    var product_price:String,
    @SerializedName("urun_aciklama")
    @Expose
    var product_detail:String,
    @SerializedName("urun_gorsel_url")
    @Expose
    var product_image_url:String,
    @SerializedName("sepet_durum")
    @Expose
    var product_cart_state:Int,
    @SerializedName("urun_indirimli_mi")
    @Expose
    var product_sale_state:Int) : Serializable {}
