package com.swu.aos_init.presentation.ui.sign.signup.default

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentSignupDefaultStepOneBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.sign.signup.SignUpViewModel

class SignUpDefaultStepOneFragment :
    BaseFragment<FragmentSignupDefaultStepOneBinding>(R.layout.fragment_signup_default_step_one) {

    private val signUpViewModel: SignUpViewModel by activityViewModels()

    private var nameState = false
    private var emailState = false
    private var belongState = false
    private var linkState = false
    private var academicStatusState = false
    private var sexState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgressValue()

        checkTxtState()
        checkAcademicState()
        checkSexState()

        moveToDefaultSignUpTwo()
    }

    private fun setProgressValue() {
        signUpViewModel.setProgress(3)
    }

    private fun checkTxtState() {

        binding.apply {
            etvName.addTextChangedListener { // 이름
                nameState = it?.length!! >= 1
                checkBtnState()
            }

            etvEmail.addTextChangedListener { // 이메일
                emailState = it?.length!! >= 1
                checkBtnState()
            }

            etvBelong.addTextChangedListener { // 소속
                belongState = it?.length!! >= 1
                checkBtnState()
            }

            etvLink.addTextChangedListener { // 링크
                linkState = it?.length!! >= 1
                checkBtnState()
            }
        }

    }

    private fun checkAcademicState() {
        val academicSelectionList = mutableListOf(binding.btnStatusStudent, binding.btnStatusWorker, binding.btnStatusEct)

        for (i in academicSelectionList.indices) {
            academicSelectionList[i].setOnClickListener {
                if (academicSelectionList[i].isSelected) {
                    academicSelectionList[i].isSelected = false
                } else {
                    academicSelectionList[i].isSelected = true
                    academicSelectionList.filterNot { it == academicSelectionList[i] }
                        .forEach { it.isSelected = false }
                }

                academicStatusState = academicSelectionList.any { it.isSelected }
                checkBtnState()
            }
        }
    }

    private fun checkSexState() {
        val sexSelectionList = mutableListOf(binding.btnSexMan, binding.btnSexWoman, binding.btnSexEct)

        for (i in sexSelectionList.indices) {
            sexSelectionList[i].setOnClickListener {
                if (sexSelectionList[i].isSelected) {
                    sexSelectionList[i].isSelected = false
                } else {
                    sexSelectionList[i].isSelected = true
                    sexSelectionList.filterNot { it == sexSelectionList[i] }
                        .forEach { it.isSelected = false }
                }

                sexState = sexSelectionList.any { it.isSelected }
                checkBtnState()
            }
        }
    }


    private fun checkBtnState() {
        binding.btnSignupDefaultOne.isEnabled =
            nameState && emailState && belongState && linkState && academicStatusState && sexState
    }

    private fun moveToDefaultSignUpTwo() {
        binding.btnSignupDefaultOne.setOnClickListener {
            this.findNavController().navigate(R.id.action_signUpDefaultStepOneFragment_to_signUpDefaultStepTwoFragment)
        }
    }
}