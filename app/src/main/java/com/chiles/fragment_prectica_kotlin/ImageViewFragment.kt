package com.chiles.fragment_prectica_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ImageViewFragment : Fragment(R.layout.fragment_image_view) {

    lateinit var img2: Picture
    lateinit var imageView: ImageView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        img2 = requireArguments().getParcelable("picture")!!

        initViews()
    }

    private fun initViews() {
        imageView = requireView().findViewById(R.id.imgViewComplete)

        imageView.setImageResource(img2.sourceImage)
    }

}