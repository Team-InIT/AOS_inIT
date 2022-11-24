package com.swu.aos_init.presentation.ui.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.data.response.mypage.ResponseMyPageWait
import com.swu.aos_init.data.response.mypage.ResponseMyPageZzim
import com.swu.aos_init.databinding.ActivityMyPageWaitBinding
import com.swu.aos_init.databinding.ActivityMyPageZzimBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageWaitAdapter
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageZzimAdapter

class MyPageWaitActivity : BaseActivity<ActivityMyPageWaitBinding>(R.layout.activity_my_page_wait) {

    private lateinit var waitAdapter: MyPageWaitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRvAdapter()
        backBtnListener()
    }

    // 더미 연결
    private fun initRvAdapter() {
        waitAdapter = MyPageWaitAdapter()
        binding.rvMypageWait.adapter = waitAdapter
        waitAdapter.submitList(
            listOf(
                ResponseMyPageWait(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                ), ResponseMyPageWait(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                ), ResponseMyPageWait(
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
        binding.ivMypageWaitBack.setOnClickListener {
            finish()
        }
    }
}