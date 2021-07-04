package com.hm.capstone.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.hm.capstone.R
import com.hm.capstone.databinding.UserFragmentBinding
import com.hm.capstone.entities.Users
import com.hm.capstone.login.viewmodels.LoginViewModel
import com.hm.capstone.main.MainActivity
import com.hm.capstone.repo.UserDaoRepository

class UserFragment : Fragment() {
    private lateinit var view: UserFragmentBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.user_fragment, container, false)
        view.userFragment = this

        viewModel.loggedUser.observe(viewLifecycleOwner, {
            view.userObject = it
        })

        (activity as MainActivity).supportActionBar?.title = ""
        ((activity as MainActivity)).getMyTextView().text = "Profilim"

        return view.root
    }


}