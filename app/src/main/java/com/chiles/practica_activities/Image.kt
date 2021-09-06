package com.chiles.practica_activities

import android.os.Parcelable
import android.widget.Toast
import kotlinx.parcelize.Parcelize

@Parcelize
class Image(
    var src: Int?,
    var infoImage: String = "Descripcion",
    var likeImage: Boolean = false
) : Parcelable {

    companion object {
        var arrayImages = arrayOf(
            Image(R.drawable.ic_codigo, "Codigo"),
            Image(R.drawable.ic_objetivo, "Codigo objetivo"),
            Image(R.drawable.ic_programacion, "Mensaje"),
            Image(R.drawable.idioma, "Idioma"),
            Image(R.drawable.npl, "npl"),
            Image(R.drawable.lenguaje, "Lenguaje")
        )

        fun addImage(image: Image) : Array<Image> {
            arrayImages = arrayOf(*arrayImages, image)

            return arrayImages
        }

        fun getInfoImage(index: Int) : String {
            val image = arrayImages.get(index);

            return image.infoImage
        }
    }

}