package com.swu.aos_init.presentation.ui.home.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityCheckApplicantBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.home.project.adapter.ApplicantTabAdapter

class CheckApplicantActivity : BaseActivity<ActivityCheckApplicantBinding>(R.layout.activity_check_applicant) {
    private lateinit var partnerTabAdapter: ApplicantTabAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        initTab()
    }

    private fun initAdapter() {
        val fragmentList = listOf(
            PlanFragment(),
            DesignFragment(),
            DevelopFragment()

        )

        partnerTabAdapter = ApplicantTabAdapter(this)
        partnerTabAdapter.fragments.addAll(fragmentList)

        binding.vpPartnerTab.offscreenPageLimit = partnerTabAdapter.itemCount
        binding.vpPartnerTab.adapter = partnerTabAdapter
    }

    private fun initTab() {
        val tabLabel = listOf("기획", "디자인", "개발")
        TabLayoutMediator(binding.tlPartnerTab, binding.vpPartnerTab) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }
}