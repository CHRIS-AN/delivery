package com.chrisan.kotlinudemydelivery.routes

import com.chrisan.kotlinudemydelivery.models.ResponseHttp
import com.chrisan.kotlinudemydelivery.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRoutes {

    @POST("user/create")
    fun register(@Body user : User) : Call<ResponseHttp>
}