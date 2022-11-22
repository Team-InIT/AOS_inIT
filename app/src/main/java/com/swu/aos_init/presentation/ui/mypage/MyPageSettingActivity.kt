package com.swu.aos_init.presentation.ui.mypage

import android.content.Intent
import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityMyPageSettingBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.sign.signin.SignInActivity

class MyPageSettingActivity : BaseActivity<ActivityMyPageSettingBinding>(R.layout.activity_my_page_setting) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        backBtnListener()
        logoutListener()
        quitListener()
    }

    private fun backBtnListener() {
        binding.imgMypageSettingMovePage.setOnClickListener {
            finish()
        }
    }

    private fun logoutListener() {
        binding.tvMypageLogout.setOnClickListener {
            finish()
            val intentSetting = Intent(this, SignInActivity::class.java)
            startActivity(intentSetting)
        }
    }

    private fun quitListener() {
        binding.tvMypageQuit.setOnClickListener {
            finish()
            val intentSetting = Intent(this, SignInActivity::class.java)
            startActivity(intentSetting)
        }
    }
}