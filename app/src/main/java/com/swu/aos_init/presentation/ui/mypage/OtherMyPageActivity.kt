package com.swu.aos_init.presentation.ui.mypage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityOtherMyPageBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.OtherPageTabAdapter

class OtherMyPageActivity: BaseActivity<ActivityOtherMyPageBinding>(R.layout.activity_other_my_page) {
    private lateinit var myPageTabAdapter: OtherPageTabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        initTab()
        settingBtnListener()

    }
    //tab layout adapter
    private fun initAdapter() {
        val fragmentList = listOf(
            MyPageInfoFragment(),
            MyPageProjectFragment(),
            MyPageFeedFragment(),
        )
        myPageTabAdapter = OtherPageTabAdapter(this@OtherMyPageActivity)
        myPageTabAdapter.fragments.addAll(fragmentList)


        binding.vpHome.adapter = myPageTabAdapter

    }

    private fun initTab() {
        val tabLabel = listOf("정보", "프로젝트", "피드")
        TabLayoutMediator(binding.tabHome, binding.vpHome) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }

    private fun settingBtnListener() {
        binding.ivMypageSetting.setOnClickListener {
            val intentSetting = Intent(this, MyPageSettingActivity::class.java)
            startActivity(intentSetting)
        }
    }
}