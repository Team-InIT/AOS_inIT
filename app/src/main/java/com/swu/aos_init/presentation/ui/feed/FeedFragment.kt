package com.swu.aos_init.presentation.ui.feed

import KindBottomSheet
import TypeBottomSheet
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.swu.aos_init.R
import com.swu.aos_init.data.response.feed.ResponseFeed
import com.swu.aos_init.databinding.FragmentFeedBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.feed.adapter.FeedAdapter
import com.swu.aos_init.presentation.ui.feed.bottomsheet.TechBottomSheet
import com.swu.aos_init.presentation.ui.feed.write.WritingFeedActivity

class FeedFragment : BaseFragment<FragmentFeedBinding>(R.layout.fragment_feed),
    KindBottomSheet.BottomSheetClickListener,
    TypeBottomSheet.BottomSheetClickListener {

    private val feedViewModel: FeedViewModel by viewModels()

    private lateinit var feedAdapter: FeedAdapter

    private var kindState: Boolean = false
    private var typeState: Boolean = false
    private var stackState: Boolean = false

    private var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        moveToFeedWrite()
        initBottomSheetEvent()
        initAdapter()
    }

    // TODO: 추후 서버 통신 진행 예정
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initAdapter() {
        feedAdapter = FeedAdapter(requireContext())

        feedAdapter.submitList(
            listOf(
                ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_init, null),
                    "인잇",
                    "기업의 인재 탐색 활용이 가능한 IT 프로젝트 커뮤니티 중개 서비스",
                    "#android #kotlin #MVVM"
                ),
                ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_mument, null),
                    "뮤멘트",
                    "음악 감상을 손쉽게 기록하고, 다시 꺼내보고, 새롭게 발견하는 서비스",
                    "#mutiModule #kotlin #MVVM"
                ),
                ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_playtogether, null),
                    "플투",
                    "대학교 및 소모임 단위의 번개 매칭 서비스",
                    "#android #kotlin #MVVM"
                ), ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_albazip, null),
                    "알바집",
                    "알바생 근태관리 어플",
                    "#firebase #kotlin #MVP"
                ), ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_zutdae, null),
                    "줏대",
                    "물음표로 시작하여 마침표로 끝나는 줏대 세우기 여정",
                    "#android #kotlin #MVC #SQL"
                ), ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_woorido, null),
                    "우리도",
                    "참여도 점수를 매겨 모임 점수 랭킹을 매기는 어플",
                    "#multipart #kotlin #MVC"
                ), ResponseFeed(
                    resources.getDrawable(R.drawable.ic_project_recordream, null),
                    "레코드림",
                    "가상 직후의 꿈 기록과 관리를 돕는 '꿈 기록 아카이빙 서비스",
                    "#android #kotlin #MVC"
                ), ResponseFeed(
                    resources.getDrawable(R.drawable.img_project_charo, null),
                    "차로",
                    "차에서의 오늘이 최고가 될 수 있게, 당신의 드라이브메이트 차로",
                    "#navigationComponent #kotlin #MVVM"
                ), ResponseFeed(
                    resources.getDrawable(R.drawable.img_project_modem, null),
                    "모듬",
                    "어두운 환경을 밝혀주는 손전등 어플",
                    "#BuiltIn #kotlin #MVVM"
                )
            )
        )

        binding.rvFeed.adapter = feedAdapter
    }

    private fun moveToFeedWrite() {
        binding.ivAddFeed.setOnClickListener {
            startActivity(Intent(requireContext(), WritingFeedActivity::class.java))
        }
    }

    private fun initBottomSheetEvent() {

        binding.tvProjectKind.setOnClickListener {
            val kindList = feedViewModel.kindFilterList.value
            KindBottomSheet(kindList).show(childFragmentManager, "KIND_SHEET")
        }

        binding.tvProjectType.setOnClickListener {
            val typeList = feedViewModel.typeFilterList.value
            TypeBottomSheet(typeList).show(childFragmentManager, "TYPE_SHEET")
        }

        binding.tvProjectStack.setOnClickListener {
            val list = feedViewModel.stackFilterList
            TechBottomSheet(list) { setTechState() }.show(parentFragmentManager, "STACK_SHEET")
        }
    }

    override fun getSelectedKindList(selectedFilter: MutableList<Int>) {
        feedViewModel.setKindFilter(selectedFilter)
        kindState = !selectedFilter.isEmpty()
        setFilter()
    }

    override fun getSelectedTypeList(selectedFilter: MutableList<Int>) {
        feedViewModel.setTypeFilter(selectedFilter)
        typeState = !selectedFilter.isEmpty()
        setFilter()
    }

    private fun setTechState() {
        stackState = true

        binding.rvFeed.itemAnimator = null
        feedAdapter.submitList(
            listOf(
                ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_nadosunbae, null),
                    "나도선배",
                    "제2전공생을 위한 학과 후기, 전공 정보 공유 플랫폼",
                    "#MVVM #FIGMA #GITHUB #FLOW"
                ),
                ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_init, null),
                    "인잇",
                    "기업의 인재 탐색 활용이 가능한 IT 프로젝트 커뮤니티 중개 서비스",
                    "#android #kotlin #MVVM"
                ),
                ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_mument, null),
                    "뮤멘트",
                    "음악 감상을 손쉽게 기록하고, 다시 꺼내보고, 새롭게 발견하는 서비스",
                    "#mutiModule #kotlin #MVVM"
                ),
                ResponseFeed(
                    resources.getDrawable(R.drawable.img_app_playtogether, null),
                    "플투",
                    "대학교 및 소모임 단위의 번개 매칭 서비스",
                    "#android #kotlin #MVVM"
                ),ResponseFeed(
                    resources.getDrawable(R.drawable.img_project_charo, null),
                    "차로",
                    "차에서의 오늘이 최고가 될 수 있게, 당신의 드라이브메이트 차로",
                    "#navigationComponent #kotlin #MVVM"
                ), ResponseFeed(
                    resources.getDrawable(R.drawable.img_project_modem, null),
                    "모듬",
                    "어두운 환경을 밝혀주는 손전등 어플",
                    "#BuiltIn #kotlin #MVVM"
                )
            )
        )

        setFilter()
    }

    private fun setFilter() {
        binding.tvProjectKind.isSelected = kindState
        binding.tvProjectType.isSelected = typeState
        binding.tvProjectStack.isSelected = stackState

        binding.ivFilter.isSelected = kindState || typeState || stackState
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onResume() {
        super.onResume()

        count++
        if (count == 2) {
            feedAdapter.submitList(
                listOf(
                    ResponseFeed(
                        resources.getDrawable(R.drawable.img_app_nadosunbae, null),
                        "나도선배",
                        "제2전공생을 위한 학과 후기, 전공 정보 공유 플랫폼",
                        "#MVVM #FIGMA #GITHUB #FLOW"
                    ),
                    ResponseFeed(
                        resources.getDrawable(R.drawable.img_app_init, null),
                        "인잇",
                        "기업의 인재 탐색 활용이 가능한 IT 프로젝트 커뮤니티 중개 서비스",
                        "#android #kotlin #MVVM"
                    ),
                    ResponseFeed(
                        resources.getDrawable(R.drawable.img_app_mument, null),
                        "뮤멘트",
                        "음악 감상을 손쉽게 기록하고, 다시 꺼내보고, 새롭게 발견하는 서비스",
                        "#mutiModule #kotlin #MVVM"
                    ),
                    ResponseFeed(
                        resources.getDrawable(R.drawable.img_app_playtogether, null),
                        "플투",
                        "대학교 및 소모임 단위의 번개 매칭 서비스",
                        "#android #kotlin #MVVM"
                    ), ResponseFeed(
                        resources.getDrawable(R.drawable.img_app_albazip, null),
                        "알바집",
                        "알바생 근태관리 어플",
                        "#firebase #kotlin #MVP"
                    ), ResponseFeed(
                        resources.getDrawable(R.drawable.img_app_zutdae, null),
                        "줏대",
                        "물음표로 시작하여 마침표로 끝나는 줏대 세우기 여정",
                        "#android #kotlin #MVC #SQL"
                    ), ResponseFeed(
                        resources.getDrawable(R.drawable.img_app_woorido, null),
                        "우리도",
                        "참여도 점수를 매겨 모임 점수 랭킹을 매기는 어플",
                        "#multipart #kotlin #MVC"
                    ), ResponseFeed(
                        resources.getDrawable(R.drawable.ic_project_recordream, null),
                        "레코드림",
                        "가상 직후의 꿈 기록과 관리를 돕는 '꿈 기록 아카이빙 서비스",
                        "#android #kotlin #MVC"
                    ), ResponseFeed(
                        resources.getDrawable(R.drawable.img_project_charo, null),
                        "차로",
                        "차에서의 오늘이 최고가 될 수 있게, 당신의 드라이브메이트 차로",
                        "#navigationComponent #kotlin #MVVM"
                    ), ResponseFeed(
                        resources.getDrawable(R.drawable.img_project_modem, null),
                        "모듬",
                        "어두운 환경을 밝혀주는 손전등 어플",
                        "#BuiltIn #kotlin #MVVM"
                    )
                )
            )


        }
    }
}