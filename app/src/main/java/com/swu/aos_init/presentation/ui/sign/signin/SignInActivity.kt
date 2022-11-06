package com.swu.aos_init.presentation.ui.sign.signin

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivitySigninBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.sign.signup.SignUpActivity
import com.swu.aos_init.presentation.util.EditTextValidate

class SignInActivity : BaseActivity<ActivitySigninBinding>(R.layout.activity_signin) {

    private val signInViewModel: SignInViewModel by viewModels()

    private var idState = false
    private var pwState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewmodel = signInViewModel
        observeSigIn()

        moveToSignUp()
    }

    private fun observeSigIn() {

        binding.etvId.addTextChangedListener {
            idState = EditTextValidate.IdValidate(it!!)
            checkBtnState()
        }

        binding.etvPw.addTextChangedListener {
            pwState = EditTextValidate.PwValidate(it!!)
            checkBtnState()
        }
    }

    private fun checkBtnState() {
        binding.btnSignin.isEnabled = idState == true && pwState == true
    }

    private fun moveToSignUp() {
        binding.tvSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

}