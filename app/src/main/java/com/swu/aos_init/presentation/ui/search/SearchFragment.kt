package com.swu.aos_init.presentation.ui.search

import android.os.Bundle
import android.view.View
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseProject
import com.swu.aos_init.databinding.FragmentSearchBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.home.adapter.ProjectRvAdapter

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private lateinit var projectRvAdapter: ProjectRvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    // 더미 연결
    private fun initAdapter() {
        projectRvAdapter = ProjectRvAdapter()

        // TODO 추후 서버통신 시 3개의 데이터만 잘라서 받아오기
        projectRvAdapter.submitList(
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

        binding.rvSearchProject.adapter = projectRvAdapter
    }
}