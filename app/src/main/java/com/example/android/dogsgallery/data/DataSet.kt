package com.example.android.dogsgallery.data


import com.example.android.dogsgallery.model.DogsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DataSet {

    fun getDogs (callback: OnResultCallBack) {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        val api: ApiDog = retrofit.create(ApiDog::class.java)

        api.getDogsList().enqueue(object : Callback<DogsResponse> {
            override fun onResponse(call: Call<DogsResponse>, response: Response<DogsResponse>) {
                if (response.isSuccessful) {
                    val dogsResponse = response.body() ?: return
                    callback.onResult(Result.Success(dogsResponse.dogList))

                } else {
                    callback.onResult(Result.Failure("Something went wrong"))
                }
            }

            override fun onFailure(call: Call<DogsResponse>, t: Throwable) {
                callback.onResult(Result.Failure(t.localizedMessage))
            }

        })
    }
    interface OnResultCallBack{
        fun onResult(result: Result)
    }
}