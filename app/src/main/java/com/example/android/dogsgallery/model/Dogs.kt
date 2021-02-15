package com.example.android.dogsgallery.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dogs(@Json(name="message") val dogsList:List<String>):Parcelable
