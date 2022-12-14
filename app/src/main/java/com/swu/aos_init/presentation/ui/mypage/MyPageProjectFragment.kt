package com.swu.aos_init.presentation.ui.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentMyPageProjectBinding
import com.swu.aos_init.presentation.base.BaseFragment

class MyPageProjectFragment : BaseFragment<FragmentMyPageProjectBinding>(R.layout.fragment_my_page_project) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickListener()
    }

    private fun clickListener() {
        binding.clMyPageHeart.setOnClickListener {
            startActivity(Intent(requireActivity(), MyPageZzimActivity::class.java))
        }

        binding.clMyPageUpload.setOnClickListener {
            startActivity(Intent(requireActivity(), MyPageUploadActivity::class.java))
        }

        binding.clMyPageApprove.setOnClickListener {
            startActivity(Intent(requireActivity(), MyPageWaitActivity::class.java))
        }

        binding.clMyPageJoin.setOnClickListener {
            startActivity(Intent(requireActivity(), MyPageJoinActivity::class.java))
        }
    }
}