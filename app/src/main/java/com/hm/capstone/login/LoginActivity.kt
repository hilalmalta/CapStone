package com.hm.capstone.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hm.capstone.R
import com.hm.capstone.databinding.ActivityLoginBinding
import com.hm.capstone.databinding.ActivityMainBinding
import com.hm.capstone.login.fragments.UploadFragment

class LoginActivity : AppCompatActivity() {

    private lateinit var view: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(view.root)




    }
}

