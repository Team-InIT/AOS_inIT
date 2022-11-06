package com.swu.aos_init.presentation.ui.sign.signup.common

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentSignupStepOneBinding
import com.swu.aos_init.presentation.base.BaseFragment

class SignUpStepOneFragment :
    BaseFragment<FragmentSignupStepOneBinding>(R.layout.fragment_signup_step_one) {

    private var selectedState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSelectEvent()
        moveToSignUpTwo()
    }

    private fun initSelectEvent() {
        binding.apply {
            llDefault.setOnClickListener {
                if (ivDefault.isSelected) {
                    ivDefault.isSelected = false
                    tvDefault.isSelected = false
                } else {
                    ivDefault.isSelected = true
                    tvDefault.isSelected = true

                    ivOrg.isSelected = false
                    tvOrg.isSelected = false
                }

                checkBtnState()
            }

            llOrg.setOnClickListener {
                if (ivOrg.isSelected) {
                    ivOrg.isSelected = false
                    tvOrg.isSelected = false
                } else {
                    ivOrg.isSelected = true
                    tvOrg.isSelected = true

                    ivDefault.isSelected = false
                    tvDefault.isSelected = false
                }

                checkBtnState()
            }
        }
    }

    private fun moveToSignUpTwo() {
        binding.btnSignupOne.setOnClickListener {
            this.findNavController()
                .navigate(R.id.action_signUpStepOneFragment_to_signUpStepTwoFragment)
        }
    }

    private fun checkBtnState() {
        selectedState = binding.ivOrg.isSelected == true || binding.ivDefault.isSelected == true
        binding.btnSignupOne.isEnabled = selectedState == true
    }
}