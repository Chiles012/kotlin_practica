package com.chiles.practica_activities

import android.os.Parcelable
import android.widget.Toast
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Image(
    var src: Int?,
    var infoImage: String = "Descripcion",
    var likeImage: Boolean = false,
    var id: Int
) : Parcelable {


}

@JsonClass(generateAdapter = true)
class ArrayImage(
    val arrayImage: Array<Image> = arrayOf(
        Image(R.drawable.ic_codigo, "Codigo", id = 0),
        Image(R.drawable.ic_objetivo, "Codigo objetivo", id = 1),
        Image(R.drawable.ic_programacion, "Mensaje", id = 2),
        Image(R.drawable.idioma, "Idioma", id = 3),
        Image(R.drawable.npl, "npl", id = 4),
        Image(R.drawable.lenguaje, "Lenguaje", id = 5)
    )
)
