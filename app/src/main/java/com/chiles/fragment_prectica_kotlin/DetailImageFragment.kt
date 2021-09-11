package com.chiles.fragment_prectica_kotlin

import android.media.MediaPlayer
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

    lateinit var classPicture: ArrayPictures
    lateinit var arrayPictures: Array<Picture>
    lateinit var img: Picture
    lateinit var imagen: ImageView
    lateinit var txtInfo: TextView
    lateinit var favourite: ImageView
    lateinit var sound: ImageView
    var index1 = 0

    override fun onResume() {
        super.onResume()
        classPicture = requireArguments().getParcelable("arrayPicture")!!
        index1 = requireArguments().getInt("index")
        println(index1)
        println(requireArguments().getInt("index"))
        arrayPictures = classPicture.arrayPictures
        img = arrayPictures[index1]
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

        favourite.setOnClickListener {
            img.favourite = !img.favourite
            classPicture.arrayPictures[index1].favourite = img.favourite
            val act = activity
            if ( act is MainActivity )
                act.preferences.edit().putString(act.docPrference, act.moshi.adapter(ArrayPictures::class.java).toJson(classPicture)).commit()
            changeFavourite()
        }

        sound.setOnClickListener {
            img.favouriteSound = !img.favouriteSound
            classPicture.arrayPictures[index1].favouriteSound = img.favouriteSound
            val act = activity
            if ( act is MainActivity )
                act.preferences.edit().putString(act.docPrference, act.moshi.adapter(ArrayPictures::class.java).toJson(classPicture)).commit()
            changeFavourite()
        }
    }

    private fun changeFavourite() {
        if ( img.favourite )
            favourite.setImageResource(R.drawable.star_like)
        else
            favourite.setImageResource(R.drawable.star_border)

        if ( img.favouriteSound ) {
            sound.setImageResource(R.drawable.music_on)
            playSound(img.sourceSound)
        } else
            sound.setImageResource(R.drawable.music_off)
    }

    private fun initViews() {
        imagen = requireView().findViewById(R.id.imgViewImage)
        txtInfo = requireView().findViewById(R.id.txtDescription)
        favourite = requireView().findViewById(R.id.imgLike)
        sound = requireView().findViewById(R.id.imgMusicLike)

        imagen.setImageResource(img.sourceImage)
        txtInfo.text = img.description

        if ( img.favourite )
            favourite.setImageResource(R.drawable.star_like)
        else
            favourite.setImageResource(R.drawable.star_border)

        if ( img.favouriteSound )
            sound.setImageResource(R.drawable.music_on)
        else
            sound.setImageResource(R.drawable.music_off)
    }

    fun playSound(sound: Int) = MediaPlayer.create(context, sound)

}