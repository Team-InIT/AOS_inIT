package com.swu.aos_init.presentation.ui.sign.signup.org

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentSignupOrgStepOneBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.sign.signup.SignUpViewModel
import com.swu.aos_init.presentation.util.EditTextValidate

class SignUpOrgStepOneFragment :
    BaseFragment<FragmentSignupOrgStepOneBinding>(R.layout.fragment_signup_org_step_one) {

    private val signUpViewModel: SignUpViewModel by activityViewModels()

    private var nameState = false
    private var emailState = false
    private var phoneNumState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgressValue()

        checkTxtState()
        setPhoneNumFormat()

        moveToOrgSignUpTwo()
    }

    private fun setProgressValue() {
        signUpViewModel.setProgress(3)
    }

    private fun checkTxtState() {
        binding.apply {
            etvName.addTextChangedListener {
                nameState = it?.length!! >= 1
                checkBtnState()
            }

            etvEmail.addTextChangedListener {
                emailState = it?.length!! >= 1
                checkBtnState()
            }

            etvPhoneNum.addTextChangedListener {
                phoneNumState = it?.length!! >= 13
                checkBtnState()
            }
        }
    }

    private fun setPhoneNumFormat() {
        EditTextValidate.phoneNumFormatEditText(binding.etvPhoneNum)
    }

    private fun checkBtnState() {
        // binding.btnSignupOrgOne.isEnabled = nameState && emailState && phoneNumState
    }

    private fun moveToOrgSignUpTwo() {
        binding.btnSignupOrgOne.setOnClickListener {
            this.findNavController()
                .navigate(R.id.action_signUpOrgStepOneFragment_to_signUpOrgStepTwoFragment)
            setOrgOneData()
        }
    }

    private fun setOrgOneData() {
        signUpViewModel.apply {
            cManagerName.value = binding.etvName.text.toString()
            cManagerEmail.value = binding.etvEmail.text.toString()
            cManagerCall.value = binding.etvPhoneNum.text.toString()
        }
    }
}