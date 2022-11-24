package com.swu.aos_init.presentation.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.data.response.mypage.ResponseMyPageZzim
import com.swu.aos_init.databinding.ItemMypageZzimBinding
import com.swu.aos_init.presentation.util.DiffUtilCallback

class MyPageZzimAdapter : ListAdapter<ResponseMyPageZzim, MyPageZzimAdapter.ZZimViewAdapter>(
    DiffUtilCallback<ResponseMyPageZzim>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZZimViewAdapter {
        val binding =
            ItemMypageZzimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ZZimViewAdapter(binding)
    }

    override fun onBindViewHolder(holder: ZZimViewAdapter, position: Int) {
        holder.onBind(getItem(position))
    }

    class ZZimViewAdapter(val binding: ItemMypageZzimBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseMyPageZzim) {
            binding.heart = data
        }
    }
}