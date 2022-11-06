package com.swu.aos_init.presentation.ui.sign.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private val _selectedMemberType = MutableLiveData<Int>()
    val selectedMemberType: LiveData<Int> = _selectedMemberType

    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int> = _progress

    fun setSelectedMemberType(type:Int) {
        _selectedMemberType.value = type
    }

    fun getSelectedMemberType(): Int {
        return _selectedMemberType.value!!
    }

    fun setProgress(step:Int) {
        when(step) {
            1 -> _progress.value = 25
            2 -> _progress.value = 50
            3 -> _progress.value = 75
            4 -> _progress.value = 100
        }
    }
}