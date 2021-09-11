package com.chiles.fragment_prectica_kotlin

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

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
    }

    private fun initViews() {
        btnContinue = requireView().findViewById(R.id.btnContinue)
        btnBack = requireView().findViewById(R.id.btnPrevious)
        btnInfo = requireView().findViewById(R.id.btnInfo)
        imgCarousel = requireView().findViewById(R.id.imgViewCarousel)

        imgCarousel.setImageResource(picture.sourceImage)

    }

    override fun onResume() {
        super.onResume()
    }

}