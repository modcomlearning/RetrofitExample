package com.fire1.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.fire1.retrofitexample.interfaces.RestApi
import com.fire1.retrofitexample.models.Lab
import com.fire1.retrofitexample.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLabs { lab ->
            Log.d("taggg", lab.toString())
            if (lab != null) {
                Toast.makeText(applicationContext, "lab "+lab.lab_name, Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "Lab is Null", Toast.LENGTH_SHORT).show()
            }
        }
    }


    //Now bring everything together
    fun myLabs(onResult: (Lab?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.laboratories().enqueue(
            object : retrofit2.Callback<Lab>{
                override fun onResponse(call: Call<Lab>, response: Response<Lab>) {
                    onResult(response.body())
                }

                override fun onFailure(call: Call<Lab>, t: Throwable) {
                    onResult(null)
                }
            }
        )
    }//end

}