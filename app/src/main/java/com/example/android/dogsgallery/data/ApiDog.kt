package com.example.android.dogsgallery.data

import com.example.android.dogsgallery.model.Dogs
import retrofit2.Call
import retrofit2.http.GET

interface ApiDog {

    @GET("50")
    fun getDogsList():Call<Dogs>
}