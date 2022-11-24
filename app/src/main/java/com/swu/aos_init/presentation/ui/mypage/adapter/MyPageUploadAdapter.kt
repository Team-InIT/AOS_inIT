package com.swu.aos_init.presentation.ui.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.data.response.mypage.ResponseMyPageUpload
import com.swu.aos_init.data.response.mypage.ResponseMyPageZzim
import com.swu.aos_init.databinding.ItemMypageUploadBinding
import com.swu.aos_init.databinding.ItemMypageZzimBinding
import com.swu.aos_init.presentation.util.DiffUtilCallback

class MyPageUploadAdapter : ListAdapter<ResponseMyPageUpload, MyPageUploadAdapter.UploadViewAdapter>(
    DiffUtilCallback<ResponseMyPageUpload>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadViewAdapter {
        val binding =
            ItemMypageUploadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UploadViewAdapter(binding)
    }

    override fun onBindViewHolder(holder: UploadViewAdapter, position: Int) {
        holder.onBind(getItem(position))
    }

    class UploadViewAdapter(val binding: ItemMypageUploadBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseMyPageUpload) {
            binding.upload = data
        }
    }
}