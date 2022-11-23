package com.swu.aos_init.presentation.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedViewModel : ViewModel() {

    // 타입 필터 데이터
    private var _typeFilterList = MutableLiveData<MutableList<Int>>()
    val typeFilterList: LiveData<MutableList<Int>> = _typeFilterList

    // 종류 필터 데이터
    private var _kindFilterList = MutableLiveData<MutableList<Int>>()
    val kindFilterList: LiveData<MutableList<Int>> = _kindFilterList

    fun setTypeFilter(kindList:MutableList<Int>) {
        _kindFilterList.value = kindList
    }
}