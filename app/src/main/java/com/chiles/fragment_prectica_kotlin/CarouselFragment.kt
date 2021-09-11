package com.chiles.fragment_prectica_kotlin

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class CarouselFragment : Fragment(R.layout.fragment_carousel) {

    lateinit var arrayPictures: Array<Picture>
    lateinit var picture: Picture
    lateinit var btnContinue: ImageView
    lateinit var btnBack: ImageView
    lateinit var btnInfo: Button
    lateinit var imgCarousel: ImageView

    var index = 0

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arrayPictures = ArrayPictures().arrayPictures
        picture = arrayPictures[index]

        initViews()
        events()
    }

    private fun events() {
        btnBack.setOnClickListener {
            if ( index == 0 )
                index = arrayPictures.size-1
            else
                index--
            changePicture()
        }

        btnContinue.setOnClickListener {
            if ( index == (arrayPictures.size-1) )
                index = 0
            else
                index++
            changePicture()
        }

        btnInfo.setOnClickListener {
            val act = activity
            if ( act is MainActivity )
                act.changeFragment(DetailImageFragment(), picture)
            else
                Toast.makeText(context, "Error en abrir otro elemento", Toast.LENGTH_LONG).show()
        }
    }

    private fun initViews() {
        btnContinue = requireView().findViewById(R.id.btnContinue)
        btnBack = requireView().findViewById(R.id.btnPrevious)
        btnInfo = requireView().findViewById(R.id.btnInfo)
        imgCarousel = requireView().findViewById(R.id.imgViewCarousel)

        imgCarousel.setImageResource(picture.sourceImage)

    }

    fun changePicture() {
        picture = arrayPictures[index]
        imgCarousel.setImageResource(picture.sourceImage)
    }

    override fun onResume() {
        super.onResume()
    }

}