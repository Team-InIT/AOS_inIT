package com.swu.aos_init.presentation.ui.home.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swu.aos_init.data.response.ResponseProject
import com.swu.aos_init.databinding.ItemProjectBinding
import com.swu.aos_init.presentation.ui.home.project.ProjectDetailActivity

class ProjectRvAdapter : ListAdapter<ResponseProject, ProjectRvAdapter.ProjectViewAdapter>(
    homeDiffUtil
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewAdapter {
        val binding =
            ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectViewAdapter(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewAdapter, position: Int) {
        holder.onBind(getItem(position))
        val context = holder.itemView.context
        holder.binding.root.setOnClickListener {
            val intent = Intent(context, ProjectDetailActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context,intent, null)
        }
    }

    class ProjectViewAdapter(val binding: ItemProjectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseProject) {
            binding.projectData = data
        }
    }

    companion object {
        private val homeDiffUtil = object : DiffUtil.ItemCallback<ResponseProject>() {
            override fun areItemsTheSame(
                oldItem: ResponseProject,
                newItem: ResponseProject
            ): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(
                oldItem: ResponseProject,
                newItem: ResponseProject
            ): Boolean =
                oldItem == newItem
        }
    }
}