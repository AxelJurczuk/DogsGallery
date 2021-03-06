package com.example.android.dogsgallery.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class DogsResponse (val message:List<String>):Parcelable
