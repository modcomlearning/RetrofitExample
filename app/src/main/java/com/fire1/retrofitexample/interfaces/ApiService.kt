package com.fire1.retrofitexample.interfaces

import com.fire1.retrofitexample.models.DataModel
import retrofit2.Call
import retrofit2.http.GET

// This interface defines an API  
// service for getting random jokes. 
interface ApiService {
    @GET("jokes/random")
    fun getjokes(): Call<DataModel>
}