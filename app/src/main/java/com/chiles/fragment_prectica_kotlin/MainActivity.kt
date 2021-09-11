package com.chiles.fragment_prectica_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

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
}