package com.swu.aos_init.presentation.util

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.databinding.ItemBottomSheetDefaultListBinding

class SelectedTxtAdapter(val checkBtnState: () -> Unit) :
    RecyclerView.Adapter<SelectedTxtAdapter.SelectedTxtViewHolder>() {

    var itemList = mutableListOf<SelectedTxtData>()

    class SelectedTxtViewHolder(private val binding: ItemBottomSheetDefaultListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val textView: TextView = binding.itemTvBottomSheetDefault

        fun onBind(data: SelectedTxtData) {
            binding.selectedTxtData = data
            binding.itemTvBottomSheetDefault.isSelected = data.selectedState!!
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedTxtViewHolder {
        val binding = ItemBottomSheetDefaultListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return SelectedTxtViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectedTxtViewHolder, position: Int) {
        holder.onBind(itemList[position])

        holder.itemView.setOnClickListener {
            if (holder.textView.isSelected) {
                itemList[position].selectedState = false
            } else {
                itemList[position].selectedState = true

                for (i in itemList.indices) {
                    if (i != position) {
                        itemList[i].selectedState = false
                    }
                }
            }
            notifyItemRangeChanged(0, itemCount)
            checkBtnState()
        }
    }

    override fun getItemCount() = itemList.size

    fun getSelectedState(): Boolean {
        return itemList.any { it.selectedState == true }
    }

    fun getSelectedTxt(): String {
        return itemList.find { it.selectedState == true }!!.text
    }
}

data class SelectedTxtData(var text: String, var selectedState: Boolean? = false)