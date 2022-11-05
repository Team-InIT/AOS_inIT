package com.swu.aos_init.presentation.ui.sign.signin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivitySigninBinding
import com.swu.aos_init.presentation.base.BaseActivity

class SignInActivity : BaseActivity<ActivitySigninBinding>(R.layout.activity_signin) {

    private val signInViewModel: SignInViewModel by viewModels()

    private var idState = false
    private var pwState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewmodel = signInViewModel
        observeSigIn()
    }

    private fun observeSigIn() {

        binding.etvId.addTextChangedListener {
            idState = it!!.isNotEmpty()
            checkBtnState()
        }

        binding.etvPw.addTextChangedListener {
            pwState = it!!.isNotEmpty()
            checkBtnState()
        }
    }

    private fun checkBtnState() {
        binding.btnSignin.isEnabled = idState == true && pwState == true
    }
}