package com.swu.aos_init.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseProject
import com.swu.aos_init.databinding.FragmentHomeBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.home.adapter.ProjectAdapter
import com.swu.aos_init.presentation.ui.home.recommend.HomeRecommendActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var projectAdapter:ProjectAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initShowAllEvent()
    }

    // 더미 연결
    private fun initAdapter() {
        projectAdapter = ProjectAdapter()

        // TODO 추후 서버통신 시 3개의 데이터만 잘라서 받아오기
        projectAdapter.submitList(
            listOf(
                ResponseProject(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                ), ResponseProject(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                ), ResponseProject(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                )
            )
        )

        binding.rvRecommendProject.adapter = projectAdapter
    }

    private fun initShowAllEvent() {
        binding.tvShowAll.setOnClickListener {
            startActivity(Intent(requireContext(), HomeRecommendActivity::class.java))
        }
    }
}