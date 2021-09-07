package com.chiles.practica_activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.moshi.Moshi

class imageDetail : AppCompatActivity() {

    lateinit var imgLike: ImageView
    lateinit var img: ImageView
    lateinit var txtInfo: TextView

    lateinit var handler: Handler

    lateinit var image: Image
    lateinit var arrayImages: ArrayImage
    var index = 0

    var isDoubleClick: Boolean = false
    private val IMAGE_PREFERNCES = "MY_IMAGE_PREFERENCES"
    private val PREF = "MY_PREFERENCES"
    lateinit var sharedPreferences: SharedPreferences
    private val moshi = Moshi.Builder().build()

    private val runnable = Runnable {
        isDoubleClick=false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        sharedPreferences = getSharedPreferences(PREF, Context.MODE_PRIVATE)

        image = intent.getParcelableExtra("imagen")!!
        arrayImages = intent.getParcelableExtra("array")!!
        index = intent.getIntExtra("index", 0)
        handler = Handler()

        initValues()

    }

    private fun initValues() {
        imgLike = findViewById(R.id.like)
        img = findViewById(R.id.detailImage)
        txtInfo = findViewById(R.id.txtDetail)

        if ( image.likeImage )
            imgLike.setImageResource(R.drawable.star_yellow)
        else
            imgLike.setImageResource(R.drawable.star_container)

        img.setImageResource(image.src!!)
        txtInfo.text = image.infoImage
    }

    fun doubleClick(view: View) {
        if ( isDoubleClick ) {
            // TODO: Cambiar el valor a true likeImage
                image.likeImage = !image.likeImage
                save()

                if ( image.likeImage )
                    imgLike.setImageResource(R.drawable.star_yellow)
                else
                    imgLike.setImageResource(R.drawable.star_container)
            isDoubleClick = false
        } else {
            isDoubleClick = true
            handler.postDelayed(runnable, 500)
        }
    }

    fun save() {
        arrayImages.arrayImage[index].likeImage = image.likeImage
        sharedPreferences.edit().putString(IMAGE_PREFERNCES, moshi.adapter(ArrayImage::class.java).toJson(arrayImages)).commit()
    }

    fun viewImg(view: View) {
        startActivity(Intent(this, imageView::class.java).apply {
            putExtra("image", image)
        })
    }

}

