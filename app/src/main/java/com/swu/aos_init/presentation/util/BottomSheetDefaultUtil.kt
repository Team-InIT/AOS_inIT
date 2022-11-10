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
        fun getSelection(selectedTxt: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bottomSheetClickListener = try {
            requireParentFragment() as BottomSheetClickListener
        } catch (e: Exception) {
            childFragmentManager as BottomSheetClickListener
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
            ORG_TYPE -> binding.tvBottomTitle.text = "기업형태"
            PROJECT_TYPE -> binding.tvBottomTitle.text = "프로젝트 타입"
            PROJECT_KIND -> binding.tvBottomTitle.text = "프로젝트 종류"
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
                    SelectedTxtData("대기업"),
                    SelectedTxtData("대기업 계열사 ･ 자회사"),
                    SelectedTxtData("중소기업 (300명 이하)"),
                    SelectedTxtData("중견기업 (300명 이상)"),
                    SelectedTxtData("벤처기업"),
                    SelectedTxtData("외국계(외국 투자기업)"),
                    SelectedTxtData("외국계 (외국 법인기업)"),
                    SelectedTxtData("국내 공공기관 ･ 공기업"),
                    SelectedTxtData("비영리단체 ･ 협회 ･ 교육재단"),
                    SelectedTxtData("외국 기관 ･ 비영리기구 ･ 단체"),
                )
            )
            PROJECT_TYPE -> selectedTxtList.addAll(
                listOf(
                    SelectedTxtData("기업용 프로젝트"),
                    SelectedTxtData("개인용 프로젝트"),
                    SelectedTxtData("과제용 프로젝트"),
                )
            )
            PROJECT_KIND -> selectedTxtList.addAll(
                listOf(
                    SelectedTxtData("웹"),
                    SelectedTxtData("어플리케이션"),
                    SelectedTxtData("커머스 ･ 쇼핑몰"),
                    SelectedTxtData("일반 소프트웨어"),
                    SelectedTxtData("퍼블리싱"),
                    SelectedTxtData("워드프레스"),
                    SelectedTxtData("임베디드"),
                    SelectedTxtData("제품"),
                    SelectedTxtData("게임"),
                    SelectedTxtData("기타"),
                )
            )
        }

        return selectedTxtList
    }

    private fun initDoneBtn() {
        binding.btnDone.setOnClickListener {
            bottomSheetClickListener.getSelection(selectedTxtAdapter.getSelectedTxt())
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
    }
}