package com.fire1.retrofitexample.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//SPecifies Base URL , Timeouts, Bearer Tokens - Okhttp
object ServiceBuilder {
    //OKHTTP here - Later
    var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .build()
        //Later Bearer Token
    //Retrofit
    val retrofit = Retrofit.Builder()
            .baseUrl("https://modcom.pythonanywhere.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    //Finally, Note we pass RestApi Interface as the class
    fun<T> buildService(service: Class<T>):T {
        return retrofit.create(service)
    }
}