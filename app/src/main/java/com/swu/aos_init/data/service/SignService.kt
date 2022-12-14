package com.swu.aos_init.data.service

import com.swu.aos_init.data.request.RequestIsDuplicate
import com.swu.aos_init.data.request.RequestLogin
import com.swu.aos_init.data.request.RequestSignUpCompany
import com.swu.aos_init.data.request.RequestSignUpGeneral
import com.swu.aos_init.data.response.BaseResponse
import com.swu.aos_init.data.response.ResponseLogin
import retrofit2.http.Body
import retrofit2.http.POST

interface SignService {

    // 로그인
    @POST("/login")
    suspend fun postLogin(
        @Body body: RequestLogin
    ): ResponseLogin

    // 일반 회원 회원가입
    @POST("/signUp_general")
    suspend fun postSignUpGeneral(
        @Body body: RequestSignUpGeneral
    ): BaseResponse

    // 기업 회원 회원가입
    @POST("/signUp_company")
    suspend fun postSignUpCompany(
        @Body body: RequestSignUpCompany
    ): BaseResponse

    // 아이디 중복 체크
    @POST("/isDuplicate")
    suspend fun postIsDuplicate(
        @Body body: RequestIsDuplicate
    ): BaseResponse
}