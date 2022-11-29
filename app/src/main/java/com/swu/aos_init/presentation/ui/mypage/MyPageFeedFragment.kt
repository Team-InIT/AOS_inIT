package com.swu.aos_init.presentation.ui.mypage

import android.os.Bundle
import android.view.View
import com.swu.aos_init.R
import com.swu.aos_init.data.response.mypage.ResponseMyPageFeed
import com.swu.aos_init.databinding.FragmentMyPageFeedBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.mypage.adapter.FeedAdapter


class MyPageFeedFragment : BaseFragment<FragmentMyPageFeedBinding>(R.layout.fragment_my_page_feed) {

    private lateinit var feedAdapter: FeedAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectAdapter()

    }

    private fun connectAdapter() {
        feedAdapter = FeedAdapter()
        binding.rvFeed.adapter = feedAdapter
        feedAdapter.submitList(
            listOf(
                ResponseMyPageFeed(R.drawable.img_app_nadosunbae, "나도선배"),
                ResponseMyPageFeed(R.drawable.img_app_playtogether, "플투"),
            )
        )
    }
}