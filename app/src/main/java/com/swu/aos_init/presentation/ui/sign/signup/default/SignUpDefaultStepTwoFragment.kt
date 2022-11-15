package com.swu.aos_init.presentation.ui.sign.signup.default

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.core.view.indices
import androidx.fragment.app.activityViewModels
import com.google.android.material.chip.Chip
import com.swu.aos_init.R
import com.swu.aos_init.data.request.RequestSignUpGeneral
import com.swu.aos_init.databinding.FragmentSignupDefaultStepTwoBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.sign.signup.SignUpViewModel

class SignUpDefaultStepTwoFragment :
    BaseFragment<FragmentSignupDefaultStepTwoBinding>(R.layout.fragment_signup_default_step_two) {

    private val signUpViewModel: SignUpViewModel by activityViewModels()

    private var positionState = false
    private var interestState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgressValue()

        checkPositionState()
        checkInterestedState()

        moveToLoginState()
    }

    private fun setProgressValue() {
        signUpViewModel.setProgress(4)
    }

    private fun checkPositionState() {
        val positionList = mutableListOf(binding.cvPlan, binding.cvDesign, binding.cvDevelop)

        for (i in positionList.indices) {
            positionList[i].setOnClickListener {
                if (positionList[i].isSelected) {
                    positionList[i].isSelected = false
                } else {
                    positionList[i].isSelected = true
                    positionList.filterNot { it == positionList[i] }
                        .forEach { it.isSelected = false }
                }

                positionState = positionList.any { it.isSelected }
                checkBtnState()
            }
        }
    }

    private fun checkInterestedState() {
        val interestList = mutableListOf<Chip>()

        for (i in binding.chipGroupInterest.indices) {
            interestList.add(binding.chipGroupInterest[i] as Chip)
        }

        interestList.forEach { it ->
            it.setOnClickListener {
                interestState = interestList.any { it.isChecked }
                checkBtnState()
            }
        }
    }

    private fun checkBtnState() {
        binding.btnSignupDefaultTwo.isEnabled = positionState && interestState
    }

    private fun moveToLoginState() {
        binding.btnSignupDefaultTwo.setOnClickListener {
            Toast.makeText(requireContext(), "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
            setDefaultTwoData()
            tryPostSignUpGeneral()
            activity?.finish()
        }
    }

    private fun setDefaultTwoData() {
        val positionList = mutableListOf(binding.cvPlan, binding.cvDesign, binding.cvDevelop)
        val interestList = mutableListOf<Chip>()
        for (i in binding.chipGroupInterest.indices) {
            interestList.add(binding.chipGroupInterest[i] as Chip)
        }

        val countList = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        for (i in countList.indices) {
            if (interestList[i].isChecked) countList[i] += 1
        }

        val mInterestList = mutableListOf<Int>()
        for (i in countList.indices) {
            if (countList[i] >= 1) {
                mInterestList.add(i + 1)
            }
        }

        signUpViewModel.apply {
            mPosition.value = positionList.indexOf(positionList.find { it.isSelected })
            mInterest.value = mInterestList
        }
    }

    private fun tryPostSignUpGeneral() {
        val requestSignUpGeneral = RequestSignUpGeneral(
            mID = signUpViewModel.mID.value!!,
            mPW = signUpViewModel.mPW.value!!,
            mName = signUpViewModel.mName.value!!,
            mEmail = signUpViewModel.mEmail.value!!,
            mDept = signUpViewModel.mDept.value!!,
            mChat = signUpViewModel.mChat.value!!,
            mEdu = signUpViewModel.mEdu.value!!,
            mGender = signUpViewModel.mGender.value!!,
            mPosition = signUpViewModel.mPosition.value!!,
            mInterest = signUpViewModel.mInterest.value!!
        )

        signUpViewModel.postSignUpGeneralData(
            requestSignUpGeneral
        )

    }
}