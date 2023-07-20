package com.ibrahimaydindev.volvoxcase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahimaydindev.volvoxcase.R
import com.ibrahimaydindev.volvoxcase.model.News

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_news,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val news = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(news.urlToImage).into(findViewById(R.id.newsImage))
            findViewById<TextView>(R.id.newsSource).text = news.source?.name
            findViewById<TextView>(R.id.newsTitle).text = news.title
            findViewById<TextView>(R.id.newsDescription).text = news.description
            setOnClickListener {
                onItemClickListener?.let {
                    it(news)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    fun setOnItemClickListener(listen: (News) -> Unit) {
        onItemClickListener = listen
    }
    private var onItemClickListener: ((News) -> Unit)? = null
}