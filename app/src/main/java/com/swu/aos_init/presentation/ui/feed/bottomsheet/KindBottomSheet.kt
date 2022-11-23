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
import com.swu.aos_init.databinding.DialogBottomSheetKindBinding

// 종류 바텀시트
class KindBottomSheet(private val selectedList: MutableList<Int>? = null) :
    BottomSheetDialogFragment() {

    private var _binding: DialogBottomSheetKindBinding? = null
    val binding get() = _binding!!

    private lateinit var bottomSheetClickListener: BottomSheetClickListener

    interface BottomSheetClickListener {
        fun getSelectedKindList(selectedFilter: MutableList<Int>)
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
            R.layout.dialog_bottom_sheet_kind,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHeight()
        initDoneBtn()

        setSelectedUI()
    }

    // 기존에 데이터가 이미 있으면 UI 세팅해주기
    private fun setSelectedUI() {
        val interestList = mutableListOf<Chip>()
        for (i in binding.chipGroupInterest.indices) {
            interestList.add(binding.chipGroupInterest[i] as Chip)
        }

        if (selectedList != null) {
            for (data in selectedList) {
                interestList[data - 1].isChecked = true
            }
        }
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
            bottomSheetClickListener.getSelectedKindList(getSelectedFilter())
            dismiss()
        }
    }

    private fun getSelectedFilter(): MutableList<Int> {
        val interestList = mutableListOf<Chip>()
        for (i in binding.chipGroupInterest.indices) {
            interestList.add(binding.chipGroupInterest[i] as Chip)
        }

        val countList = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
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