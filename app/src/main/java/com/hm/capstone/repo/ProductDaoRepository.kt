package com.hm.capstone.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hm.capstone.entities.ProductCRUDResponse
import com.hm.capstone.entities.Products
import com.hm.capstone.entities.ProductsResponse
import com.hm.capstone.retrofit.ApiUtils
import com.hm.capstone.retrofit.ProductDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDaoRepository {

    private val productList: MutableLiveData<List<Products>> = MutableLiveData()
    private val pDaoInterface:ProductDaoInterface = ApiUtils.getProductDaoInterface()


    fun getProductList(): MutableLiveData<List<Products>> {
        return productList
    }


    fun getProduct(sellerName:String){
        pDaoInterface.getProduct(sellerName).enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(call: Call<ProductsResponse>?, response: Response<ProductsResponse>) {
                Log.e( "Mesaj", response.body().products.toString())
                val p_list = response.body().products
                productList.value = p_list
            }
            override fun onFailure(call: Call<ProductsResponse>?, t: Throwable?) {
                Log.e("getProduct", t?.localizedMessage.toString())
            }
        })
    }


    fun addProduct(seller: String, name:String, price:String, desc:String, img_url:String ){
        pDaoInterface.postProduct(seller, name, price, desc, img_url).enqueue(object: Callback<ProductCRUDResponse> {
            override fun onResponse(call: Call<ProductCRUDResponse>?, response: Response<ProductCRUDResponse>) {
                Log.e("Ürün ekleme Başarı", response.body().success.toString())
                Log.e( "Ürün ekleme Mesaj", response.body().message)
            }
            override fun onFailure(call: Call<ProductCRUDResponse>?, t: Throwable?) {
                Log.e("Ürün ekleme", t?.localizedMessage.toString())
            }
        })
    }


    fun updateCart(id:Int, state:Int){
        pDaoInterface.updateCartState(id, state).enqueue(object: Callback<ProductCRUDResponse> {
            override fun onResponse(call: Call<ProductCRUDResponse>?, response: Response<ProductCRUDResponse>) {
                Log.e("Başarı", response.body().success.toString())
                Log.e( "Mesaj", response.body().message)
            }
            override fun onFailure(call: Call<ProductCRUDResponse>?, t: Throwable?) {
                Log.e("updateCart", t?.localizedMessage.toString())
            }
        })
    }



    fun updateSale(id:Int, state:Int){
        pDaoInterface.updateSaleState(id, state).enqueue(object: Callback<ProductCRUDResponse> {
            override fun onResponse(call: Call<ProductCRUDResponse>?, response: Response<ProductCRUDResponse>) {
                Log.e("Başarı", response.body().success.toString())
                Log.e( "Mesaj", response.body().message)
            }
            override fun onFailure(call: Call<ProductCRUDResponse>?, t: Throwable?) {
                Log.e("updateSale", t?.localizedMessage.toString())
            }
        })
    }


}