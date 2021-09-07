package com.chiles.practica_activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.moshi.Moshi

class MainActivity : AppCompatActivity() {

    lateinit var btnNext: ImageView
    lateinit var btnBack: ImageView
    lateinit var txtInfo: TextView
    lateinit var imageView: ImageView
    lateinit var arrayImages: ArrayImage
    lateinit var sharedPreferences: SharedPreferences

    var indexImage: Int = 0
    private val PREF = "MY_PREFERENCES"
    private val IMAGE_PREFERNCES = "MY_IMAGE_PREFERENCES"
    private val moshi = Moshi.Builder().build()
    private var flagOnCreate: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(PREF, Context.MODE_PRIVATE)

        arrayImages = getArrayImages()

        flagOnCreate = true

        initViews()
    }

    override fun onResume() {
        super.onResume()
        if (!flagOnCreate)
            arrayImages = getArrayImages()
        flagOnCreate = false
        println(arrayImages.arrayImage[indexImage].likeImage)
        initViews()
    }

    @JvmName("getArrayImages1")
    private fun getArrayImages() =
        sharedPreferences.getString(IMAGE_PREFERNCES, null)?.let {
            return@let try {
                moshi.adapter(ArrayImage::class.java).fromJson(it)
            } catch (ex: Exception) {
                ArrayImage()
            }
        }?: ArrayImage()

    private fun initViews() {
        btnNext = findViewById(R.id.imgNext)
        btnBack = findViewById(R.id.imgBack)
        txtInfo = findViewById(R.id.showMore)
        imageView = findViewById(R.id.imgPrincipal)

        imageView.setImageResource(arrayImages.arrayImage[indexImage].src!!)
    }

    fun more(view: View) {
        startActivity(Intent(this, imageDetail::class.java).apply {
            putExtra("imagen", arrayImages.arrayImage[indexImage])
            putExtra("array", arrayImages)
            putExtra("index", indexImage)
        })
    }

    fun next(view: View) {
        if ( indexImage == (arrayImages.arrayImage.size-1) )
            indexImage = 0
        else
            indexImage++

        chageImage()
    }

    fun back(view: View) {
        if ( indexImage == 0 )
            indexImage = arrayImages.arrayImage.size-1
        else
            indexImage--

        chageImage()
    }

    private fun chageImage() {
        imageView.setImageResource(arrayImages.arrayImage[indexImage].src!!)
    }

    fun add(view: View) {
        startActivity(Intent(this, NewImage::class.java))
    }

}