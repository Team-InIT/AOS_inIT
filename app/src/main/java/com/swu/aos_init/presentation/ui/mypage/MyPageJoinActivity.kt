package com.swu.aos_init.presentation.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.data.response.mypage.ResponseMyPageJoin
import com.swu.aos_init.data.response.mypage.ResponseMyPageZzim
import com.swu.aos_init.databinding.ActivityMyPageJoinBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageJoinAdapter
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageZzimAdapter

class MyPageJoinActivity : BaseActivity<ActivityMyPageJoinBinding>(R.layout.activity_my_page_join) {

    private lateinit var joinAdapter: MyPageJoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRvAdapter()
        initSetting()
        backBtnListener()
    }

    private fun initSetting() {
        binding.tvMypageJoinIng.isSelected = true

        binding.tvMypageJoinIng.setOnClickListener {
            binding.tvMypageJoinIng.isSelected = true
            binding.tvMypageJoinFinish.isSelected = false
            initRvAdapter()
        }

        binding.tvMypageJoinFinish.setOnClickListener {
            binding.tvMypageJoinIng.isSelected = false
            binding.tvMypageJoinFinish.isSelected = true
            initRvAdapter()
        }
    }


    // 더미 연결
    private fun initRvAdapter() {
        joinAdapter = MyPageJoinAdapter()
        binding.rvMypageJoin.adapter = joinAdapter
        joinAdapter.submitList(
            listOf(
                ResponseMyPageJoin(
                    "모바일",
                    "[inIT] 안드로이드 개발자 모집",
                    "기획자 2/2  ･  디자이너  3/3  ･  개발자 3/5",
                    "2022.12.15 ~ 2023.04.15",
                    "D-2"
                )
            )
        )
    }

    //뒤로가기
    private fun backBtnListener() {
        binding.ivMypageJoinBack.setOnClickListener {
            finish()
        }
    }
}