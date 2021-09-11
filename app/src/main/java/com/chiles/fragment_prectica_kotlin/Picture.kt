package com.chiles.fragment_prectica_kotlin

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Picture(
    var sourceImage: Int,
    var sourceSound: Int,
    var description: String? = null,
    var favourite: Boolean = false,
    var favouriteSound: Boolean = false
) : Parcelable {
}