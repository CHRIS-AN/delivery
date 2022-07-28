package com.chrisan.kotlinudemydelivery.routes

import com.chrisan.kotlinudemydelivery.models.ResponseHttp
import com.chrisan.kotlinudemydelivery.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

        //UserService
interface UserRoutes {
    // request Method
    @POST("user/create")
    fun register(
        @Body user : User // POST 는 응답 바디가 있기 때문에 @Body 애노테이션을 통해 요청 바디를 정의
    ) : Call<ResponseHttp> // 요청바디로 부터 받아온 데이터인 응답 바디를 callback 타입으로 정의
}