package com.swu.aos_init.presentation.ui.sign.signup.common

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentSignupStepTwoBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.util.EditTextValidate

class SignUpStepTwoFragment :
    BaseFragment<FragmentSignupStepTwoBinding>(R.layout.fragment_signup_step_two) {

    private var idState = false
    private var idCheckState = false
    private var pwState = false
    private var pwConfirmState = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isRegularId()
        isRegularPw()
        isSamePw()
    }

    // 아이디 정규식 체크
    private fun isRegularId() {
        binding.etvId.addTextChangedListener {
            idState = EditTextValidate.setValidate("id", it!!, binding.etvId.text.toString())
            if (idState) {
                binding.tvIdRule.setTextColor(resources.getColor(R.color.color_000000, null))
            } else {
                binding.tvIdRule.setTextColor(resources.getColor(R.color.color_FF0000, null))
            }
        }
    }

    // 비밀번호 정규식 체크
    private fun isRegularPw() {
        // 최소 8자리 이상, 영문, 숫자, 특수문자 포함
        binding.etvPwOne.addTextChangedListener {
            pwState =
                EditTextValidate.setValidate("pw", it!!, binding.etvPwOne.text.toString())
            if (pwState) {
                binding.tvPwRule.setTextColor(resources.getColor(R.color.color_000000, null))
            } else {
                binding.tvPwRule.setTextColor(resources.getColor(R.color.color_FF0000, null))
            }
            // checkBtnState()
        }
    }

    // 비밀번호 확인 일치여부 검사
    private fun isSamePw() {
        // 비밀번호 -> 비밀번호 확인
        binding.etvPwOne.addTextChangedListener { // 일치여부 체크
            pwConfirmState = EditTextValidate.setValidate(
                "pwConfirm",
                it!!,
                binding.etvPwTwo.text.toString()
            )
            if (pwConfirmState) {
                binding.tvPwError.visibility = View.INVISIBLE
            } else {
                binding.tvPwError.visibility = View.VISIBLE
            }
            // checkBtnState()
        }

        // 비밀번호 확인 -> 비밀번호
        binding.etvPwTwo.addTextChangedListener {
            pwConfirmState =
                EditTextValidate.setValidate("pwConfirm", it!!, binding.etvPwOne.text.toString())
            if (pwConfirmState) {
                binding.tvPwError.visibility = View.INVISIBLE
            } else {
                binding.tvPwError.visibility = View.VISIBLE
            }
            // checkBtnState()
        }
    }


}