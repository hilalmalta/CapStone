package com.hm.capstone.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hm.capstone.R
import com.hm.capstone.databinding.ProductsFragmentBinding
import com.hm.capstone.main.MainActivity
import com.hm.capstone.main.adapters.ProductAdapter
import com.hm.capstone.main.viewmodels.ProductsViewModel as ProductsViewModel

class ProductsFragment : Fragment() {

    private lateinit var view: ProductsFragmentBinding
    private lateinit var adapter:ProductAdapter
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.products_fragment, container, false)
        view.productFragment = this

        viewModel.productList.observe(viewLifecycleOwner, {
            adapter= ProductAdapter(requireContext(),it, viewModel)
            view.adapter=adapter })


        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Organio"




        return view.root
    }


}