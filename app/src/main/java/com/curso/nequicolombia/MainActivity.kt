package com.curso.nequicolombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        setContentView(R.layout.activity_main)

    }

    fun enviarNumero(view: View){
        val editTextphone = findViewById<EditText>(R.id.editTextphone)
        val numero = editTextphone.text.toString()

        if (numero.length == 10 && numero == "3233268532"){
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }else {
            editTextphone.error="Numero incorrecto"
        }

    }


}