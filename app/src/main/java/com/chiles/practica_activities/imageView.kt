package com.chiles.practica_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class imageView : AppCompatActivity() {

    lateinit var image: Image
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        initViews()
    }

    private fun initViews() {
        image = intent.getParcelableExtra("image")!!
        imageView = findViewById(R.id.imageView)

        imageView.setImageResource(image.src!!)
    }
}