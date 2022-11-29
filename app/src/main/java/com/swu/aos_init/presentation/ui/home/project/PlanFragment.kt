package com.swu.aos_init.presentation.ui.home.project

import android.os.Bundle
import android.view.View
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseApplicant
import com.swu.aos_init.databinding.FragmentPlanBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.home.project.adapter.PartnerPlanAdapter

class PlanFragment : BaseFragment<FragmentPlanBinding>(R.layout.fragment_plan) {
    private lateinit var partnerPlanAdapter: PartnerPlanAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectAdapter()
    }

    private fun connectAdapter() {
        partnerPlanAdapter = PartnerPlanAdapter()
        binding.rvApprovePlan.adapter = partnerPlanAdapter
        partnerPlanAdapter.submitList(
            listOf(
                ResponseApplicant(R.drawable.img_person6, "박신우","park98@gmail.com"),
                ResponseApplicant(R.drawable.img_person4, "이민주","min123@gmail.com")
            )
        )

    }
}
