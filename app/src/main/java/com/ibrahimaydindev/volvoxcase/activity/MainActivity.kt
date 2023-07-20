package com.ibrahimaydindev.volvoxcase.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.ibrahimaydindev.volvoxcase.R
import com.ibrahimaydindev.volvoxcase.database.NewsDatabase
import com.ibrahimaydindev.volvoxcase.databinding.ActivityMainBinding
import com.ibrahimaydindev.volvoxcase.repository.NewsRepository
import com.ibrahimaydindev.volvoxcase.viewmodel.NewsViewModel
import com.ibrahimaydindev.volvoxcase.viewmodel.NewsViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val newsRepository = NewsRepository(NewsDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

    }
}