package com.example.tanawatk.mvvmandroid.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tanawatk.mvvmandroid.databinding.ItemNewsBinding
import com.example.tanawatk.mvvmandroid.service.model.News

class NewsAdapter : ListAdapter<News, NewsAdapter.NewsViewHolder>(DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(getItem(position))

    class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.news = news
            binding.executePendingBindings()
        }
    }

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<News>() {
            // Treat null URL as never matching — avoids false equality between stubs
            override fun areItemsTheSame(oldItem: News, newItem: News) =
                oldItem.url != null && oldItem.url == newItem.url

            override fun areContentsTheSame(oldItem: News, newItem: News) = oldItem == newItem
        }
    }
}