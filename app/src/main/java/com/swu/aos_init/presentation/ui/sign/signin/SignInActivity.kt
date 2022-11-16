package com.swu.aos_init.presentation.ui.sign.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.swu.aos_init.R
import com.swu.aos_init.data.request.RequestLogin
import com.swu.aos_init.databinding.ActivitySigninBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.MainActivity
import com.swu.aos_init.presentation.ui.sign.signup.SignUpActivity
import com.swu.aos_init.presentation.util.EditTextValidate

class SignInActivity : BaseActivity<ActivitySigninBinding>(R.layout.activity_signin) {

    private val signInViewModel: SignInViewModel by viewModels()

    private var idState = false
    private var pwState = false

    private var orgState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeSigIn()
        checkOrgState()

        moveToSignUp()
        moveToMain()
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

    private fun checkOrgState() {
        binding.apply {
            llOrgCheck.setOnClickListener {
                if (llOrgCheck.isSelected) {
                    ivCheckOrg.isSelected = false
                    tvCheckOrg.isSelected = false
                    llOrgCheck.isSelected = false
                    orgState = false
                } else {
                    ivCheckOrg.isSelected = true
                    tvCheckOrg.isSelected = true
                    llOrgCheck.isSelected = true
                    orgState = true
                }
            }
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

    private fun moveToMain() {
        binding.btnSignin.setOnClickListener {
            tryPostSignIn()
        }
    }

    private fun tryPostSignIn() {
        val requestSignIn = RequestLogin(
            id = binding.etvId.text.toString(),
            pw = binding.etvPw.text.toString(),
            isCompany = orgState
        )

        signInViewModel.postSignIn(requestSignIn)
        signInViewModel.loginData.observe(this) { event ->
            event.getContentIfNotHandled()?.let{
                if (it.mNum != null && requestSignIn.isCompany == false) { // 일반 회원 로그인 성공
                    Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else if (it.cNum != null && requestSignIn.isCompany == true){ // 기업 회원 로그인 성공
                    Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "아이디 또는 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}