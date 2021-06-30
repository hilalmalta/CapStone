package com.hm.capstone.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://upschool.canerture.com/"

        fun getProductDaoInterface():ProductDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(ProductDaoInterface::class.java)
        }

        fun getUserDaoInterface():UserDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(UserDaoInterface::class.java)
        }
    }
}