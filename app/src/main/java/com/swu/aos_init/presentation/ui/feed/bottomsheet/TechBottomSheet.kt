package com.swu.aos_init.presentation.ui.feed.bottomsheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.swu.aos_init.R
import com.swu.aos_init.data.response.ResponseStack
import com.swu.aos_init.databinding.DialogBottomSheetTechBinding
import com.swu.aos_init.presentation.ui.feed.FeedViewModel
import com.swu.aos_init.presentation.ui.feed.adapter.StackAdapter
import com.swu.aos_init.presentation.util.AutoClearedValue

class TechBottomSheet(val list: ArrayList<String>?, val doAfterConfirm: () -> Unit?) :
    BottomSheetDialogFragment() {

    private val feedViewModel: FeedViewModel by viewModels()
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
        binding.chipStack.removeAllViews()
        editTextWatcher()
        editTextClickListener()
        initDoneBtn()
        initChipBtn()
    }

    @SuppressLint("ResourceAsColor")
    private fun initChipBtn() {
        if (list?.isNotEmpty() == true) {
            for (i in 0 until list.size) {
                binding.chipStack.addView(Chip(context).apply {
                    val string = list[i]
                    text = string
                    setTextColor(Color.parseColor("#FFFFFF"))
                    isCloseIconVisible = true
                    setCloseIconResource(R.drawable.ic_close)
                    setCloseIconTintResource(R.color.white)
                    chipBackgroundColor = ColorStateList.valueOf(R.color.color_1C2E52)
                    setOnCloseIconClickListener {
                        binding.chipStack.removeView(this)
                    }
                    list.removeAt(i)
                })

            }
        }
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
            ResponseStack("Android"),
            ResponseStack("Aws Athena"),
            ResponseStack("AWS MariaDB"),
            ResponseStack("BackboneJS"),
            ResponseStack("Cubrid"),
            ResponseStack("Dagger"),
            ResponseStack("Flutter"),
            ResponseStack("Flask"),
            ResponseStack("FLOW"),
            ResponseStack("FIGMA"),
            ResponseStack("FireBase"),
            ResponseStack("GITHUB"),
            ResponseStack("Istio"),
            ResponseStack("Java"),
            ResponseStack("Jotai"),
            ResponseStack("Kibana"),
            ResponseStack("Karma"),
            ResponseStack("Kotlin"),
            ResponseStack("MVVM"),
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
                    val stackName = stackAdapter.dataList[position].name
                    binding.chipStack.addView(Chip(context).apply {
                        val string = "$stackName"
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

    private fun initDoneBtn() {
        binding.btnDone.setOnClickListener {
            for (i: Int in 1..binding.chipStack.childCount) {
                val chip: Chip = binding.chipStack.getChildAt(i - 1) as Chip
                list?.add(chip.text.toString())
            }
            if (list != null) {
                feedViewModel.stackFilterList = list
                feedViewModel.isStackSelect.value = true
            } else {
                feedViewModel.isStackSelect.value = false
            }

            doAfterConfirm()

            dismiss()
        }
    }

    //editText 클릭 리스너
    private fun editTextClickListener() {
        binding.etStack.setOnClickListener {
            binding.etStack.isSelected = true
        }
    }

    //바텀시트 스타일 적용
    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

}