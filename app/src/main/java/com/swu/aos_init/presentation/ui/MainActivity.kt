package com.swu.aos_init.presentation.ui

import android.os.Bundle
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityMainBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.alarm.AlarmFragment
import com.swu.aos_init.presentation.ui.feed.FeedFragment
import com.swu.aos_init.presentation.ui.home.HomeFragment
import com.swu.aos_init.presentation.ui.mypage.MyPageFragment
import com.swu.aos_init.presentation.ui.search.SearchFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBottomNavi()
    }

    private fun initBottomNavi() {
        supportFragmentManager.beginTransaction().add(R.id.fragment_main, HomeFragment()).commit()

        binding.btnMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_main, HomeFragment()).commit()
                }
                R.id.menu_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_main, SearchFragment()).commit()
                }
                R.id.menu_feed -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_main, FeedFragment()).commit()
                }
                R.id.menu_alarm -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_main, AlarmFragment()).commit()
                }
                R.id.menu_mypage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_main, MyPageFragment()).commit()
                }
            }
            return@setOnItemSelectedListener true
        }
    }


}