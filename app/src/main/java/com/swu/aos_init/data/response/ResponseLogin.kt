package com.swu.aos_init.data.response

data class ResponseLogin(
    val resultCode:Int?= 0,
    val messge:String?="",
    val mNum: Int? = -1,
    val mName: String? = "",
    val cNum: Int? = -1,
    val cName: String?= ""
)
