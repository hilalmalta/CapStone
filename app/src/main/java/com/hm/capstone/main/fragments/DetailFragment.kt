package com.hm.capstone.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.hm.capstone.R
import com.hm.capstone.databinding.DetailFragmentBinding
import com.hm.capstone.main.MainActivity
import com.hm.capstone.main.viewmodels.DetailViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var view: DetailFragmentBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
        view.detailFragment=this

        val b:DetailFragmentArgs by navArgs()

        view.productObject = b.productObject


        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Organio"



        val url = b.productObject.product_image_url
        Picasso.get().load(url).into(view.productDetailImg)



        return view.root
    }


}

