package com.example.android.dogsgallery.data

import android.util.Log
import com.example.android.dogsgallery.model.Dogs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DataSet {

    fun getDogs (callback: OnResultCallBack) {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breeds/image/random/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        val api: ApiDog = retrofit.create(ApiDog::class.java)

        api.getDogsList().enqueue(object : Callback<Dogs> {
            override fun onResponse(call: Call<Dogs>, response: Response<Dogs>) {
                if (response.isSuccessful){
                    val list = response.body() ?: return
                    callback.onResult(Result.Success(list.dogsList))
                    Log.i("dogs", list.dogsList.toString())
                }else{
                    callback.onResult(Result.Failure("error"))
                }
            }
            override fun onFailure(call: Call<Dogs>, t: Throwable) {
                callback.onResult(Result.Failure(t.localizedMessage))
            }

        })
    }
    interface OnResultCallBack{
        fun onResult(result: Result)
    }
}