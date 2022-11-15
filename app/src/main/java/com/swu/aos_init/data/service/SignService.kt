package com.swu.aos_init.data.service

import com.swu.aos_init.data.request.RequestSignIn
import com.swu.aos_init.data.request.RequestSignUpGeneral
import com.swu.aos_init.data.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignService {

    // 로그인
    @POST("/signIn")
    fun postSignIn(
        @Body body: RequestSignIn
    ): BaseResponse

    // 일반 회원 회원가입
    @POST("/signUp_general")
    fun postSignUpGeneral(
        @Body body: RequestSignUpGeneral
    ): BaseResponse
}