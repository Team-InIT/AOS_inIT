package com.swu.aos_init.presentation.ui.sign.signup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swu.aos_init.data.request.RequestIsDuplicate
import com.swu.aos_init.data.request.RequestSignUpCompany
import com.swu.aos_init.data.request.RequestSignUpGeneral
import com.swu.aos_init.data.response.BaseResponse
import com.swu.aos_init.data.service.ServiceCreator
import com.swu.aos_init.presentation.util.Event
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    // 공통 데이터
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

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
    val cManagerName = MutableLiveData<String>()
    val cManagerEmail = MutableLiveData<String>()
    val cManagerCall = MutableLiveData<String>()
    val cType = MutableLiveData<Int>()
    val cRegistNum = MutableLiveData<String>()
    val cName = MutableLiveData<String>()
    val cBoss = MutableLiveData<String>()
    val cAddress = MutableLiveData<String>()

    private val _signUpGeneralData = MutableLiveData<Event<BaseResponse>>()
    val signUpGeneralData: LiveData<Event<BaseResponse>>
        get() = _signUpGeneralData

    private val _signUpCompanyData = MutableLiveData<Event<BaseResponse>>()
    val signUpCompanyData: LiveData<Event<BaseResponse>>
        get() = _signUpCompanyData

    private val _isDuplicateData = MutableLiveData<Event<BaseResponse>>()
    val isDuplicateData: LiveData<Event<BaseResponse>>
        get() = _isDuplicateData

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

    // 일반회원 서버통신
    fun postSignUpGeneralData(requestSignUpGeneral: RequestSignUpGeneral) {
        viewModelScope.launch {
            kotlin.runCatching { ServiceCreator.signService.postSignUpGeneral(requestSignUpGeneral) }
                .onSuccess {
                    _signUpGeneralData.value = Event(it)
                    Log.d("_signUpGeneralData", "서버 통신 성공")
                }
                .onFailure {
                    Log.d("_signUpGeneralData", "서버 통신 실패")
                }
        }
    }

    // 기업회원 서버통신
    fun postSignUpCompanyData(requestSignUpCompany: RequestSignUpCompany) {
        viewModelScope.launch {
            kotlin.runCatching { ServiceCreator.signService.postSignUpCompany(requestSignUpCompany) }
                .onSuccess {
                    _signUpCompanyData.value = Event(it)
                    Log.d("_signUpCompanyData", "서버 통신 성공")
                }
                .onFailure {
                    Log.d("_signUpCompanyData", "서버 통신 실패")
                }
        }
    }

    // 아이디 중복 체크
    fun postIsDuplicate(requestIsDuplicate: RequestIsDuplicate) {
        viewModelScope.launch {
            kotlin.runCatching { ServiceCreator.signService.postIsDuplicate(requestIsDuplicate) }
                .onSuccess {
                    _isDuplicateData.value = Event(it)
                    Log.d("_isDuplicateData", "서버 통신 성공")
                }
                .onFailure {
                    Log.d("_isDuplicateData", "서버 통신 실패")
                }
        }
    }
}