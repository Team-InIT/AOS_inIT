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

    private var _stackFilterList = ArrayList<String>()
    var stackFilterList : ArrayList<String> = _stackFilterList

    fun setKindFilter(kindList:MutableList<Int>) {
        _kindFilterList.value = kindList
    }

    fun setTypeFilter(typeList:MutableList<Int>) {
        _typeFilterList.value = typeList
    }

    fun setStackFilter(stackList : ArrayList<String>) {
        _stackFilterList = stackList
    }
}