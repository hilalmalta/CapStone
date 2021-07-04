package com.hm.capstone.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hm.capstone.entities.Products
import com.hm.capstone.repo.ProductDaoRepository

class ProductsViewModel : ViewModel() {

    var productList = MutableLiveData<List<Products>>()
    private val pDaoRepo = ProductDaoRepository()

    init {
        getProduct()
        productList = pDaoRepo.getProductList()
    }
    fun getProduct(){
        pDaoRepo.getProduct("hilalmalta")
    }

    fun updateCart(id:Int, state:Int){
        pDaoRepo.updateCart(id, state)
    }

}