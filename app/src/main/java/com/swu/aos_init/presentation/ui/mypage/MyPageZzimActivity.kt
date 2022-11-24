package com.swu.aos_init.presentation.ui.mypage

import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.data.response.mypage.ResponseMyPageZzim
import com.swu.aos_init.databinding.ActivityMyPageZzimBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageZzimAdapter

class MyPageZzimActivity : BaseActivity<ActivityMyPageZzimBinding>(R.layout.activity_my_page_zzim) {

    private lateinit var zzimAdapter: MyPageZzimAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRvAdapter()
        backBtnListener()
    }

    // 더미 연결
    private fun initRvAdapter() {
        zzimAdapter = MyPageZzimAdapter()
        binding.rvMypageZzim.adapter = zzimAdapter
        zzimAdapter.submitList(
            listOf(
                ResponseMyPageZzim(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                ), ResponseMyPageZzim(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                ), ResponseMyPageZzim(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                )
            )
        )
    }

    //뒤로가기
    private fun backBtnListener() {
        binding.ivMypageZzimBack.setOnClickListener {
            finish()
        }
    }
}