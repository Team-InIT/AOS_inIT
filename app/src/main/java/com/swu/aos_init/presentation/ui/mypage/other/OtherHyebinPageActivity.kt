package com.swu.aos_init.presentation.ui.mypage.other

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityHyebinMyPageBinding
import com.swu.aos_init.databinding.ActivityOtherMyPageBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.MyPageFeedFragment
import com.swu.aos_init.presentation.ui.mypage.MyPageInfoFragment
import com.swu.aos_init.presentation.ui.mypage.MyPageProjectFragment
import com.swu.aos_init.presentation.ui.mypage.MyPageSettingActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.OtherHyebinPageTabAdapter
import com.swu.aos_init.presentation.ui.mypage.adapter.OtherPageTabAdapter

class OtherHyebinPageActivity: BaseActivity<ActivityHyebinMyPageBinding>(R.layout.activity_hyebin_my_page) {
    private lateinit var myPageTabAdapter: OtherHyebinPageTabAdapter

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
            MyPageInfoFragment(),
            MyPageProjectFragment(),
            MyPageFeedFragment(),
        )
        myPageTabAdapter = OtherHyebinPageTabAdapter(this@OtherHyebinPageActivity)
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

    }

    private fun connectClickListener() {
        binding.tvMyPageModifyProfile.setOnClickListener {
            val url = "https://mail.naver.com/v2/new"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}