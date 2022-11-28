package com.swu.aos_init.presentation.ui.home.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityProjectDetailBinding
import com.swu.aos_init.presentation.base.BaseActivity

class ProjectDetailActivity : BaseActivity<ActivityProjectDetailBinding>(R.layout.activity_project_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        backBtnListener()
        likeBtnListener()
    }

    private fun backBtnListener() {
        binding.ivOpenProjectBack.setOnClickListener {
            finish()
        }
    }

    private fun likeBtnListener() {
        binding.ivProjectDetailHeart.setOnClickListener {
            binding.ivProjectDetailHeart.isSelected = !binding.ivProjectDetailHeart.isSelected
        }
    }

    private fun applyBtnListener() {
        binding.btnFinish.setOnClickListener {

        }
    }
}