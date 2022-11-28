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
                    "애플리케이션",
                    "학습관리 시스템 플랫폼",
                    "기획자 1/1  ･  디자이너  2/2  ･  개발자 3/8",
                    "2022.11.28 ~ 2022.12.09",
                    "D-Day"
                ),
                ResponseProject(
                    "퍼블리싱",
                    "태양 컴퍼니 웹 페이지 & 어드민 페이지 개선 작업",
                    "기획자 1/2  ･  디자이너  2/4  ･  개발자 2/2",
                    "2022.11.28 ~ 2022.01.29",
                    "D-Day"
                ),
                ResponseProject(
                    "웹",
                    "태양 컴퍼니 자사 홈페이지 web 개발자",
                    "개발자 1/2",
                    "2022.11.29 ~ 2022.02.11",
                    "D-1"
                ),
                ResponseProject(
                    "커머스,쇼핑몰",
                    "쇼핑 이커머스 플랫폼 개발에 참여하실 분",
                    "디자이너  2/4  ･  개발자 3/5",
                    "2022.11.30 ~ 2022.12.09",
                    "D-3"
                ),
                ResponseProject(
                    "웹",
                    "프리랜서 경력관리 플랫폼 서비스",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.12.01 ~ 2022.12.31",
                    "D-4"
                ),
                ResponseProject(
                    "웹",
                    "네이버 해커톤 같이 팀 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.01.09 ~ 2022.01.12",
                    "D-43"
                ),
            )
        )

        binding.rvSearchProject.adapter = projectRvAdapter
    }
}