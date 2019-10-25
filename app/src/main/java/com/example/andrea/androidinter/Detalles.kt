package com.example.andrea.androidinter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detalles.*

class Detalles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)
        //---------------------------------------Recuperar datos del intent y mostrarlos en la vista
        val producto = this.intent.extras.getSerializable("Producto") as Producto
        nombre_detalles.text = producto.name
        try {
            Glide.with(applicationContext).load(producto.image).into(imagen_detalles)
        }catch (e : Exception){
            Log.e("Excepcion", e.printStackTrace().toString())
        }
        precio_detalles.text = "$"+ producto.price.toString() + "0"

        //-------------------------------------------------------------------------------------
        //------------------------------------------------------Toolbar
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        /* Mostrar los productos que hemos agregado*
           ---> Ir a una nueva actividad
         */
        val intent = Intent(this, Carrito::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }


}
