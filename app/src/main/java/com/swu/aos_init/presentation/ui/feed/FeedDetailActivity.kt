package com.swu.aos_init.presentation.ui.feed

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityFeedDetailBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.home.project.CheckApplicantActivity
import com.swu.aos_init.presentation.ui.mypage.other.OtherMyPageActivity

class FeedDetailActivity : BaseActivity<ActivityFeedDetailBinding>(R.layout.activity_feed_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBackBtn()
        setAddCommentEvent()
        OtherPageListener()
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

    private fun OtherPageListener() {
        binding.layoutTeamInfo.textView20.setOnClickListener {
            val intentSetting = Intent(this, OtherMyPageActivity::class.java)
            startActivity(intentSetting)
        }
    }

}