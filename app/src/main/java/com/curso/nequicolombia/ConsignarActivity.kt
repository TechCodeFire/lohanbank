package com.curso.nequicolombia

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.time.temporal.TemporalAmount
import kotlin.math.log

class ConsignarActivity: AppCompatActivity() {

    override fun onCreate(savedIntanceState: Bundle?) {
        val savedInstanceState = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consignar)


        val numtel = findViewById<EditText>(R.id.editTextPhone)
        val etAmount = findViewById<EditText>(R.id.editTextNumber)
        val btnConsign = findViewById<Button>(R.id.buttoncon)
        val volver = findViewById<Button>(R.id.btnvolver)

        volver.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }


        btnConsign.setOnClickListener {

            // Obtener la cantidad ingresada por el usuario
            val aumentText = etAmount.text.toString().toFloatOrNull() ?: 0.0f
            val telefono = numtel.text.toString()

            val sharedPreferences = getSharedPreferences("Msaldo", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            val saldoActual = sharedPreferences.getFloat("saldo", 0.0f)

            if(aumentText > 0) {
                if( telefono == "3233268532") {
                    val nSaldo = saldoActual + aumentText
                    editor.putFloat("saldo", nSaldo)
                    editor.apply()

                    val intent = Intent(this, MenuActivity::class.java)

                    startActivity(intent)
                    // Mostrar un mensaje de éxito

                    etAmount.text.clear()
                }else{
                    Toast.makeText(this, "Numero de telefono incorrecto", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Cantidad no valida", Toast.LENGTH_SHORT).show()
            }

            //Toast.makeText(this, "Consignacion Exitosa: $saldo", Toast.LENGTH_SHORT).show()


        }
    }

}

