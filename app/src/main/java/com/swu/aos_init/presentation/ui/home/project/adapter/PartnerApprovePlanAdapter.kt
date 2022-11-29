package com.swu.aos_init.presentation.ui.home.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseAlarm
import com.swu.aos_init.data.response.ResponseApplicant
import com.swu.aos_init.data.response.ResponseApprove
import com.swu.aos_init.databinding.ItemAlarmBinding
import com.swu.aos_init.databinding.ItemApplicantListBinding
import com.swu.aos_init.databinding.ItemApproveListBinding
import com.swu.aos_init.presentation.util.DiffUtilCallback

class PartnerApprovePlanAdapter(): ListAdapter<ResponseApprove, PartnerApprovePlanAdapter.ApplicantViewHolder>(
    DiffUtilCallback<ResponseApprove>()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ApplicantViewHolder {
        val binding =
            ItemApproveListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ApplicantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApplicantViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ApplicantViewHolder(val binding: ItemApproveListBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(data : ResponseApprove) {
                binding.viewModel = data
                Glide.with(binding.root).load(data.src).into(binding.imageView2)
            }
        }
}