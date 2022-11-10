package com.swu.aos_init.presentation.ui.sign.signup.org

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.swu.aos_init.R
import com.swu.aos_init.databinding.FragmentSignupOrgStepTwoBinding
import com.swu.aos_init.presentation.base.BaseFragment
import com.swu.aos_init.presentation.ui.sign.signup.SignUpViewModel
import com.swu.aos_init.presentation.util.BottomSheetDefaultUtil
import com.swu.aos_init.presentation.util.EditTextValidate

class SignUpOrgStepTwoFragment :
    BaseFragment<FragmentSignupOrgStepTwoBinding>(R.layout.fragment_signup_org_step_two), BottomSheetDefaultUtil.BottomSheetClickListener {

    private val signUpViewModel: SignUpViewModel by activityViewModels()

    private var orgTypeState = false
    private var businessNumState = false
    private var orgNameState = false
    private var ownerNameState = false
    private var addressState = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setProgressValue()

        checkTxtState()
        setBusinessNumFormat()
        moveToLoginState()
    }

    private fun setProgressValue() {
        signUpViewModel.setProgress(4)
    }

    private fun checkTxtState() {
        binding.apply {
            etvOrgType.setOnClickListener {
                val bottomSheet = BottomSheetDefaultUtil(0)
                bottomSheet.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomBottomSheet)
                bottomSheet.show(childFragmentManager,"ORG_TYPE")

                checkBtnState()
            }

            etvBusinessNum.addTextChangedListener {
                businessNumState = it?.length!! >= 12
                checkBtnState()
            }

            etvOrgName.addTextChangedListener {
                orgNameState = it?.length!! >= 1
                checkBtnState()
            }

            etvOwnerName.addTextChangedListener {
                ownerNameState = it?.length!! >= 1
                checkBtnState()
            }

            etvAddress.addTextChangedListener {
                addressState = it?.length!! >= 1
                checkBtnState()
            }
        }
    }

    private fun setBusinessNumFormat() {
        EditTextValidate.businessNumFormantEditText(binding.etvBusinessNum)
    }

    private fun checkBtnState() {
        binding.btnSignupOrgTwo.isEnabled =
            orgTypeState && businessNumState && orgNameState && ownerNameState && addressState
    }

    private fun moveToLoginState() {
        binding.btnSignupOrgTwo.setOnClickListener {
            Toast.makeText(requireContext(), "회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
            activity?.finish()
        }
    }

    override fun getSelection(selectedTxt: String) {
        binding.etvOrgType.text = selectedTxt
        orgTypeState = true
    }

}