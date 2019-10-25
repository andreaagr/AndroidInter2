package com.example.andrea.androidinter

import android.annotation.TargetApi
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.AsyncTask
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.widget.Toast
import com.example.andrea.androidinter.R.drawable.fondo_dr
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_password.*
import kotlinx.android.synthetic.main.activity_registro.*



class MainActivity : AppCompatActivity() {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        crear_cuenta.setOnClickListener {
            linear_login.setBackgroundResource(R.drawable.fondo_dr)
            val anim_bg: AnimationDrawable = linear_login.background as AnimationDrawable
            iniciar_transicion(anim_bg,1)

        }
        login_forgot.setOnClickListener {
            linear_login.setBackgroundResource(R.drawable.fondo_con)
            val anim_bg: AnimationDrawable = linear_login.background as AnimationDrawable
            iniciar_transicion(anim_bg,2)
        }
        login.setOnClickListener {
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }
    private fun iniciar_transicion(animacion : AnimationDrawable, caso : Int){
            login.isEnabled = false
            crear_cuenta.isEnabled = false
            login_forgot.isEnabled = false
            animacion.setEnterFadeDuration(3000)
            animacion.setExitFadeDuration(3000)
            animacion.start()

            val manejador = Handler()
            manejador.postDelayed({
                login.isEnabled = true
                crear_cuenta.isEnabled = true
                login_forgot.isEnabled = true
                animacion.stop()
                if(caso == 1){
                    val intent = Intent(this, Registro::class.java)
                    startActivity(intent)
                }else{
                    val intent = Intent(this, Password::class.java)
                    startActivity(intent)
                }
            }, 3700)
    }

}
