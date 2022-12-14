package com.swu.aos_init.presentation.util

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.swu.aos_init.R
import com.swu.aos_init.databinding.DialogBottomSheetDefaultBinding

class BottomSheetDefaultUtil(val type: Int) :
    BottomSheetDialogFragment() {


    private var _binding: DialogBottomSheetDefaultBinding? = null
    val binding get() = _binding!!

    private lateinit var bottomSheetClickListener: BottomSheetClickListener

    private lateinit var selectedTxtAdapter: SelectedTxtAdapter

    interface BottomSheetClickListener {
        fun getSelection(selectedTxt: String, selectedPosition: Int, type : Int)
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
            R.layout.dialog_bottom_sheet_default,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle()
        initAdapter()

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


    private fun setTitle() {
        when (type) {
            ORG_TYPE -> binding.tvBottomTitle.text = "????????????"
            PROJECT_TYPE -> binding.tvBottomTitle.text = "???????????? ??????"
            PROJECT_KIND -> binding.tvBottomTitle.text = "???????????? ??????"
            MY_PROJECT -> binding.tvBottomTitle.text = "???????????? ??????"
            PROJECT_APPLY -> binding.tvBottomTitle.text = "???????????? ??????"
        }
    }

    private fun initAdapter() {
        selectedTxtAdapter = SelectedTxtAdapter { checkBtnState() }
        selectedTxtAdapter.itemList = setRvList()
        binding.rvBottomSheetDefault.adapter = selectedTxtAdapter
    }

    private fun setRvList(): MutableList<SelectedTxtData> {

        val selectedTxtList = mutableListOf<SelectedTxtData>()

        when (type) {
            ORG_TYPE -> selectedTxtList.addAll(
                listOf(
                    SelectedTxtData("?????????"),
                    SelectedTxtData("????????? ????????? ??? ?????????"),
                    SelectedTxtData("???????????? (300??? ??????)"),
                    SelectedTxtData("???????????? (300??? ??????)"),
                    SelectedTxtData("????????????"),
                    SelectedTxtData("?????????(?????? ????????????)"),
                    SelectedTxtData("????????? (?????? ????????????)"),
                    SelectedTxtData("?????? ???????????? ??? ?????????"),
                    SelectedTxtData("??????????????? ??? ?????? ??? ????????????"),
                    SelectedTxtData("?????? ?????? ??? ??????????????? ??? ??????"),
                )
            )
            PROJECT_TYPE -> selectedTxtList.addAll(
                listOf(
                    SelectedTxtData("????????? ????????????"),
                    SelectedTxtData("????????? ????????????"),
                    SelectedTxtData("????????? ????????????"),
                )
            )
            PROJECT_KIND -> selectedTxtList.addAll(
                listOf(
                    SelectedTxtData("???"),
                    SelectedTxtData("??????????????????"),
                    SelectedTxtData("????????? ??? ?????????"),
                    SelectedTxtData("?????? ???????????????"),
                    SelectedTxtData("????????????"),
                    SelectedTxtData("???????????????"),
                    SelectedTxtData("????????????"),
                    SelectedTxtData("??????"),
                    SelectedTxtData("??????"),
                    SelectedTxtData("??????"),
                )
            )
            MY_PROJECT -> selectedTxtList.addAll(
                listOf(
                    SelectedTxtData("????????????"),
                    SelectedTxtData("??????"),
                    SelectedTxtData("?????????"),
                    SelectedTxtData("?????????")
                )
            )
            PROJECT_APPLY -> selectedTxtList.addAll(
                listOf(
                    SelectedTxtData("??????"),
                    SelectedTxtData("?????????"),
                    SelectedTxtData("??????"),
                )
            )
        }

        return selectedTxtList
    }

    private fun initDoneBtn() {
        binding.btnDone.setOnClickListener {
            val myItemList = selectedTxtAdapter.itemList
            val selectedPosition = myItemList.indexOf(myItemList.find { it.selectedState == true })
            bottomSheetClickListener.getSelection(
                selectedTxtAdapter.getSelectedTxt(),
                selectedPosition,
                type
            )
            dismiss()
        }
    }

    private fun checkBtnState() {
        binding.btnDone.isEnabled = selectedTxtAdapter.getSelectedState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        const val ORG_TYPE = 0
        const val PROJECT_TYPE = 1
        const val PROJECT_KIND = 2
        const val MY_PROJECT = 3
        const val PROJECT_APPLY = 4
    }
}