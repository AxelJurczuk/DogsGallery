package com.example.android.dogsgallery.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DogsResponse (val message:List<String>):Parcelable
