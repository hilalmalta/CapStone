package com.hm.capstone.main.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hm.capstone.entities.Products
import com.hm.capstone.repo.ProductDaoRepository

class SalesViewModel : ViewModel() {
    var saleList = MutableLiveData<List<Products>>()
    private val pDaoRepo = ProductDaoRepository()

    init {
        getProduct()
        saleList = pDaoRepo.getSaleProductList()
    }

    fun getProduct(){
        pDaoRepo.getSaleProduct("hilalmalta")
    }


}