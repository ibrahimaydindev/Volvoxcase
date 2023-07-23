package com.ibrahimaydindev.volvoxcase.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.ibrahimaydindev.volvoxcase.R
import com.ibrahimaydindev.volvoxcase.database.NewsDatabase
import com.ibrahimaydindev.volvoxcase.databinding.ActivityMainBinding
import com.ibrahimaydindev.volvoxcase.repository.NewsRepository
import com.ibrahimaydindev.volvoxcase.viewmodel.NewsViewModel
import com.ibrahimaydindev.volvoxcase.viewmodel.NewsViewModelProviderFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory :NewsViewModelProviderFactory by instance()


    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        viewModel = ViewModelProviders.of(this, factory)[NewsViewModel::class.java]
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.newsFragment)
                    true
                }

                R.id.nav_saved -> {
                    navController.navigate(R.id.savedFragment)
                    true
                }

                else -> false
            }
        }
    }
}