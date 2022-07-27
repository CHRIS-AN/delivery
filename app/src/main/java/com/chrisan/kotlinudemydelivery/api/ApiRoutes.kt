package com.chrisan.kotlinudemydelivery.api

import com.chrisan.kotlinudemydelivery.routes.UserRoutes
import retrofit2.Retrofit

class ApiRoutes {

    val API_URL = "http://192.168.123.103:3000/api"
    val retrofit = RetrofitClient()

    fun getUsersRoutes() : UserRoutes {
        return retrofit.getClient(API_URL).create(UserRoutes::class.java)
    }
}