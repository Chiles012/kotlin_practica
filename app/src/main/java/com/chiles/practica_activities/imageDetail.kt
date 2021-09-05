package com.chiles.practica_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class imageDetail : AppCompatActivity() {

    lateinit var imgLike: ImageView
    lateinit var img: ImageView
    lateinit var txtInfo: TextView

    lateinit var handler: Handler

    lateinit var image: Image

    var isDoubleClick: Boolean = false

    private val runnable = Runnable { isDoubleClick=false }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)

        image = intent.getParcelableExtra<Image>("imagen")!!
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
            imgLike.setImageResource(R.drawable.star)

        img.setImageResource(image.src!!)
        txtInfo.text = image.infoImage
    }

    fun doubleClick(view: View) {
        if ( isDoubleClick ) {
            // TODO: Cambiar el valor a true likeImage
                image.likeImage = true
                imgLike.setImageResource(R.drawable.star_yellow)
            isDoubleClick = false
        } else {
            isDoubleClick = true
            handler.postDelayed(runnable, 500)
        }
    }

}