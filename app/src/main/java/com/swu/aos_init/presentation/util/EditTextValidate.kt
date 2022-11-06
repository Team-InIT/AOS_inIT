package com.swu.aos_init.presentation.util

import android.text.Editable
import android.widget.EditText
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import com.swu.aos_init.R
import java.util.regex.Pattern


object EditTextValidate {

    val idPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,20}$"
    val pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{6,20}$"

    //original 은 비밀번호 일치여부 판별할 때
    fun setValidate(type: String, content: Editable, original: String?): Boolean {
        return if (content.contains(" ")) {
            false
        } else {
            when (type) {
                "id" -> IdValidate(content)
                "pw" -> PwValidate(content)
                "pwConfirm" -> PwConfirmValidate(original!!, content)
                else -> false
            }
        }
    }

    fun IdValidate(content: Editable): Boolean {
        return Pattern.matches(
            idPattern, content.toString()
        ) && content.length >= 6 && content.length <= 20
    }

    fun PwValidate(content: Editable): Boolean {
        return Pattern.matches(
            pwPattern, content.toString()
        ) && content.length >= 6 && content.length <= 20
    }

    fun PwConfirmValidate(password: String, content: Editable): Boolean {
        return password == content.toString()
    }

    // 핸드폰 형식 감지 ("xxx-xxxx-xxxx")
    fun phoneNumFormatEditText(editText: EditText) {
        val context = editText.context

        var beforeLength = 0
        var afterLength = 0

        editText.doBeforeTextChanged { text, start, count, after ->
            beforeLength = text!!.length
        }
        editText.doOnTextChanged { text, start, before, count ->
            afterLength = text!!.length

            // 삭제중
            if (beforeLength > afterLength) {
                // 삭제 중에 마지막에 -는 자동으로 지우기
                if (text.toString().endsWith("-")) {
                    editText.setText(text.toString().substring(0, text.length - 1))
                }
            }

            // 입력중
            else if (beforeLength < afterLength) {
                if (afterLength == 5 && text.toString().indexOf("-") < 0) {
                    editText.setText(
                        context.getString(R.string.sign_up_org_step_one_phone_num).format(
                            text.toString().substring(0, 3),
                            text.toString().substring(3, text.length)
                        )
                    )
                } else if (afterLength == 10) {
                    editText.setText(
                        context.getString(R.string.sign_up_org_step_one_phone_num).format(
                            text.toString().substring(0, 8),
                            text.toString().substring(8, text.length)
                        )
                    )
                } else if (afterLength == 15) {
                    editText.setText(
                        context.getString(R.string.sign_up_org_step_one_phone_num).format(
                            text.toString().substring(0, 13),
                            text.toString().substring(13, text.length)
                        )
                    )
                }
            }
            editText.setSelection(editText.length())
        }
    }

}