package com.chiles.practica_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnNext: ImageView
    lateinit var btnBack: ImageView
    lateinit var txtInfo: TextView
    lateinit var imageView: ImageView
    lateinit var arrayImages: Array<Image>

    var indexImage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayImages = Image.arrayImages

        initViews()
    }

    private fun initViews() {
        btnNext = findViewById(R.id.imgNext)
        btnBack = findViewById(R.id.imgBack)
        txtInfo = findViewById(R.id.showMore)
        imageView = findViewById(R.id.imgPrincipal)

        imageView.setImageResource(arrayImages[indexImage].src!!)
    }

    fun more(view: View) {
        startActivity(Intent(this, imageDetail::class.java).apply {
            putExtra("imagen", arrayImages[indexImage])
        })
    }

    fun next(view: View) {
        if ( indexImage == (arrayImages.size-1) )
            indexImage = 0
        else
            indexImage++

        chageImage()
    }

    fun back(view: View) {
        if ( indexImage == 0 )
            indexImage = arrayImages.size-1
        else
            indexImage--

        chageImage()
    }

    private fun chageImage() {
        imageView.setImageResource(arrayImages[indexImage].src!!)
    }

}