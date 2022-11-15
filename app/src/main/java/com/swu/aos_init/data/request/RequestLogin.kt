package com.swu.aos_init.data.request

data class RequestLogin(
    val id: String,
    val pw: String,
    val isCompany: Boolean? = false
)