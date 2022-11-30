package com.swu.aos_init.presentation.ui.home.project.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseAlarm
import com.swu.aos_init.data.response.ResponseApplicant
import com.swu.aos_init.databinding.ItemAlarmBinding
import com.swu.aos_init.databinding.ItemApplicantListBinding
import com.swu.aos_init.presentation.ui.home.project.ProjectDetailActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.OtherHyebinPageTabAdapter
import com.swu.aos_init.presentation.ui.mypage.other.OtherHyebinPageActivity
import com.swu.aos_init.presentation.util.DiffUtilCallback

class PartnerPlanAdapter(): ListAdapter<ResponseApplicant, PartnerPlanAdapter.ApplicantViewHolder>(
    DiffUtilCallback<ResponseApplicant>()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ApplicantViewHolder {
        val binding =
            ItemApplicantListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ApplicantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApplicantViewHolder, position: Int) {
        holder.onBind(getItem(position))
        val context = holder.itemView.context
        holder.binding.root.setOnClickListener {
            val intent = Intent(context, OtherHyebinPageActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context,intent, null)
        }
    }

    class ApplicantViewHolder(val binding: ItemApplicantListBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(data : ResponseApplicant) {
                binding.viewModel = data
                Glide.with(binding.root).load(data.src).into(binding.imageView2)
            }
        }
}