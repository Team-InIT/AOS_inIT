package com.swu.aos_init.presentation.ui.sign.signup

import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivitySignupBinding
import com.swu.aos_init.presentation.base.BaseActivity

class SignUpActivity : BaseActivity<ActivitySignupBinding>(R.layout.activity_signup) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBackBtn()
    }

    // 뒤로가기 버튼 이벤트
    private fun initBackBtn() {
        binding.ivBackBtn.setOnClickListener {
            finish()
        }
    }
}