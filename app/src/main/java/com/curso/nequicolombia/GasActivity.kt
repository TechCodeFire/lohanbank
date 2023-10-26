package com.curso.nequicolombia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GasActivity:AppCompatActivity() {
    override fun onCreate(savedIntanceState: Bundle?) {
        val savedInstanceState = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gas)

        val volver = findViewById<Button>(R.id.btnvolver)

        volver.setOnClickListener {
            val intent = Intent(this, ServiciosActivity::class.java)
            startActivity(intent)
        }

    }
}