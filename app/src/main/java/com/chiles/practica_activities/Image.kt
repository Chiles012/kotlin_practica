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
            Image(R.drawable.star_yellow, "Estrella svg"),
            Image(R.drawable.star_yellow, "Estrella svg amarilla")
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