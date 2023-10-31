package com.fire1.retrofitexample

import android.content.Context
import android.provider.ContactsContract.Data
import android.util.Log
import android.widget.Toast
import com.fire1.retrofitexample.interfaces.ApiService
import com.fire1.retrofitexample.models.DataModel
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class ApiCall {
    // This function takes a Context and callback function 
    // as a parameter, which will be called 
    // when the API response is received. 
    fun getjokes(context: Context, callback: (DataModel) -> Unit) {
  
        // Create a Retrofit instance with the base URL and  
        // a GsonConverterFactory for parsing the response. 
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.chucknorris.io/").addConverterFactory(
            GsonConverterFactory.create()).build()
  
        // Create an ApiService instance from the Retrofit instance. 
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
  
        // Call the getjokes() method of the ApiService  
        // to make an API request. 
        val call: Call<DataModel> = service.getjokes()
  
        // Use the enqueue() method of the Call object to 
        // make an asynchronous API request. 
        call.enqueue(object : Callback<DataModel> {
            // This is an anonymous inner class that implements the Callback interface.
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                  Log.d("taggg", response.body().toString())
                if(response.isSuccessful){
                    // If the response is successful, parse the
                    // response body to a DataModel object.
                    val jokes: DataModel = response.body() as DataModel
                    // Call the callback function with the DataModel
                    // object as a parameter.
                    callback(jokes)
                }
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.d("taggg", t.message.toString())
            }

        }) 
    } 
}