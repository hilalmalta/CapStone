package com.hm.capstone.main.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hm.capstone.R
import com.hm.capstone.databinding.CartFragmentBinding
import com.hm.capstone.databinding.ProductsFragmentBinding
import com.hm.capstone.entities.Products
import com.hm.capstone.main.MainActivity
import com.hm.capstone.main.adapters.CartAdapter
import com.hm.capstone.main.adapters.ProductAdapter
import com.hm.capstone.main.viewmodels.CartViewModel

class CartFragment : Fragment() {

    private lateinit var view: CartFragmentBinding
    private lateinit var adapter: CartAdapter
    private val viewModel: CartViewModel by viewModels()
    var tempList:ArrayList<Products> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.cart_fragment, container, false)
        view.cartFragment = this

        for (i in viewModel.cartList.value!!.listIterator()){

            if (i.product_cart_state == 1){
                tempList.add(i)
            }
        }


        viewModel.cartList.observe(viewLifecycleOwner, {
            adapter= CartAdapter(requireContext(),tempList, viewModel)
            view.adapter=adapter })

        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Sepetim"

        return view.root
    }



}