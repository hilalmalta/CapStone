package com.hm.capstone.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hm.capstone.R
import com.hm.capstone.databinding.ActivityMainBinding
import com.hm.capstone.main.fragments.CartFragment
import kotlin.concurrent.fixedRateTimer


class MainActivity : AppCompatActivity() {

    private lateinit var view: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainFragmentContainer) as NavHostFragment
        NavigationUI.setupWithNavController(view.bottomNav, navHostFragment.navController)

        setSupportActionBar(view.toolbar)
        setupActionBarWithNavController(navHostFragment.navController)
        view.toolbar.setupWithNavController(navHostFragment.navController)

        view.toolbar.title = ""

        view.goToCartIcon.setOnClickListener {

            val fm: FragmentManager = supportFragmentManager
            fm.beginTransaction().replace(R.id.mainFragmentContainer, CartFragment()).commit()

        }

    }

    fun getMyTextView(): TextView = view.toolbarTitle

}