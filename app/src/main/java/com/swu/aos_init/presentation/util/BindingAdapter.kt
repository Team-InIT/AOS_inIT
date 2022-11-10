package com.swu.aos_init.presentation.util

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("isTxtSelected")
    fun isTxtSelected(view: View, isSelected: Boolean) {
        when (isSelected) {
            true -> view.isSelected = true
            false -> view.isSelected = false
        }
    }
}