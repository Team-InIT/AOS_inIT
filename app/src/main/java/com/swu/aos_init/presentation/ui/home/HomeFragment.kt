package com.swu.aos_init.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentHomeBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.home.recommend.HomeRecommendActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initShowAllEvent()
    }

    private fun initShowAllEvent() {
        binding.tvShowAll.setOnClickListener {
            startActivity(Intent(requireContext(), HomeRecommendActivity::class.java))
        }
    }
}