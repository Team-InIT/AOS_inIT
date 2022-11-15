package com.swu.aos_init.presentation.ui.sign.signin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swu.aos_init.data.request.RequestSignIn
import com.swu.aos_init.data.response.BaseResponse
import com.swu.aos_init.data.service.ServiceCreator
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {

    private val _signInData = MutableLiveData<BaseResponse>()
    val signInData: LiveData<BaseResponse>
        get() = _signInData

    fun postSignIn(requestSignIn: RequestSignIn) {
        viewModelScope.launch {
            kotlin.runCatching { ServiceCreator.signService.postSignIn(requestSignIn) }
                .onSuccess {
                    _signInData.value = it
                    Log.d("kite", "서버 통신 성공")
                }
                .onFailure {
                    it.printStackTrace()
                    Log.d("kite", "서버 통신 실패")
                }
        }
    }
}