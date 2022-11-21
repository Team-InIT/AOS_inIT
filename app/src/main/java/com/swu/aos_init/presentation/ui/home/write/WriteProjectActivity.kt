package com.swu.aos_init.presentation.ui.home.write

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityWriteProjectBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.sign.signup.SignUpViewModel
import com.swu.aos_init.presentation.util.BottomSheetDefaultUtil
import java.util.*

class WriteProjectActivity : BaseActivity<ActivityWriteProjectBinding>(R.layout.activity_write_project),BottomSheetDefaultUtil.BottomSheetClickListener {

    private var orgTypeState = false
    private var kindState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        backBtnListener()
        initDatePickerDialog()
        initProjectStartDatePickerDialog()
        initProjectEndDatePickerDialog()
        bottomSheetClickListener()
        finishBtnClickListener()
    }

    //뒤로가기 버튼
    private fun backBtnListener() {
        binding.ivOpenProjectBack.setOnClickListener {
            finish()
        }
    }

    //데이트피커 (모집시기 끝나는 날)
    private fun initDatePickerDialog() {
        binding.tvProjectRecruitEnd.setOnClickListener {
            initDialog(binding.tvProjectRecruitEnd)
        }
    }

    //데이트피커 (진행시기 시작)
    private fun initProjectStartDatePickerDialog() {
        binding.tvProjectGoingStart.setOnClickListener {
            initDialog(binding.tvProjectGoingStart)
        }
    }

    //데이트피커 (진행시기 시작)
    private fun initProjectEndDatePickerDialog() {
        binding.tvProjectGoingEnd.setOnClickListener {
            initDialog(binding.tvProjectGoingEnd)
        }
    }

    //데이트피커 호출
    private fun initDialog(textView: TextView) {
        val calendar: Calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog(
            this,
            R.style.MySpinnerDatePickerStyle,
            { _, year, month, day ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_YEAR, day)

                val month = month + 1
                val dateString = String.format("%d.%02d.%02d", year, month, day)

                textView.setText(dateString)
                textView.setTextColor(Color.parseColor("#191919"))
                textView.isSelected = true

            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),

            )
        val textColor = ContextCompat.getColor(
            this, R.color.color_1C2E52
        )
        datePickerDialog.show()
        datePickerDialog.getButton(
            DatePickerDialog.BUTTON_POSITIVE
        ).setTextColor(textColor)
        datePickerDialog.getButton(
            DatePickerDialog.BUTTON_NEGATIVE
        ).setTextColor(textColor)
    }

    private fun initBottomSheet(type : Int, tag: String) {
        val bottomSheet = BottomSheetDefaultUtil(type)
        bottomSheet.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomBottomSheet)
        bottomSheet.show(supportFragmentManager, tag)
    }

    private fun bottomSheetClickListener() {
        binding.tvProjectTypeAnswer.setOnClickListener {
            initBottomSheet(1, "PROJECT_TYPE")
        }
        binding.tvProjectTypeKind.setOnClickListener {
            initBottomSheet(2, "PROJECT_KIND")
        }
    }

    override fun getSelection(selectedTxt: String, selectedPosition: Int, type : Int) {
        if(type == 1) {
            binding.tvProjectTypeAnswer.text = selectedTxt
            orgTypeState = true
        }
        else if (type == 2) {
            binding.tvProjectTypeKind.text = selectedTxt
            kindState = true
        }
    }


    //완료버튼 클릭 리스너
    private fun finishBtnClickListener() {
        binding.btnFinish.setOnClickListener {
            finish()
        }
    }
}
