package com.swu.aos_init.presentation.ui.home.recommend

import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseProject
import com.swu.aos_init.databinding.ActivityHomeRecommendBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.home.adapter.ProjectRvAdapter

// TODO 추후 서버통신 진행예정
// TODO 추후 서버통신을 위한 data class 변경 예정
// TODO 추후 화면 클릭이벤트 구현 예정
class HomeRecommendActivity :
    BaseActivity<ActivityHomeRecommendBinding>(R.layout.activity_home_recommend) {

    private lateinit var projectRvAdapter: ProjectRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initAdapter()
        initBackBtn()
    }

    // 더미 연결
    private fun initAdapter() {
        projectRvAdapter = ProjectRvAdapter()
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
                ), ResponseProject(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                )
            )
        )

        binding.rvRecommendProject.adapter = projectRvAdapter
    }

    private fun initBackBtn() {
        binding.ivBackBtn.setOnClickListener {
            finish()
        }
    }
}