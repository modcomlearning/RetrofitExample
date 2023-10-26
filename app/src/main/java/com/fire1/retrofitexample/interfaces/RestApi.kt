package com.fire1.retrofitexample.interfaces

import com.fire1.retrofitexample.models.Lab
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

internal interface RestApi {
    //laboratories
    @Headers("Content-Type: application/json")
    @POST("laboratories")
    fun laboratories(): Call<Lab>   //No PayLoad Body, Has a Return

    //More Interfaces here...

} //end
