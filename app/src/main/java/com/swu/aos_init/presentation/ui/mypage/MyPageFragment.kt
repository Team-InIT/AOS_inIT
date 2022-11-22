package com.swu.aos_init.presentation.ui.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentMypageBinding
import com.swu.aos_init.presentation.base.BaseFragment

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    private lateinit var myPageTabAdapter: MyPageTabAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        myPageTabAdapter = MyPageTabAdapter(this)
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
            val intentSetting = Intent(requireActivity(), MyPageSettingActivity::class.java)
            startActivity(intentSetting)
        }
    }
}