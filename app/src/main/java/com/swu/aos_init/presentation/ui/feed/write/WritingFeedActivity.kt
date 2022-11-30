package com.swu.aos_init.presentation.ui.feed.write

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.database.Cursor
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.swu.aos_init.R
import com.swu.aos_init.databinding.ActivityWriteFeedBinding
import com.swu.aos_init.presentation.base.BaseActivity
import com.swu.aos_init.presentation.ui.feed.FeedViewModel
import com.swu.aos_init.presentation.ui.feed.bottomsheet.TechBottomSheet
import com.swu.aos_init.presentation.util.BottomSheetDefaultUtil

class WritingFeedActivity : BaseActivity<ActivityWriteFeedBinding>(R.layout.activity_write_feed),BottomSheetDefaultUtil.BottomSheetClickListener {

    private val feedViewModel: FeedViewModel by viewModels()

    // 2. 갤러리에서 이미지를 받이오기 위한 런처
    private var activityResultLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                it.data?.data?.let { uri ->
                    showLoadingDialog(this)
                    uploadFileToStorage(uri)
                }
            } else {
                Toast.makeText(this, "선택된 파일이 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

    private lateinit var mStorageRef: StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mStorageRef = FirebaseStorage.getInstance().reference // storage 변수 선언
        initBackBtn()
        initImgPickEvent()
        initBottomSheetEvent()
        initDoneEvent()
    }

    private fun initBackBtn() {
        binding.ivOpenFeedBack.setOnClickListener {
            finish()
        }
    }


    private fun initImgPickEvent() {
        binding.cardViewImage.setOnClickListener {
            Glide.with(this).load(R.drawable.img_app_nadosunbae).into(binding.ivFeedImg)
            //openGallery() // 갤러리 열기
        }
    }

    // 1. 갤러리 열기
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        activityResultLauncher.launch(intent)
    }

    // 3. firebase에 이미지 업로드 하기
    private fun uploadFileToStorage(uri: Uri) {
        val filename = getFileName(uri)
        val riversRef = mStorageRef.child("feed/$filename")
        riversRef.putFile(uri)
            .addOnSuccessListener {   // Get a URL to the uploaded content
                riversRef.downloadUrl.addOnSuccessListener { // 파이어베이스 업로드 성공
                    dismissLoadingDialog()
                    binding.ivFeedImg.setPadding(0, 0, 0, 0)
                    Glide.with(this).load(uri).into(binding.ivFeedImg)

                    // TODO 추후 서버에 이 링크를 넘겨줄 예정
                    Log.d("kite", it.toString())
                }
            }
            .addOnFailureListener { // 파이어베이스 업로드 실패
                dismissLoadingDialog()
            }
    }

    // 4. 파일 절대경로명 가져오기
    @SuppressLint("Range")
    fun getFileName(uri: Uri): String? {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor: Cursor =
                this.contentResolver.query(uri, null, null, null, null)!!
            cursor.use { cursor ->
                if (cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                }
            }
        }
        if (result == null) {
            result = uri.lastPathSegment
        }
        return result
    }

    private fun initBottomSheetEvent() {
        binding.tvFeedProjectSelectOpen.setOnClickListener { BottomSheetDefaultUtil(3).show(supportFragmentManager,"PROJECT") }
        binding.tvFeedProjectKindOpen.setOnClickListener { BottomSheetDefaultUtil(1).show(supportFragmentManager,"KIND")}
        binding.tvFeedProjectTypeOpen.setOnClickListener { BottomSheetDefaultUtil(2).show(supportFragmentManager,"TYPE")}
        binding.tvFeedProjectStackOpen.setOnClickListener {
            val list = feedViewModel.stackFilterList
            TechBottomSheet(list){initChipBtn()}.show(supportFragmentManager, "STACK_SHEET")
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun initChipBtn() {
        val list = feedViewModel.stackFilterList
        if (list.isNotEmpty()) {
            for (i in 0 until list.size) {
                binding.chipGroup.addView(Chip(this).apply {
                    val string = list[i]
                    text = string
                    setTextColor(Color.parseColor("#FFFFFF"))
                    isCloseIconVisible = true
                    setCloseIconResource(R.drawable.ic_close)
                    setCloseIconTintResource(R.color.white)
                    chipBackgroundColor = ColorStateList.valueOf(R.color.color_1C2E52)
                    setOnCloseIconClickListener {
                        binding.chipGroup.removeView(this)
                    }
                    list.removeAt(i)
                })

            }
        }
    }

    override fun getSelection(selectedTxt: String, selectedPosition: Int, type: Int) {
       when(type) {
           1 -> binding.tvFeedProjectKindOpen.text = selectedTxt
           2 -> binding.tvFeedProjectTypeOpen.text = selectedTxt
           3 -> binding.tvFeedProjectSelectOpen.text = selectedTxt
       }
    }

    private fun initDoneEvent(){
        binding.btnFinish.setOnClickListener {
            finish()
        }
    }
}