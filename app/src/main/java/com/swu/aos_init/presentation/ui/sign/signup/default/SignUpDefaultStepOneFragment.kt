package com.swu.aos_init.presentation.ui.sign.signup.default

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.google.android.material.chip.Chip
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentSignupDefaultStepOneBinding
import com.swu.aos_init.presentation.base.BaseFragment

class SignUpDefaultStepOneFragment :
    BaseFragment<FragmentSignupDefaultStepOneBinding>(R.layout.fragment_signup_default_step_one) {

    private var nameState = false
    private var emailState = false
    private var belongState = false
    private var linkState = false
    private var academicStatusState = false
    private var sexState = false

    val academicSelectionList = mutableListOf<View>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkSelectionState()
    }

    private fun checkTxtState() {

        val editTextList =
            mutableListOf(binding.etvName, binding.etvEmail, binding.etvBelong, binding.etvLink)

    }

    private fun checkSelectionState() {
        academicSelectionList.addAll(listOf(binding.btnStatusStudent,binding.btnStatusWorker,binding.btnStatusEct))
        academicSelectionList[0].setOnClickListener { setSingleSelectBtnEvent(it) }
        academicSelectionList[1].setOnClickListener { setSingleSelectBtnEvent(it) }
        academicSelectionList[2].setOnClickListener { setSingleSelectBtnEvent(it) }
    }

    private fun setSingleSelectBtnEvent(selectedView: View) {
        // 숫자 select 함수
        fun getSingleSelectNum(view: View) {
            if (view.isSelected) { // 선택 o 상태면 -> select false
                view.isSelected = false
            } else { // 선택 x 상태면 -> select true
                academicSelectionList.filter { it.isSelected }
                    .forEach { it.isSelected = false } // 켜져있는 다른 요소들 select false
                view.isSelected = true
            }
        }

        when (selectedView) {
            academicSelectionList[0] -> getSingleSelectNum(academicSelectionList[0])
            academicSelectionList[1] -> getSingleSelectNum(academicSelectionList[1])
            academicSelectionList[2] -> getSingleSelectNum(academicSelectionList[2])
        }
    }


    private fun checkBtnState() {
        binding.btnSignupDefaultOne.isEnabled =
            nameState && emailState && belongState && linkState && academicStatusState && sexState
    }
}