package com.swu.aos_init.presentation.ui.feed

import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityFeedDetailBinding
import com.swu.aos_init.presentation.base.BaseActivity

class FeedDetailActivity : BaseActivity<ActivityFeedDetailBinding>(R.layout.activity_feed_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBackBtn()
        setAddCommentEvent()
    }

    private fun initBackBtn() {
        binding.ivOpenProjectBack.setOnClickListener {
            finish()
        }
    }

    private fun setAddCommentEvent() {
        binding.ivCommentBtn.setOnClickListener {

        }
    }

}