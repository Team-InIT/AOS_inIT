package com.swu.aos_init.presentation.ui.feed.write

import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityWriteFeedBinding
import com.swu.aos_init.presentation.base.BaseActivity

class WritingFeedActivity : BaseActivity<ActivityWriteFeedBinding>(R.layout.activity_write_feed) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBackBtn()
    }

    private fun initBackBtn() {
        binding.ivOpenFeedBack.setOnClickListener {
            finish()
        }
    }
}