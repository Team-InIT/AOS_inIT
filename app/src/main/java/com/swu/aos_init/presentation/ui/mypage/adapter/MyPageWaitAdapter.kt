package com.swu.aos_init.presentation.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.data.response.mypage.ResponseMyPageWait
import com.swu.aos_init.data.response.mypage.ResponseMyPageZzim
import com.swu.aos_init.databinding.ItemMypageWaitBinding
import com.swu.aos_init.databinding.ItemMypageZzimBinding
import com.swu.aos_init.presentation.util.DiffUtilCallback

class MyPageWaitAdapter : ListAdapter<ResponseMyPageWait, MyPageWaitAdapter.WaitViewAdapter>(
    DiffUtilCallback<ResponseMyPageWait>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaitViewAdapter {
        val binding =
            ItemMypageWaitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WaitViewAdapter(binding)
    }

    override fun onBindViewHolder(holder: WaitViewAdapter, position: Int) {
        holder.onBind(getItem(position))
    }

    class WaitViewAdapter(val binding: ItemMypageWaitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseMyPageWait) {
            binding.heart = data
        }
    }
}