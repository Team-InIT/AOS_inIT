package com.swu.aos_init.presentation.ui.mypage

import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.data.response.mypage.ResponseMyPageUpload
import com.swu.aos_init.databinding.ActivityMyPageUploadBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.adapter.MyPageUploadAdapter

class MyPageUploadActivity : BaseActivity<ActivityMyPageUploadBinding>(R.layout.activity_my_page_upload) {

    private lateinit var uploadAdapter: MyPageUploadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRvAdapter()
        backBtnListener()
    }

    // 더미 연결
    private fun initRvAdapter() {
        uploadAdapter = MyPageUploadAdapter()
        binding.rvMypageUpload.adapter = uploadAdapter
        uploadAdapter.submitList(
            listOf(
                ResponseMyPageUpload(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                ), ResponseMyPageUpload(
                    "웹",
                    "네이버 해커톤 같이 하실 분 구해요",
                    "기획자 1/3  ･  디자이너  2/4  ･  개발자 3/8",
                    "2022.11.09 ~ 2022.12.09",
                    "D-3"
                ), ResponseMyPageUpload(
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
        binding.ivMypageUploadBack.setOnClickListener {
            finish()
        }
    }
}