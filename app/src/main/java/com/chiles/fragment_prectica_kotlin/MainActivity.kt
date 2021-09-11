package com.chiles.fragment_prectica_kotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.squareup.moshi.Moshi

class MainActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences
    var moshi = Moshi.Builder().build()
    var PREF = "MY_PREFERENCES"
    var docPrference = "ARRAY_PREFERENCE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // * Inicializar el fragment en el carousel de imagenes
        supportFragmentManager.beginTransaction().apply {
            add(R.id.frgmtContainer, CarouselFragment())
            addToBackStack(CarouselFragment().tag)
            commit()
        }

        preferences = getSharedPreferences(PREF, Context.MODE_PRIVATE)

    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                R.anim.slide_inrigth,
                R.anim.slide_outleft,
                R.anim.slide_inleft,
                R.anim.slide_outrigth
            )
            replace(R.id.frgmtContainer, fragment)
            addToBackStack(CarouselFragment().tag)
            commit()
        }
    }
}