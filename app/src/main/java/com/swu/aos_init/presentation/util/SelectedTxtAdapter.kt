package com.swu.aos_init.presentation.util

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.databinding.ItemBottomSheetDefaultListBinding

class SelectedTxtAdapter(val doAfterClick: () -> Unit) :
    RecyclerView.Adapter<SelectedTxtAdapter.SelectedTxtViewHolder>() {

    var itemList = mutableListOf<SelectedTxtData>()

    class SelectedTxtViewHolder(private val binding: ItemBottomSheetDefaultListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val textView: TextView = binding.itemTvBottomSheetDefault

        fun onBind(data: SelectedTxtData) {
            binding.selectedTxtData = data
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
            if (!holder.textView.isSelected) {
                setAllViewOff()
                holder.textView.isSelected = true
            } else {
                setAllViewOff()
            }

            doAfterClick()
        }
    }

    override fun getItemCount() = itemList.size

    private fun setAllViewOff() {
        itemList.forEach { it.selectedState = false }
        notifyItemRangeChanged(0, itemCount)
    }

    fun getSelectedTxt(): String {
        return itemList.find { it.selectedState == true }!!.text
    }
}

data class SelectedTxtData(var text: String, var selectedState: Boolean? = false)