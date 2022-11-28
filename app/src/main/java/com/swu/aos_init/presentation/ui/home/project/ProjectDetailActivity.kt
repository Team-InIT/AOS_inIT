package com.swu.aos_init.presentation.ui.home.project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityProjectDetailBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.mypage.OtherMyPageActivity
import com.swu.aos_init.presentation.util.BottomSheetDefaultUtil
import com.swu.aos_init.presentation.util.CustomDialog

class ProjectDetailActivity :
    BaseActivity<ActivityProjectDetailBinding>(R.layout.activity_project_detail),
    BottomSheetDefaultUtil.BottomSheetClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        backBtnListener()
        likeBtnListener()
        ivClickListener()
        applyBtnListener()
    }

    private fun backBtnListener() {
        binding.ivOpenProjectBack.setOnClickListener {
            finish()
        }
    }

    private fun likeBtnListener() {
        binding.ivProjectDetailHeart.setOnClickListener {
            binding.ivProjectDetailHeart.isSelected = !binding.ivProjectDetailHeart.isSelected
        }
    }

    private fun applyBtnListener() {
        binding.btnFinish.setOnClickListener {
            initBottomSheet(4, "PROJECT_APPLY")
        }
    }

    private fun initBottomSheet(type: Int, tag: String) {
        val bottomSheet = BottomSheetDefaultUtil(type)
        bottomSheet.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomBottomSheet)
        bottomSheet.show(supportFragmentManager, tag)
    }

    private fun ivClickListener() {
        binding.imageView10.setOnClickListener {
            val intentSetting = Intent(this, OtherMyPageActivity::class.java)
            startActivity(intentSetting)
        }
    }

    override fun getSelection(selectedTxt: String, selectedPosition: Int, type: Int) {
        initAlert()
    }

    private fun initAlert() {
        val title = "해당 프로젝트에 지원하시겠습니까?"
        val dialog = CustomDialog(this, title)
        dialog.showChoiceDialog(R.layout.dialog_yes_no)

        dialog.setOnClickedListener(object : CustomDialog.ButtonClickListener {

            override fun onClicked(num: Int) {
                if (num == 1) {

                    Toast.makeText(
                        this@ProjectDetailActivity,
                        "신청이 완료되었습니다.",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {

                    Toast.makeText(
                        this@ProjectDetailActivity,
                        "신청이 취소되었습니다.",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        })
    }
}
