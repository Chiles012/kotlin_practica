package com.chiles.fragment_prectica_kotlin

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class ArrayPictures(
    var arrayPictures: Array<Picture> = arrayOf(
        Picture(R.drawable.ic_codigo, R.raw.here_we_go, "Codigo de programacion"),
        Picture(R.drawable.ic_objetivo, R.raw.mamma_mia, "Codigo en objetivo"),
        Picture(R.drawable.ic_programacion, R.raw.super_mario, "Code"),
        Picture(R.drawable.idioma, R.raw.game_over, "idiamas en el planeta"),
        Picture(R.drawable.lenguaje, R.raw.tuberia, "lenguaje de programacion"),
        Picture(R.drawable.npl, R.raw.vida, "Cerebro"),
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