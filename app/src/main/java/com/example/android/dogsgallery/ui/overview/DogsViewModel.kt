package com.example.android.dogsgallery.ui.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.dogsgallery.data.DataSet
import com.example.android.dogsgallery.data.Result

class DogsViewModel: ViewModel() {

    private val dataSet = DataSet()
    val listData = MutableLiveData<Result>()

    init{
       getDogsList()
    }

    private fun getDogsList (){
        dataSet.getDogs(object : DataSet.OnResultCallBack {
            override fun onResult(result: Result) {
                if (result is Result.Success){
                    listData.value = result
                }
            }
        })
    }
    fun getListLiveData(): LiveData<Result>{
        return listData
    }
}