package com.example.android.dogsgallery.data


sealed class Result{
    data class Success (val list:List<String>):Result()
    data class Failure (val error:String):Result()
}
