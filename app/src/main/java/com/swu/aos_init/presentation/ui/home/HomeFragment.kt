package com.swu.aos_init.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.MarginPageTransformer
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseProject
import com.swu.aos_init.databinding.FragmentHomeBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.home.adapter.ProjectRvAdapter
import com.swu.aos_init.presentation.ui.home.adapter.ProjectVpAdapter
import com.swu.aos_init.presentation.ui.home.recommend.HomeRecommendActivity
import com.swu.aos_init.presentation.ui.home.write.WriteProjectActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var projectVpAdapter: ProjectVpAdapter
    private lateinit var projectRvAdapter: ProjectRvAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVpAdapter()
        initRvAdapter()
        initShowAllEvent()
        writeBtnClick()
    }

    private fun initVpAdapter() {
        val itemList = mutableListOf(
            ResponseProject(
                "애플리케이션",
                "학습관리 시스템 플랫폼",
                "기획자 1/1  ･  디자이너  2/2  ･  개발자 3/8",
                "2022.11.28 ~ 2022.12.09",
                "D-Day"
            ), ResponseProject(
                "웹",
                "프리랜서 경력관리 플랫폼 서비스",
                "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                "2022.12.01 ~ 2022.12.31",
                "D-4"
            ), ResponseProject(
                "웹",
                "네이버 해커톤 같이 팀 하실 분 구해요",
                "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                "2022.01.09 ~ 2022.01.12",
                "D-43"
            )
        )
        projectVpAdapter = ProjectVpAdapter(itemList, requireContext())
        binding.vpBelongProject.adapter = projectVpAdapter
        binding.vpBelongProject.setPageTransformer(MarginPageTransformer(20))
        binding.dotsIndicator.attachTo(binding.vpBelongProject)
    }

    // 더미 연결
    private fun initRvAdapter() {
        projectRvAdapter = ProjectRvAdapter()

        // TODO 추후 서버통신 시 3개의 데이터만 잘라서 받아오기
        projectRvAdapter.submitList(
            listOf(
                ResponseProject(
                    "애플리케이션",
                    "쇼핑 이커머스 플랫폼 개발에 참여하실 분",
                    "디자이너  2/4  ･  개발자 3/5",
                    "2022.11.30 ~ 2022.12.09",
                    "D-3"
                ), ResponseProject(
                    "애플리케이션",
                    "태양 컴퍼니 웹 페이지 & 어드민 페이지 개선 작업",
                    "기획자 1/2  ･  디자이너  2/4  ･  개발자 2/2",
                    "2022.11.28 ~ 2022.01.29",
                    "D-Day"
                ), ResponseProject(
                    "애플리케이션",
                    "태양 컴퍼니 자사 홈페이지 web 개발자",
                    "개발자 1/2",
                    "2022.11.29 ~ 2022.02.11",
                    "D-4"
                )
            )
        )

        binding.rvRecommendProject.adapter = projectRvAdapter
    }

    private fun initShowAllEvent() {
        binding.tvShowAll.setOnClickListener {
            startActivity(Intent(requireContext(), HomeRecommendActivity::class.java))
        }
    }


    //글쓰기 뷰 도입
    private fun writeBtnClick() {
        binding.fabWriting.setOnClickListener {
            val intent = Intent(requireActivity(), WriteProjectActivity::class.java)
            startActivity(intent)
        }
    }
}