package com.hm.capstone.retrofit

import com.hm.capstone.entities.ProductCRUDResponse
import com.hm.capstone.entities.ProductsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductDaoInterface {

    @POST("urunler.php")
    @FormUrlEncoded
    fun getProduct(@Field("satici_adi") seller:String
    ):Call<ProductsResponse>


    @POST("urun_ekle.php")
    @FormUrlEncoded
    fun postProduct(@Field("satici_adi") seller:String,
                     @Field("urun_adi") product_name:String,
                     @Field("urun_fiyat") product_price:String,
                     @Field("urun_aciklama") product_desc: String,
                     @Field("urun_gorsel_url") product_img_url: String
    ):Call<ProductCRUDResponse>


    @POST("sepet_durum_degistir.php")
    @FormUrlEncoded
    fun updateCartState(@Field("id") product_id:Int,
                        @Field("sepet_durum") cart_state:Int
    ):Call<ProductCRUDResponse>


    @POST("indirimli_urun_durum_degistir.php")
    @FormUrlEncoded
    fun updateSaleState(@Field("id") product_id:Int,
                        @Field("urun_indirimli_mi") sale_state:Int
    ):Call<ProductCRUDResponse>

}