package com.swu.aos_init.presentation.ui.alarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseAlarm
import com.swu.aos_init.databinding.FragmentAlarmBinding
import com.swu.aos_init.presentation.base.BaseFragment

class AlarmFragment : BaseFragment<FragmentAlarmBinding>(R.layout.fragment_alarm) {

    private lateinit var alarmAdapter: AlarmAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        connectAdapter()
    }

    private fun connectAdapter() {
        alarmAdapter = AlarmAdapter()
        binding.rvAlarm.adapter = alarmAdapter
        alarmAdapter.submitList(
            listOf(
                ResponseAlarm(R.drawable.ic_approve_project, "신청하신 [태양컴퍼니] 안드로이드 개발자 구합니다\n" +
                        "프로젝트에 승인되었습니다", "2022.04.28 오후 6: 01"),
                ResponseAlarm(R.drawable.ic_support_project, "장윤정님께서 내 프로젝트 inIT에 지원하셨습니다.", "2022.04.28 오후 6: 01"),
                ResponseAlarm(R.drawable.ic_add_comment, "정지연님께서 내 피드 나도선배에 댓글을 남기셨습니다.", "2022.04.28 오후 6: 01")
            )
        )

    }
}