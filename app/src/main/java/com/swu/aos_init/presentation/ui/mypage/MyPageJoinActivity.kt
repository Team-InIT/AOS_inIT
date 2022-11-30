package com.swu.aos_init.presentation.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.data.response.mypage.ResponseMyPageJoin
import com.swu.aos_init.data.response.mypage.ResponseMyPageZzim
import com.swu.aos_init.databinding.ActivityMyPageJoinBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageJoinAdapter
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageJoinedAdapter
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageZzimAdapter

class MyPageJoinActivity : BaseActivity<ActivityMyPageJoinBinding>(R.layout.activity_my_page_join) {

    private lateinit var joinAdapter: MyPageJoinAdapter
    private lateinit var joinedAdapter: MyPageJoinedAdapter

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
            initRvedAdapter()
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
                    "[나도선배] 안드로이드 기획자 모집",
                    "기획자 3/3  ･  디자이너  3/3  ･  개발자 8/8",
                    "2022.1.05 ~ 2022.12.12",
                    "D+328"
                )
            )
        )
    }

    // 더미 연결
    private fun initRvedAdapter() {
        joinedAdapter = MyPageJoinedAdapter()
        binding.rvMypageJoin.adapter = joinAdapter
        joinAdapter.submitList(
            listOf(
                ResponseMyPageJoin(
                    "모바일",
                    "[플투] 안드로이드 PM 모집",
                    "기획자 2/2  ･  디자이너  3/3  ･  개발자 12/12",
                    "2022.4.05 ~ 2022.8.12",
                    "D+156"
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