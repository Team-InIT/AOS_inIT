package com.swu.aos_init.presentation.ui.feed.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.core.view.indices
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.swu.aos_init.R
import com.swu.aos_init.databinding.DialogBottomSheetTypeBinding

// 타입 바텀시트
class TypeBottomSheet() :
    BottomSheetDialogFragment() {

    private var _binding: DialogBottomSheetTypeBinding? = null
    val binding get() = _binding!!

    private lateinit var bottomSheetClickListener: BottomSheetClickListener

    interface BottomSheetClickListener {
        fun getSelectedTypeList(selectedFilter: MutableList<Int>)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bottomSheetClickListener = try {
            requireParentFragment() as BottomSheetClickListener
        } catch (e: Exception) {
            context as BottomSheetClickListener
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.dialog_bottom_sheet_type,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHeight()
        initDoneBtn()
    }

    private fun setHeight() {
        dialog?.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }


    private fun initDoneBtn() {
        binding.btnDone.setOnClickListener {
            bottomSheetClickListener.getSelectedTypeList(getSelectedFilter())
            dismiss()
        }
    }

    private fun getSelectedFilter(): MutableList<Int> {
        val interestList = mutableListOf<Chip>()
        for (i in binding.chipGroupInterest.indices) {
            interestList.add(binding.chipGroupInterest[i] as Chip)
        }

        val countList = mutableListOf(0, 0, 0)
        for (i in countList.indices) {
            if (interestList[i].isChecked) countList[i] += 1
        }

        val mInterestList = mutableListOf<Int>()
        for (i in countList.indices) {
            if (countList[i] >= 1) {
                mInterestList.add(i + 1)
            }
        }

        return mInterestList
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}