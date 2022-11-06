package com.swu.aos_init.presentation.util

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.content.ContextCompat
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
        )
    }

    fun PwValidate(content: Editable): Boolean {
        return Pattern.matches(
            pwPattern, content.toString()
        )
    }

    fun PwConfirmValidate(password: String, content: Editable): Boolean {
        return password == content.toString()
    }

    // 사업자 번호 형식 감지
    fun businessNumFormantEditText(editText: EditText) {
        val context = editText.context
        var _beforeLength: Int = 0
        var _afterLength: Int = 0

        // 휴대폰 번호 입력 (자동 띄어씌기)
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                _beforeLength = s!!.length
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                _afterLength = s!!.length

                // 삭제중
                if (_beforeLength > _afterLength) {
                    // 삭제 중에 마지막에 -는 자동으로 지우기
                    if (s.toString().endsWith(" ")) {
                        editText.setText(s.toString().substring(0, s.length - 1))
                    }
                }

                // 입력중
                else if (_beforeLength < _afterLength) {
                    if (_afterLength == 5 && s.toString().indexOf("-") < 0) {
                        editText.setText(
                            context.getString(R.string.sign_up_org_step_two_business_num_txt).format(
                                s.toString().substring(0, 3),
                                s.toString().substring(3, s.length)
                            )
                        )
                    } else if (_afterLength == 8) {
                        editText.setText(
                            context.getString(R.string.sign_up_org_step_two_business_num_txt).format(
                                s.toString().substring(0, 6),
                                s.toString().substring(6, s.length)
                            )
                        )
                    } else if (_afterLength == 14) {
                        editText.setText(
                            context.getString(R.string.sign_up_org_step_two_business_num_txt).format(
                                s.toString().substring(0, 12),
                                s.toString().substring(12, s.length)
                            )
                        )
                    }
                }
                editText.setSelection(editText.length())
            }
            override fun afterTextChanged(s: Editable?) {}
        })
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
                        context.getString(R.string.sign_up_org_step_one_phone_num_txt).format(
                            text.toString().substring(0, 3),
                            text.toString().substring(3, text.length)
                        )
                    )
                } else if (afterLength == 10) {
                    editText.setText(
                        context.getString(R.string.sign_up_org_step_one_phone_num_txt).format(
                            text.toString().substring(0, 8),
                            text.toString().substring(8, text.length)
                        )
                    )
                } else if (afterLength == 15) {
                    editText.setText(
                        context.getString(R.string.sign_up_org_step_one_phone_num_txt).format(
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