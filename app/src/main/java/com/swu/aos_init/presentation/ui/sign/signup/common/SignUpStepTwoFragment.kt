package com.swu.aos_init.presentation.ui.sign.signup.common

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentSignupStepTwoBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.sign.signup.SignUpViewModel
import com.swu.aos_init.presentation.util.EditTextValidate

// TODO 서버통신에서 중복체크 후 idCheckState 를 설정할 예정
class SignUpStepTwoFragment :
    BaseFragment<FragmentSignupStepTwoBinding>(R.layout.fragment_signup_step_two) {

    private var idState = false
    private var idCheckState = false
    private var pwState = false
    private var pwConfirmState = false

    private val signUpViewModel: SignUpViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgressValue()

        isRegularId()
        isRegularPw()
        isSamePw()

        initNextBtnEvent()
    }

    private fun setProgressValue() {
        signUpViewModel.setProgress(2)
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

            checkBtnState()
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

            if (pwState) {
                if (pwConfirmState) { // 일치
                    binding.tvPwError.setTextColor(resources.getColor(R.color.color_1C2E52, null))
                    binding.tvPwError.text = resources.getString(R.string.sign_up_step_two_pw_correct)
                } else { // 불일치
                    binding.tvPwError.setTextColor(resources.getColor(R.color.color_FF0000, null))
                    binding.tvPwError.text = resources.getString(R.string.sign_up_step_two_pw_error)
                }

                binding.tvPwError.visibility = View.VISIBLE

            } else binding.tvPwError.visibility = View.INVISIBLE

            checkBtnState()
        }

        // 비밀번호 확인 -> 비밀번호
        binding.etvPwTwo.addTextChangedListener {
            pwConfirmState =
                EditTextValidate.setValidate("pwConfirm", it!!, binding.etvPwOne.text.toString())

            if (pwState) {
                if (pwConfirmState) { // 일치
                    binding.tvPwError.setTextColor(resources.getColor(R.color.color_1C2E52, null))
                    binding.tvPwError.text = resources.getString(R.string.sign_up_step_two_pw_correct)
                } else { // 불일치
                    binding.tvPwError.setTextColor(resources.getColor(R.color.color_FF0000, null))
                    binding.tvPwError.text = resources.getString(R.string.sign_up_step_two_pw_error)
                }

                binding.tvPwError.visibility = View.VISIBLE

            } else binding.tvPwError.visibility = View.INVISIBLE

            checkBtnState()
        }
    }

    private fun checkBtnState() {
        binding.btnSignupTwo.isEnabled =
            idState == true && pwState && true && pwConfirmState == true
    }

    private fun initNextBtnEvent() {
        val type = signUpViewModel.getSelectedMemberType()
        binding.btnSignupTwo.setOnClickListener {
            if (type == 0) {
                this.findNavController().navigate(R.id.action_signUpStepTwoFragment_to_signUpOrgStepOneFragment)
            } else {
                this.findNavController().navigate(R.id.action_signUpStepTwoFragment_to_signUpDefaultStepOneFragment)
            }

            setCommonSignUpData()
        }
    }

    private fun setCommonSignUpData() {
        signUpViewModel.mID.value = binding.etvId.text.toString() // 아이디
        signUpViewModel.mPW.value = binding.etvPwTwo.text.toString() // 비밀번호
    }
}