package com.swu.aos_init.presentation.ui.mypage.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.swu.aos_init.presentation.ui.mypage.other.OtherHyebinPageActivity
import com.swu.aos_init.presentation.ui.mypage.other.OtherMyPageActivity

class OtherHyebinPageTabAdapter(activity: OtherHyebinPageActivity) : FragmentStateAdapter(activity){
    val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}