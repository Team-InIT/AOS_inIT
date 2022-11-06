package com.swu.aos_init.presentation.ui.sign.signup

import android.os.Bundle
import androidx.activity.viewModels
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivitySignupBinding
import com.swu.aos_init.presentation.base.BaseActivity

class SignUpActivity : BaseActivity<ActivitySignupBinding>(R.layout.activity_signup) {

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBackBtn()
        observeProgressBar()
    }

    private fun observeProgressBar() {
       signUpViewModel.progress.observe(this) {
           binding.pbSignup.progress = it
       }
    }

    private fun initBackBtn() {
        binding.ivBackBtn.setOnClickListener {
            finish()
        }
    }
}