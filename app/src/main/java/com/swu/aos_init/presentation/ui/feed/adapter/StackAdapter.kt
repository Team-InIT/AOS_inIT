package com.swu.aos_init.presentation.ui.feed.adapter

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.data.response.ResponseStack
import com.swu.aos_init.databinding.ItemStackBinding


class StackAdapter:
    RecyclerView.Adapter<StackAdapter.OnboardingListViewHolder>() {
    var dataList = mutableListOf<ResponseStack>()
    var findText = ""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingListViewHolder {
        val binding = ItemStackBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OnboardingListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingListViewHolder, position: Int) {
        holder.onBind(dataList[position], colorChange(dataList[position].name, findText))
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class OnboardingListViewHolder(
        val binding: ItemStackBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: ResponseStack, text: SpannableStringBuilder) {
            binding.apply {
                tvStack.text = text
                viewModel = data
                executePendingBindings()
            }
        }
    }


    private fun colorChange(fulltext: String, findText: String): SpannableStringBuilder {
        val str = SpannableStringBuilder(fulltext)
        val startInt = fulltext.indexOf(findText)
        val endInt = startInt + findText.length
        str.setSpan(
            ForegroundColorSpan(Color.parseColor("#2C77D4")),
            startInt,
            endInt,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        return str
    }


    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    private lateinit var itemClickListener: ItemClickListener


    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener

    }


    fun setStackList(data: MutableList<ResponseStack>) {
        this.dataList = data
        notifyDataSetChanged()
    }
}