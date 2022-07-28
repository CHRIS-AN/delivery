package com.chrisan.kotlinudemydelivery.models

import com.google.gson.annotations.SerializedName

/**
 * POST 요청 바디가 되는 부분
 */
class User(
    @SerializedName("id") val id: String? = null,
    @SerializedName("firstname") val firstname: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("password") val password: String,
    @SerializedName("image") val image : String? = null,
    @SerializedName("session_token") val sessionToken: String? = null,
    @SerializedName("is_available") val isAvailable: String? = null,
) {

    override fun toString(): String {
        return "User(id='$id', firstname='$firstname', lastname='$lastname', email='$email', phone='$phone', password='$password', image='$image', sessionToken='$sessionToken', isAvailable='$isAvailable')"
    }
}