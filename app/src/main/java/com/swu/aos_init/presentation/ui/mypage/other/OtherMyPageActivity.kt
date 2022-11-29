package com.swu.aos_init.presentation.ui.mypage.other

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityOtherMyPageBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.MyPageFeedFragment
import com.swu.aos_init.presentation.ui.mypage.MyPageInfoFragment
import com.swu.aos_init.presentation.ui.mypage.MyPageProjectFragment
import com.swu.aos_init.presentation.ui.mypage.MyPageSettingActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.OtherPageTabAdapter

class OtherMyPageActivity: BaseActivity<ActivityOtherMyPageBinding>(R.layout.activity_other_my_page) {
    private lateinit var myPageTabAdapter: OtherPageTabAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        initTab()
        settingBtnListener()
        backBtnListener()
        connectClickListener()

    }
    //tab layout adapter
    private fun initAdapter() {
        val fragmentList = listOf(
            OtherPageInfoFragment(),
            MyPageProjectFragment(),
            MyPageFeedFragment(),
        )
        myPageTabAdapter = OtherPageTabAdapter(this@OtherMyPageActivity)
        myPageTabAdapter.fragments.addAll(fragmentList)


        binding.vpHome.adapter = myPageTabAdapter

    }

    private fun backBtnListener() {
        binding.ivOpenProjectBack.setOnClickListener {
            finish()
        }
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

    private fun connectClickListener() {
        binding.tvMyPageModifyProfile.setOnClickListener {
            val url = "https://mail.naver.com/v2/new"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}