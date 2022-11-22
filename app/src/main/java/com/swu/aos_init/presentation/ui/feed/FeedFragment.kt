package com.swu.aos_init.presentation.ui.feed

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.swu.aos_init.R
import com.swu.aos_init.data.response.feed.ResponseFeed
import com.swu.aos_init.databinding.FragmentFeedBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.feed.adapter.FeedAdapter
import com.swu.aos_init.presentation.ui.feed.bottomsheet.KindBottomSheet
import com.swu.aos_init.presentation.ui.feed.bottomsheet.TypeBottomSheet
import com.swu.aos_init.presentation.ui.feed.write.WritingFeedActivity

class FeedFragment : BaseFragment<FragmentFeedBinding>(R.layout.fragment_feed),TypeBottomSheet.BottomSheetClickListener,KindBottomSheet.BottomSheetClickListener {

    private lateinit var feedAdapter: FeedAdapter

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
        // 종류
        binding.tvProjectKind.setOnClickListener {
            TypeBottomSheet().show(childFragmentManager,"FEED_FILTER_TYPE")
        }

        // 타입
        binding.tvProjectType.setOnClickListener {
            KindBottomSheet().show(childFragmentManager,"FEED_FILTER_KIND")
        }

        // 스택
        binding.tvProjectStack.setOnClickListener {
        }
    }

    override fun getSelectedKindList(selectedFilter: MutableList<Int>) {
        Log.d("kite",selectedFilter.toString())
    }

    override fun getSelectedTypeList(selectedFilter: MutableList<Int>) {
        Log.d("kite",selectedFilter.toString())
    }

}