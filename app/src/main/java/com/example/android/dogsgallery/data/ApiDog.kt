package com.example.android.dogsgallery.data

import com.example.android.dogsgallery.model.DogsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiDog {

    @GET("breeds/image/random/50")
    fun getDogsList():Call<DogsResponse>
}