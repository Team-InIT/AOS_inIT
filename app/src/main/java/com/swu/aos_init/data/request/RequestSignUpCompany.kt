package com.swu.aos_init.data.request

data class RequestSignUpCompany(
    val cID: String,
    val cManagerCall: String,
    val cManagerEmail: String,
    val cManagerName: String,
    val cName: String,
    val cPW: String,
    val cBoss: String,
    val cRegistNum: String,
    val cAddress: String,
    val cType: Int
)