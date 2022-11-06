package com.swu.aos_init.presentation.ui.sign.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private val _selectedMemberType = MutableLiveData<Int>()
    val selectedMemberType: LiveData<Int> = _selectedMemberType

    fun setSelectedMemberType(type:Int) {
        _selectedMemberType.value = type
    }

    fun getSelectedMemberType(): Int {
        return _selectedMemberType.value!!
    }
}