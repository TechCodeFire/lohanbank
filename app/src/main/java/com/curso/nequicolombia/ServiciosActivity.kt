package com.curso.nequicolombia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

open class ServiciosActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedIntanceState: Bundle?) {
        val savedInstanceState = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)

        val imageViewLuz = findViewById<ImageView>(R.id.imageViewLuz)
        val imageViewGas = findViewById<ImageView>(R.id.imageViewGas)
        val imageViewAgua = findViewById<ImageView>(R.id.imageViewAgua)
        val volver = findViewById<Button>(R.id.btnvolver)

        volver.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }


        imageViewLuz.setOnClickListener{
            val intent = Intent(this, LuzActivity::class.java)
            startActivity(intent)
        }
        imageViewGas.setOnClickListener{
            val intent = Intent(this, GasActivity::class.java)
            startActivity(intent)
        }
        imageViewAgua.setOnClickListener{
            val intent = Intent(this, AguaActivity::class.java)
            startActivity(intent)
        }

    }
}