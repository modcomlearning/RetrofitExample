package com.fire1.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call the getjokes() method of the ApiCall class,
        // passing a callback function as a parameter.
        ApiCall().getjokes(this) { jokes ->
            // Set the text of the text view to the
            // joke value returned by the API response.
            Toast.makeText(applicationContext, ""+jokes, Toast.LENGTH_SHORT).show()
        }
    }


    //Now bring everything together


}