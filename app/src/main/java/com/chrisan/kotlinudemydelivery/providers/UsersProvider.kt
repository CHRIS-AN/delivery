package com.chrisan.kotlinudemydelivery.providers

import com.chrisan.kotlinudemydelivery.api.ApiRoutes
import com.chrisan.kotlinudemydelivery.models.ResponseHttp
import com.chrisan.kotlinudemydelivery.models.User
import com.chrisan.kotlinudemydelivery.routes.UserRoutes
import retrofit2.Call

class UsersProvider {

    private var userRoutes : UserRoutes? = null
    
    init {
        val api = ApiRoutes()
        userRoutes = api.getUsersRoutes()
    }


    fun register(user : User) : Call<ResponseHttp>? {
        return userRoutes?.register(user)
    }
}