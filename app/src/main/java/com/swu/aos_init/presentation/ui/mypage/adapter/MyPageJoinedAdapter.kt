package com.swu.aos_init.presentation.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.data.response.mypage.ResponseMyPageJoin
import com.swu.aos_init.data.response.mypage.ResponseMyPageZzim
import com.swu.aos_init.databinding.ItemMypageJoinBinding
import com.swu.aos_init.databinding.ItemMypageZzimBinding
import com.swu.aos_init.presentation.util.DiffUtilCallback

class MyPageJoinedAdapter : ListAdapter<ResponseMyPageJoin, MyPageJoinedAdapter.JoinViewAdapter>(
    DiffUtilCallback<ResponseMyPageJoin>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JoinViewAdapter {
        val binding =
            ItemMypageJoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JoinViewAdapter(binding)
    }

    override fun onBindViewHolder(holder: JoinViewAdapter, position: Int) {
        holder.onBind(getItem(position))
    }

    class JoinViewAdapter(val binding: ItemMypageJoinBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseMyPageJoin) {
            binding.join = data
        }
    }
}