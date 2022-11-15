package com.swu.aos_init.data.response

data class ResponseLogin(
    val mNum: Int? = -1,
    val mName: String? = "",
    val cNum: Int? = -1,
    val cName: String?= ""
):BaseResponse()
