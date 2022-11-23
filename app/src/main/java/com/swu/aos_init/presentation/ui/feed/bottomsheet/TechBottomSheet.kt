package com.swu.aos_init.presentation.ui.feed.bottomsheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseStack
import com.swu.aos_init.databinding.DialogBottomSheetTechBinding
import com.swu.aos_init.presentation.ui.feed.adapter.StackAdapter
import com.swu.aos_init.presentation.util.AutoClearedValue

class TechBottomSheet() : BottomSheetDialogFragment() {
    private var binding by AutoClearedValue<DialogBottomSheetTechBinding>()
    private lateinit var stackAdapter: StackAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DialogBottomSheetTechBinding.inflate(inflater, container, false).run {
        binding = this
        this.root
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener { dialogInterface ->
            ((dialogInterface as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as View).apply {
                val behavior = BottomSheetBehavior.from(this)
                val layoutParams = this.layoutParams
                behavior.disableShapeAnimations()
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
                this.layoutParams = layoutParams
            }
        }
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextWatcher()
        finishBtnListener()
        editTextClickListener()
    }

    private fun editTextWatcher() = with(binding) {
        etStack.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                var input = binding.etStack.text.toString()

                val lowerInput = input.toLowerCase()
                val upperInput = input.toUpperCase()

                searchingTech(lowerInput)
                searchingTech(upperInput)

            }
        })
    }


    private fun searchingTech(text1: String) {
        val tmpList = ArrayList<ResponseStack>()
        val searchStackList = listOf(
            ResponseStack("Agit"),
            ResponseStack("Aws Athena"),
            ResponseStack("AWS MariaDB"),
            ResponseStack("BackboneJS"),
            ResponseStack("Cubrid"),
            ResponseStack("Dagger"),
            ResponseStack("Flutter"),
            ResponseStack("Flask"),
            ResponseStack("Istio"),
            ResponseStack("Jotai"),
            ResponseStack("Kibana"),
            ResponseStack("Karma"),
            ResponseStack("MySQL"),
            ResponseStack("NestJS"),
            ResponseStack("Sinon"),
            ResponseStack("Python"),
            ResponseStack("Playwright"),
            ResponseStack("Packer"),
            ResponseStack("Presto"),
            ResponseStack("Retrofit"),
            ResponseStack("Rundeck"),
            ResponseStack("Ruby"),
            ResponseStack("Swift"),
            ResponseStack("Spring"),
            ResponseStack("Slack"),
            ResponseStack("Tailwind"),
            ResponseStack("Typescript"),
            )
        for (i in 0 until searchStackList.size) {
            if (searchStackList.get(i).name.contains(text1)) {
                tmpList.add(searchStackList.get(i))
            }
        }
        stackAdapter = StackAdapter()
        binding.rvBottomSheetDefault.adapter = stackAdapter
        stackAdapter.findText = text1
        stackAdapter.setStackList(tmpList)

        //adpater 클릭 리스너
        stackAdapter.setItemClickListener(
            object : StackAdapter.ItemClickListener {
                @SuppressLint("ResourceAsColor")
                override fun onClick(view: View, position: Int) {
                    val subwayName = stackAdapter.dataList[position].name


                    binding.chipStack.addView(Chip(context).apply {
                        val string = "$subwayName"

                        text = string
                        setTextColor(Color.parseColor("#FFFFFF"))
                        isCloseIconVisible = true
                        setCloseIconResource(R.drawable.ic_close)
                        setCloseIconTintResource(R.color.white)
                        chipBackgroundColor = ColorStateList.valueOf(R.color.color_1C2E52)
                        setOnCloseIconClickListener {
                            binding.chipStack.removeView(this)
                        }
                    })
                }
            })
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun finishBtnListener() {
        binding.btnDone.setOnClickListener {
            dismiss()
        }

    }

    private fun editTextClickListener() {
        binding.etStack.setOnClickListener {
            binding.etStack.isSelected = true
        }
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

}