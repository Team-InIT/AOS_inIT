package com.swu.aos_init.presentation.ui.feed

import KindBottomSheet
import TypeBottomSheet
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        moveToFeedWrite()
        initBottomSheetEvent()
    }

    // TODO: 추후 서버 통신 진행 예정
    private fun initAdapter() {
        feedAdapter = FeedAdapter()

        feedAdapter.submitList(
            listOf(
                ResponseFeed(
                    "플투",
                    "대학교 및 소모임 단위의 번개 매칭 서비스",
                    "#android #kotlin #MVVM"
                ),
                ResponseFeed(
                    "플투",
                    "대학교 및 소모임 단위의 번개 매칭 서비스",
                    "#android #kotlin #MVVM"
                ),
                ResponseFeed(
                    "플투",
                    "대학교 및 소모임 단위의 번개 매칭 서비스",
                    "#android #kotlin #MVVM"
                ), ResponseFeed(
                    "플투",
                    "대학교 및 소모임 단위의 번개 매칭 서비스",
                    "#android #kotlin #MVVM"
                ), ResponseFeed(
                    "플투",
                    "대학교 및 소모임 단위의 번개 매칭 서비스",
                    "#android #kotlin #MVVM"
                ), ResponseFeed(
                    "플투",
                    "대학교 및 소모임 단위의 번개 매칭 서비스",
                    "#android #kotlin #MVVM"
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
            TechBottomSheet(list){}.show(parentFragmentManager, "STACK_SHEET")
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

    private fun setFilter() {
        binding.tvProjectKind.isSelected = kindState
        binding.tvProjectType.isSelected = typeState
        binding.tvProjectStack.isSelected = stackState

        binding.ivFilter.isSelected = kindState || typeState || stackState
    }
}