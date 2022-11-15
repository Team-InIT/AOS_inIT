package com.swu.aos_init.data.request

data class RequestSignIn(
    val mID: String,
    val mPW: String,
    val orgState: Boolean? = false
)