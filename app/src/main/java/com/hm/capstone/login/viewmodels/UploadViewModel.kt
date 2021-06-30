package com.hm.capstone.login.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hm.capstone.repo.ProductDaoRepository

class UploadViewModel : ViewModel() {

    val pDaoRepo = ProductDaoRepository()

    fun upload(seller: String, name:String, price:String, desc:String, img_url:String){
        pDaoRepo.addProduct(seller, name, price, desc, img_url)
    }

}