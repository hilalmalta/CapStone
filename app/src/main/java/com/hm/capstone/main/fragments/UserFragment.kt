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
import com.hm.capstone.databinding.UserFragmentBinding
import com.hm.capstone.main.MainActivity
import com.hm.capstone.main.viewmodels.UserViewModel

class UserFragment : Fragment() {
    private lateinit var view: UserFragmentBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.user_fragment, container, false)

        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Profilim"

        return view.root
    }


}