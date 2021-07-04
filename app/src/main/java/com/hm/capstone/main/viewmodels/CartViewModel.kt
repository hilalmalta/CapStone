package com.hm.capstone.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hm.capstone.entities.Products
import com.hm.capstone.repo.ProductDaoRepository

class CartViewModel : ViewModel() {

    var cartList = MutableLiveData<List<Products>>()
    private val pDaoRepo = ProductDaoRepository()

    init {
        getProduct()
        cartList = pDaoRepo.getCartProductList()
    }

    fun getProduct(){
        pDaoRepo.getCartProduct("hilalmalta")
    }

    fun updateCart(id:Int, state:Int){
        pDaoRepo.updateCart(id, state)
    }

    fun purchase(list: List<Products>){

        for(i in list){
            pDaoRepo.updateCart(i.product_id, 0)

        }


    }
}