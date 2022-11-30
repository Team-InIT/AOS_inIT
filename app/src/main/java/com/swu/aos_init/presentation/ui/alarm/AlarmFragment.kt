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
                ResponseAlarm(R.drawable.ic_support_project, "왕준님께서 내 프로젝트 플투에 지원하셨습니다.", "2022.04.28 오후 2: 28"),
                ResponseAlarm(R.drawable.ic_support_project, "김윤정님께서 내 프로젝트 플투에 지원하셨습니다.", "2022.04.29 오후 6: 01"),
                ResponseAlarm(R.drawable.ic_add_comment, "김하민님께서 내 피드 플투에 댓글을 남기셨습니다.", "2022.11.28 오전 12: 57"),
                ResponseAlarm(R.drawable.ic_add_comment, "송소라님께서 내 피드 플투에 댓글을 남기셨습니다.", "2022.11.29 오전 2: 01"),
                ResponseAlarm(R.drawable.ic_add_comment, "하민희님께서 내 피드 플투에 댓글을 남기셨습니다.", "2022.11.30 오후 8: 48=1"),
                ResponseAlarm(R.drawable.ic_approve_project, "신청하신 [inIT] 안드로이드 서비스 기획자 모집\n" +
                        "프로젝트에 승인되었습니다", "2022.12.1 오후 6: 01"),

            )
        )

    }
}