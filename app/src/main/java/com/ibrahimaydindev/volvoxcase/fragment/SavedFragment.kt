package com.ibrahimaydindev.volvoxcase.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahimaydindev.volvoxcase.R
import com.ibrahimaydindev.volvoxcase.activity.MainActivity
import com.ibrahimaydindev.volvoxcase.adapter.NewsAdapter
import com.ibrahimaydindev.volvoxcase.databinding.FragmentSavedBinding
import com.ibrahimaydindev.volvoxcase.viewmodel.NewsViewModel

class SavedFragment : Fragment() {
    private lateinit var binding: FragmentSavedBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        newsAdapter = NewsAdapter()
        setupRecyclerView()
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("saved", it)
            }

            findNavController().navigate(
                R.id.action_savedFragment_to_newFragment,
                bundle
            )
        }
        viewModel.getsavedNews().observe(viewLifecycleOwner, Observer { articles ->
            newsAdapter.differ.submitList(articles)
        })

    }
    private fun setupRecyclerView() {
        binding.savedNewsRv.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}