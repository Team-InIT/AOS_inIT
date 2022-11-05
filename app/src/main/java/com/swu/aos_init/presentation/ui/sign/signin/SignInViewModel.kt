package com.swu.aos_init.presentation.ui.sign.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    private val _id = MutableLiveData<String>()
    val id : LiveData<String> = _id

    private val _pw = MutableLiveData<String>()
    val pw : LiveData<String> = _pw
}