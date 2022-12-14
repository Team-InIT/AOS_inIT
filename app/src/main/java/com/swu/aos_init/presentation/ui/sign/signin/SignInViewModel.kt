package com.swu.aos_init.presentation.ui.sign.signin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swu.aos_init.data.request.RequestLogin
import com.swu.aos_init.data.response.ResponseLogin
import com.swu.aos_init.data.service.ServiceCreator
import com.swu.aos_init.presentation.util.Event
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {

    private var _loginData = MutableLiveData<Event<ResponseLogin>>()
    val loginData : LiveData<Event<ResponseLogin>>
        get() = _loginData

    fun postSignIn(requestSignIn: RequestLogin) {
        viewModelScope.launch {
            kotlin.runCatching { ServiceCreator.signService.postLogin(requestSignIn) }
                .onSuccess {
                    _loginData.value = Event(it)
                    Log.d("_signInData", "서버 통신 성공")
                }
                .onFailure {
                    Log.d("_signInData", "서버 통신 실패")
                }
        }
    }
}