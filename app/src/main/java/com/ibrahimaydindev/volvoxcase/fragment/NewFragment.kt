package com.ibrahimaydindev.volvoxcase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.ibrahimaydindev.volvoxcase.R
import com.ibrahimaydindev.volvoxcase.activity.MainActivity
import com.ibrahimaydindev.volvoxcase.databinding.FragmentNewBinding
import com.ibrahimaydindev.volvoxcase.viewmodel.NewsViewModel

class NewFragment : Fragment(R.layout.fragment_new) {
    private lateinit var newBinding: FragmentNewBinding
    lateinit var viewModel: NewsViewModel
    val args: NewFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNewBinding.bind(view)
        newBinding = binding
        viewModel = (activity as MainActivity).viewModel
        val article = args.news
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }
    }
}