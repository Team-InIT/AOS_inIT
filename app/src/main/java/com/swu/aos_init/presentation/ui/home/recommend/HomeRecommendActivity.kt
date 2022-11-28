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
                ResponseProject(
                    "애플리케이션",
                    "외주 개발자 안드로이드 2명 모집",
                    "개발자 2/2",
                    "2022.11.28 ~ 2022.01.29",
                    "D-DAY"
                ),
                ResponseProject(
                    "애플리케이션",
                    "MVVM 구조 연습 겸 사이드 프로젝트 같이 하실 분?",
                    "개발자 1/2",
                    "2022.11.29 ~ 2022.02.11",
                    "D-1"
                ),
                ResponseProject(
                    "애플리케이션",
                    "[투두리스트 어플] 기획은 현재 거의 완성 단계입니다",
                    "디자이너  2/4  ･  개발자 3/5",
                    "2022.11.30 ~ 2022.12.09",
                    "D-3"
                ),
                ResponseProject(
                    "애플리케이션",
                    "연습장 라이브러리 사용 / 그림판 앱 / 개발자 모집",
                    "디자이너  4/4  ･  개발자 0/3",
                    "2022.11.30 ~ 2022.12.09",
                    "D-3"
                ),
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