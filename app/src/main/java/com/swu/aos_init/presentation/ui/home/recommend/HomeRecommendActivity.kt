package com.swu.aos_init.presentation.ui.home.recommend

import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityHomeRecommendBinding
import com.swu.aos_init.presentation.base.BaseActivity

class HomeRecommendActivity :
    BaseActivity<ActivityHomeRecommendBinding>(R.layout.activity_home_recommend) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBackBtn()
    }

    private fun initBackBtn() {
        binding.ivBackBtn.setOnClickListener {
            finish()
        }
    }
}