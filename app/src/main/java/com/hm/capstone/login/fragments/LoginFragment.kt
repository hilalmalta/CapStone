package com.hm.capstone.login.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import com.hm.capstone.R
import com.hm.capstone.databinding.LoginFragmentBinding
import com.hm.capstone.login.viewmodels.LoginViewModel
import com.hm.capstone.main.MainActivity
import com.hm.capstone.main.adapters.CartAdapter
import com.hm.capstone.repo.UserDaoRepository

class LoginFragment : Fragment() {

    private lateinit var view: LoginFragmentBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        view = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        view.loginFragment = this

        view.addProductView.setOnClickListener {
            Log.e("ürün ekle", "tıklandı")
            val pass = LoginFragmentDirections.actionLoginFragmentToUploadFragment()
            Navigation.findNavController(it).navigate(pass)
        }

        view.signupButton.setOnClickListener {
            Log.e("kayıt ol", "tıklandı")
            val pass = LoginFragmentDirections.actionLoginFragmentToSignupFragment()
            Navigation.findNavController(it).navigate(pass)
        }

        view.loginButton.setOnClickListener {
            viewModel.login(view.userNameText.text.toString(), view.loginPassText.text.toString())

            viewModel.loggedUser.observe(viewLifecycleOwner, {

                val myuser = it
                println("gelen user" + myuser.toString())
                val userVal = it.user_val

                println("kullanıcı değer" + userVal )
                if (userVal == 1){
                    val i = Intent(requireContext(), MainActivity::class.java)
                    startActivity(i)
                }
                else{
                    Toast.makeText(requireContext(), "Kullanıcı Bulunamadı", Toast.LENGTH_SHORT).show()
                }


            })




        }




        return view.root
    }

}