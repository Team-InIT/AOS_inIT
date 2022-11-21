package com.swu.aos_init.presentation.ui.mypage

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPageTabAdapter(fragment: MyPageFragment) : FragmentStateAdapter(fragment){
    val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}