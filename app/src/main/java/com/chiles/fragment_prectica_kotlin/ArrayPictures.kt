package com.chiles.fragment_prectica_kotlin

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class ArrayPictures(
    var arrayPictures: Array<Picture> = arrayOf(
        Picture(R.drawable.back, R.drawable.back, "Back")
    )
) : Parcelable {

    fun push(picture: Picture) {
        arrayPictures = arrayOf(*arrayPictures, picture)
    }

    fun pop() : Picture {
        val lastPicture = arrayPictures[arrayPictures.size-1]
        val newArrayPictures = arrayPictures.drop(arrayPictures.size-1)

        arrayPictures = newArrayPictures.toTypedArray()

        return lastPicture
    }

}