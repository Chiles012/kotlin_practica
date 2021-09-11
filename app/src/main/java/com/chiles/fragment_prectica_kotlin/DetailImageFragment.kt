package com.chiles.fragment_prectica_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailImageFragment : Fragment(R.layout.fragment_detail_image) {

    lateinit var img: Picture
    lateinit var imagen: ImageView
    lateinit var txtInfo: TextView
    lateinit var favourite: ImageView
    lateinit var sound: ImageView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        img = requireArguments().getParcelable("picture")!!

        initViews()
        events()
    }

    private fun events() {
        imagen.setOnClickListener {
            val act = activity
            if ( act is MainActivity )
                act.changeFragment(ImageViewFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable("picture", img)
                    }
                })
            else
                Toast.makeText(context, "Error", Toast.LENGTH_LONG)
        }
    }

    private fun initViews() {
        imagen = requireView().findViewById(R.id.imgViewImage)
        txtInfo = requireView().findViewById(R.id.txtDescription)
        favourite = requireView().findViewById(R.id.imgLike)
        sound = requireView().findViewById(R.id.imgMusicLike)

        imagen.setImageResource(img.sourceImage)
        txtInfo.text = img.description
    }

}