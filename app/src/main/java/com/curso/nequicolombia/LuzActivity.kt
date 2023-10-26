package com.curso.nequicolombia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.PopupWindow
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LuzActivity: AppCompatActivity() {
    private var popupWindow: PopupWindow? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedIntanceState: Bundle?) {
        val savedInstanceState = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luz)

        val volver = findViewById<Button>(R.id.btnvolver)

        volver.setOnClickListener {
            val intent = Intent(this, ServiciosActivity::class.java)
            startActivity(intent)
        }

        val mostrarBoton = findViewById<Button>(R.id.mostrarBoton)
        mostrarBoton.setOnClickListener {
            if (popupWindow == null || !popupWindow!!.isShowing) {
                val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val view = inflater.inflate(R.layout.popup_layout, null)

                val textView20 = view.findViewById<TextView>(R.id.textView20)
                val textView21 = view.findViewById<TextView>(R.id.textView21)
                val editTextTextPassword = view.findViewById<TextView>(R.id.editTextTextPassword)
                val opcion1Button = view.findViewById<TextView>(R.id.opcion1Button)



                popupWindow = PopupWindow(
                    view,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,

                )

                popupWindow?.elevation = 10.0f // Añade elevación para sombra
                popupWindow?.isOutsideTouchable = true

                popupWindow!!.showAsDropDown(mostrarBoton, 0, 0, Gravity.BOTTOM)

                opcion1Button.setOnClickListener{
                    val codigo = editTextTextPassword.text.toString()
                }

                popupWindow!!.setOnDismissListener {
                    popupWindow = null
                }

            } else {
                popupWindow!!.dismiss()
            }

        }

    }
}

