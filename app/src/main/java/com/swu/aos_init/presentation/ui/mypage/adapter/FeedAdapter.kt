package com.swu.aos_init.presentation.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.aos_init.data.response.mypage.ResponseMyPageFeed
import com.swu.aos_init.databinding.ItemMypageFeedListBinding
import com.swu.aos_init.presentation.util.DiffUtilCallback

class FeedAdapter : ListAdapter<ResponseMyPageFeed, FeedAdapter.FeedViewHolder>(
    DiffUtilCallback<ResponseMyPageFeed>()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeedViewHolder {
        val binding =
            ItemMypageFeedListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class FeedViewHolder(val binding: ItemMypageFeedListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : ResponseMyPageFeed) {
            binding.viewModel = data
            Glide.with(binding.root).load(data.image).into(binding.ivIcon)
        }
    }
}