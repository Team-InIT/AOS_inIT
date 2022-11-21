package com.swu.aos_init.presentation.ui.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.data.response.feed.ResponseFeed
import com.swu.aos_init.databinding.ItemFeedBinding

class FeedAdapter : ListAdapter<ResponseFeed, FeedAdapter.FeedViewAdapter>(
    feedDiffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewAdapter {
        val binding =
            ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewAdapter(binding)
    }

    override fun onBindViewHolder(holder: FeedViewAdapter, position: Int) {
        holder.onBind(getItem(position))
    }

    class FeedViewAdapter(val binding: ItemFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseFeed) {
            binding.feedData = data
        }
    }

    companion object {
        private val feedDiffUtil = object : DiffUtil.ItemCallback<ResponseFeed>() {
            override fun areItemsTheSame(
                oldItem: ResponseFeed,
                newItem: ResponseFeed
            ): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(
                oldItem: ResponseFeed,
                newItem: ResponseFeed
            ): Boolean =
                oldItem == newItem
        }
    }
}