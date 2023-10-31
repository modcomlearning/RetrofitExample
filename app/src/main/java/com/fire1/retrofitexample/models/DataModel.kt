package com.fire1.retrofitexample.models
// Model class for our Jokes  
data class DataModel( 
    var categoories:ArrayList<String>, 
    var created_at: String, 
    var icon_url:String, 
    var id:String, 
    var updated_at:String, 
    var url:String, 
    var value:String 
):java.io.Serializable