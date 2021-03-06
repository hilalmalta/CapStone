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
import com.hm.capstone.databinding.SalesFragmentBinding
import com.hm.capstone.entities.Products
import com.hm.capstone.main.MainActivity
import com.hm.capstone.main.adapters.CartAdapter
import com.hm.capstone.main.adapters.ProductAdapter
import com.hm.capstone.main.adapters.SalesAdapter
import com.hm.capstone.main.viewmodels.SalesViewModel

class SalesFragment : Fragment() {
    private lateinit var view: SalesFragmentBinding
    private lateinit var adapter: SalesAdapter
    private val viewModel: SalesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.sales_fragment, container, false)
        view.saleFragment = this

        viewModel.saleList.observe(viewLifecycleOwner, {
            adapter= SalesAdapter(requireContext(),it, viewModel)
            view.adapter=adapter })







        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Kampanyalar"

         return view.root
    }


}