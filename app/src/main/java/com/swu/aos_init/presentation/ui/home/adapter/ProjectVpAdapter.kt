package com.swu.aos_init.presentation.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.data.response.ResponseProject
import com.swu.aos_init.databinding.ItemBelongProjectBinding

class ProjectVpAdapter(private val itemList:MutableList<ResponseProject>,val myContext: Context):RecyclerView.Adapter<ProjectVpAdapter.ProjectVPHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectVPHolder {
        val binding = ItemBelongProjectBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProjectVPHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectVPHolder, position: Int) {
        holder.bind(itemList[position])

        // 프로젝트 정보 보기 화면으로 이동
        /*holder.binding.root.setOnClickListener {
            val nextIntent = Intent(myContext, ProjectDetailActivity::class.java)
            nextIntent.putExtra("pNum",itemList[holder.adapterPosition].pNum)
            nextIntent.putExtra("mNum",itemList[holder.adapterPosition].mNum)
            // readIntent.putExtra("noticeId",itemList[holder.adapterPosition].noticeId)
            (context as Activity).startActivity(nextIntent)
        }*/
    }

    override fun getItemCount(): Int = itemList.size

    class ProjectVPHolder(var binding:ItemBelongProjectBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data:ResponseProject){
            binding.projectData = data
        }
    }
}