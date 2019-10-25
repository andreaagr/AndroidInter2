package com.example.andrea.androidinter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Carrito : AppCompatActivity() {
    // ---> Almacenar con Shared Preferences el estado del carrito, es decir al salir no se pierde la información
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)
    }
}
