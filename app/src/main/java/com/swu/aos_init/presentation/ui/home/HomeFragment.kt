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
                "런칭까지 함께 달리실 팀원들 구해봅니다!",
                "기획자 1/2 ･ 디자이너  3/3  ･ 개발자 9/9",
                "2022.11.25 ~ 2022.12.09",
                "D+3"
            ), ResponseProject(
                "애플리케이션",
                "단기간 사이트 프로젝트 참여자 모집",
                "기획자 2/2  ･  디자이너  2/3  ･  개발자 2/2",
                "2022.11.28 ~ 2022.01.29",
                "D-DAY"
            ), ResponseProject(
                "애플리케이션",
                "태양 컴퍼니 자사 앱 개발자",
                "개발자 2/2",
                "2022.12.01 ~ 2022.02.11",
                "D-4"
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
                    "학습관리 시스템 플랫폼",
                    "기획자 1/1  ･  디자이너  2/2  ･  개발자 3/8",
                    "2022.11.28 ~ 2022.12.09",
                    "D-DAY"
                ),
                ResponseProject(
                    "애플리케이션",
                    "반려식물 라이프 스타일 플랫폼",
                    "기획자 1/2  ･  디자이너  2/4  ･  개발자 2/2",
                    "2022.11.28 ~ 2022.01.29",
                    "D-DAY"
                ),
                ResponseProject(
                    "애플리케이션",
                    "신박한 다이어리 앱, 플레이스토어 런칭까지 도전하실 분",
                    "기획자 1/2  ･  디자이너  2/4  ･  개발자 2/2",
                    "2022.11.29 ~ 2022.02.11",
                    "D-1"
                ),
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