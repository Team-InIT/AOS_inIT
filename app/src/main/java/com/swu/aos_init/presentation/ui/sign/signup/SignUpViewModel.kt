package com.swu.aos_init.presentation.ui.sign.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swu.aos_init.data.request.RequestSignUpGeneral
import com.swu.aos_init.data.response.BaseResponse
import com.swu.aos_init.data.service.ServiceCreator
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    // 공통 데이터
    val mID = MutableLiveData<String>()
    val mPW = MutableLiveData<String>()

    // 일반 회원 데이터
    val mName = MutableLiveData<String>()
    val mChat = MutableLiveData<String>()
    val mDept = MutableLiveData<String>()
    val mEdu = MutableLiveData<Int>()
    val mEmail = MutableLiveData<String>()
    val mGender = MutableLiveData<Int>()
    val mPosition = MutableLiveData<Int>()
    val mInterest = MutableLiveData<MutableList<Int>>()

    // 기업 회원 데이터

    private val _signUpGeneralData = MutableLiveData<BaseResponse>()
    val signUpGeneralData: LiveData<BaseResponse>
        get() = _signUpGeneralData

    private val _selectedMemberType = MutableLiveData<Int>()
    val selectedMemberType: LiveData<Int> = _selectedMemberType

    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int> = _progress

    fun setSelectedMemberType(type: Int) {
        _selectedMemberType.value = type
    }

    fun getSelectedMemberType(): Int {
        return _selectedMemberType.value!!
    }

    fun setProgress(step: Int) {
        when (step) {
            1 -> _progress.value = 25
            2 -> _progress.value = 50
            3 -> _progress.value = 75
            4 -> _progress.value = 100
        }
    }

    // 서버통신
    fun postSignUpGeneralData(requestSignUpGeneral: RequestSignUpGeneral) {
        viewModelScope.launch {
            kotlin.runCatching { ServiceCreator.signService.postSignUpGeneral(requestSignUpGeneral) }
                .onSuccess {
                    _signUpGeneralData.value = it
                    Log.d("kite", "서버 통신 성공")
                }
                .onFailure {
                    it.printStackTrace()
                    Log.d("kite", "서버 통신 실패")
                }
        }
    }
}