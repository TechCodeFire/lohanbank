package com.curso.nequicolombia

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.StringBuilder
import kotlin.random.Random

class RetirarActivity: AppCompatActivity() {

    private var valorVisible = false

    override fun onCreate(savedIntanceState: Bundle?) {
        val savedInstanceState = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retirar)

        val volver: Button = findViewById(R.id.btnvolver)
        val genCodeTextView: TextView = findViewById(R.id.genCodeTextView)

        val randomCode = generateRandomCode()
        genCodeTextView.text = randomCode

        val mostarCode = findViewById<ImageView>(R.id.imageView10)
        val tvValor = findViewById<TextView>(R.id.tvValor)

        mostarCode.setOnClickListener{
            valorVisible = !valorVisible

            if(valorVisible){
                tvValor.text = randomCode
            }else{
                tvValor.text="****"
            }
        }

        //        ***FUN PARA CODIGO DE RETIRO***



        volver.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    fun generateRandomCode(): String {


        val random = Random(System.currentTimeMillis())
        val code = StringBuilder()

        for (i in 1..4) {
            val random = random.nextInt(0, 10)
            code.append(random)
        }
        return code.toString()
    }

}

//        ***FUN PARA RETIRO DINAMICO***

//        val canRetirar = findViewById<EditText>(R.id.canRetirar)
//        val codRetirar = findViewById<EditText>(R.id.codRetirar)
//        val btnRetirar = findViewById<Button>(R.id.btnRetirar)
////        val tvResultado = findViewById<TextView>(R.id.tvResultado)
//
//
//        btnRetirar.setOnClickListener {
//            val retiro = canRetirar.text.toString().toFloatOrNull() ?: 0.0F
//            val code = codRetirar.text.toString()
//
//            val sharedPreferences = getSharedPreferences("Msaldo", Context.MODE_PRIVATE)
//            val editor = sharedPreferences.edit()
//
//            val saldoActual = sharedPreferences.getFloat("saldo", 0.0f)
//
//            if (saldoActual >= retiro) {
//                if(code=="1234"){
//                    val nuevoSaldo = saldoActual - retiro
//                    editor.putFloat("saldo", nuevoSaldo)
//                    editor.apply()
//
//                    Toast.makeText(this, "Retiro Exitoso", Toast.LENGTH_SHORT).show()
//
//                    val intent = Intent(this, MenuActivity::class.java)
//                    startActivity(intent)
//
//                    canRetirar.text.clear()
//                }else{
//                    Toast.makeText(this, "Codigo incorrecto", Toast.LENGTH_SHORT).show()
//
//                }
//
//            }else{
//                Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
//            }
//        }




