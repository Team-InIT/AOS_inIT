package com.swu.aos_init.presentation.ui.alarm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseAlarm
import com.swu.aos_init.databinding.ItemAlarmBinding
import com.swu.aos_init.presentation.util.DiffUtilCallback

class AlarmAdapter(): ListAdapter<ResponseAlarm, AlarmAdapter.AlarmViewHolder>(
    DiffUtilCallback<ResponseAlarm>()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlarmViewHolder {
        val binding =
            ItemAlarmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AlarmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class AlarmViewHolder(val binding: ItemAlarmBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(data : ResponseAlarm) {
                binding.alarm = data
                Glide.with(binding.root).load(data.src).into(binding.ivAlarm)
            }
        }
}