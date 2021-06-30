package com.hm.capstone.login.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.hm.capstone.R
import com.hm.capstone.databinding.SignupFragmentBinding
import com.hm.capstone.login.viewmodels.SignupViewModel
import com.hm.capstone.login.viewmodels.UploadViewModel

class SignupFragment : Fragment() {

    private lateinit var view: SignupFragmentBinding
    private val viewModel: SignupViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.signup_fragment, container, false)

        view.button3.setOnClickListener {

            buttonUpload(view.eMailText.text.toString(), view.passwordText.text.toString(), view.nameText.text.toString(), view.phoneText.text.toString())

        }

        return view.root
    }

    fun buttonUpload(mail: String, password:String, name:String, phone:String){
        viewModel.upload(mail, password, name, phone)

    }

}