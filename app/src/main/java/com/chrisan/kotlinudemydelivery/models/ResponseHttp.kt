package com.chrisan.kotlinudemydelivery.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

/**
 * POST 는 응답 바디가 되는 부분
 */
class ResponseHttp (
    @SerializedName("message") val message : String,
    @SerializedName("success") val success : Boolean,
    @SerializedName("data") val data : JsonObject,
    @SerializedName("error") val error : String,
) {
    override fun toString(): String {
        return "ResponseHttp(message='$message', success=$success, data=$data, error='$error')"
    }
}