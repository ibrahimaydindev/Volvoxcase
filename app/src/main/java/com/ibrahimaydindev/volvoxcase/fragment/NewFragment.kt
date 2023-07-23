package com.ibrahimaydindev.volvoxcase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import com.ibrahimaydindev.volvoxcase.R
import com.ibrahimaydindev.volvoxcase.activity.MainActivity
import com.ibrahimaydindev.volvoxcase.databinding.FragmentNewBinding
import com.ibrahimaydindev.volvoxcase.model.News
import com.ibrahimaydindev.volvoxcase.viewmodel.NewsViewModel

class NewFragment : Fragment(R.layout.fragment_new) {
    private lateinit var newBinding: FragmentNewBinding
    lateinit var viewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        newBinding = FragmentNewBinding.inflate(inflater, container, false)
        return newBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNewBinding.bind(view)
        newBinding = binding
        viewModel = (activity as MainActivity).viewModel

        val bundle = arguments

        if (bundle != null) {
            if (bundle.getSerializable("br") != null) {
                val article = bundle.getSerializable("br") as News
                newBinding.webView.apply {
                    webViewClient = WebViewClient()
                    article.url.let { loadUrl(it) }
                }
            }else {
                Toast.makeText(requireContext(), "Haber bulunamadı", Toast.LENGTH_SHORT).show()
            }
        }
    }
}