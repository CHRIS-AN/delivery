package com.chrisan.kotlinudemydelivery.api

import com.chrisan.kotlinudemydelivery.models.ResponseHttp
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Converter.*
import java.lang.reflect.Type


class NullOnEmptyConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        val delegate = retrofit!!.nextResponseBodyConverter<Any>(this, type!!, annotations!!)
        return Converter<ResponseBody, Any> {
            if (it.contentLength() == 0L) return@Converter
            delegate.convert(it)
        }
    }

}


class RetrofitClient {

    fun getClient(url : String) : Retrofit {
        val gson = GsonBuilder().create()

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(NullOnEmptyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

}