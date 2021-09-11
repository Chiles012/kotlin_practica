package com.chiles.fragment_prectica_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // * Inicializar el fragment en el carousel de imagenes
        supportFragmentManager.beginTransaction().apply {
            add(R.id.frgmtContainer, CarouselFragment())
            addToBackStack(CarouselFragment().tag)
            commit()
        }

    }

    fun changeFragment(fragment: Fragment, picture: Picture) {
        supportFragmentManager.beginTransaction().apply {
            Bundle().apply {
                putParcelable("picture", picture)
            }
            replace(R.id.frgmtContainer, fragment)
            addToBackStack(CarouselFragment().tag)
            commit()
        }
    }
}