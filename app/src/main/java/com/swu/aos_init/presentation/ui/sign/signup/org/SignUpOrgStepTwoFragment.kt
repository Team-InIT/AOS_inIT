package com.swu.aos_init.presentation.ui.sign.signup.org

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentSignupOrgStepTwoBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.sign.signup.SignUpViewModel

class SignUpOrgStepTwoFragment :
    BaseFragment<FragmentSignupOrgStepTwoBinding>(R.layout.fragment_signup_org_step_two) {

    private val signUpViewModel: SignUpViewModel by activityViewModels()

    private var orgTypeState = false
    private var businessNumState = false
    private var orgNameState = false
    private var ownerNameState = false
    private var addressState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgressValue()
        moveToLoginState()
    }

    private fun setProgressValue() {
        signUpViewModel.setProgress(4)
    }

    private fun checkBtnState() {
        binding.btnSignupOrgTwo.isEnabled = orgTypeState && businessNumState && orgNameState && ownerNameState && addressState
    }

    private fun moveToLoginState() {
        binding.btnSignupOrgTwo.setOnClickListener {
            Toast.makeText(requireContext(), "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
            activity?.finish()
        }
    }

}