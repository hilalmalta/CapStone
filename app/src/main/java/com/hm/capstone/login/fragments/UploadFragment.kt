package com.hm.capstone.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.hm.capstone.R
import com.hm.capstone.databinding.UploadFragmentBinding
import com.hm.capstone.login.viewmodels.UploadViewModel

class UploadFragment : Fragment() {

    private lateinit var view:UploadFragmentBinding
    private val viewModel: UploadViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.upload_fragment, container, false)
        view.uploadFragment = this


        return view.root
    }

    fun buttonUpload(seller: String, name:String, price:String, desc:String, img_url:String){
        viewModel.upload(seller, name, price, desc, img_url)

    }

}