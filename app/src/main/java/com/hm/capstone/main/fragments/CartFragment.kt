package com.hm.capstone.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hm.capstone.R
import com.hm.capstone.databinding.CartFragmentBinding
import com.hm.capstone.main.MainActivity
import com.hm.capstone.main.adapters.CartAdapter
import com.hm.capstone.main.viewmodels.CartViewModel

class CartFragment : Fragment() {

    private lateinit var view: CartFragmentBinding
    private lateinit var adapter: CartAdapter
    private val viewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.cart_fragment, container, false)
        view.cartFragment = this


        viewModel.cartList.observe(viewLifecycleOwner, {
            adapter= CartAdapter(requireContext(),it, viewModel)
            view.adapter=adapter

        })

//        view.purchaseButton.setOnClickListener {
//
//            viewModel.cartList.value?.let { it1 -> viewModel.purchase(it1) }
//
//        }




        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Sepetim"

        return view.root
    }



}