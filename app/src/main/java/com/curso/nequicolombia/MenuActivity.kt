package com.curso.nequicolombia

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MenuActivity: AppCompatActivity(){

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var retiro:SharedPreferences
    private var valorVisible = false

    //@SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId", "ResourceType", "WrongViewCast")
    override fun onCreate(savedIntanceState: Bundle?) {
        val savedInstanceState = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        //Mostrar el aumento
        val textViewAmount = findViewById<TextView>(R.id.textViewAument)


        //Boton flotante
        val fab = findViewById<ImageView>(R.id.fab)


        //Consiganr
        sharedPreferences = getSharedPreferences ("Msaldo", Context.MODE_PRIVATE)
        val nvoSaldo =  sharedPreferences.getFloat("saldo", 0.0f)
        textViewAmount.text = "Disponible \n\n "


        val mostarCode = findViewById<ImageView>(R.id.imageViewoDispo)
        val tvValor = findViewById<TextView>(R.id.tvValorDispo)

        mostarCode.setOnClickListener{
            valorVisible = !valorVisible

            if(valorVisible){
                tvValor.text = "$ $nvoSaldo"
            }else{
                tvValor.text="****"
            }
        }





        //BOTONES FLOTANTES
        fab.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val view = LayoutInflater.from(this).inflate(R.layout.botton_des, null)
            dialog.setContentView(view)

            val consignar = view.findViewById<FloatingActionButton>(R.id.consignar)
            val retirar = view.findViewById<FloatingActionButton>(R.id.retirar)
            val servicios = view.findViewById<FloatingActionButton>(R.id.servicios)
            val close = view.findViewById<FloatingActionButton>(R.id.close)

            consignar.setOnClickListener {
                val intent = Intent(this, ConsignarActivity::class.java)
                startActivity(intent)
            }

            retirar.setOnClickListener {
                val intent = Intent(this, RetirarActivity::class.java)
                startActivity(intent)
            }
            servicios.setOnClickListener {
                val intent = Intent(this, ServiciosActivity::class.java)
                startActivity(intent)
            }

            close.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val textViewAmount = findViewById<TextView>(R.id.textViewAument)


        if(requestCode == 1 && resultCode == Activity.RESULT_OK && data !=null){
            val nuevoSaldo = data.getFloatExtra("nvSaldo", 0.0f)
            textViewAmount.text = "Disponible $nuevoSaldo"
        }
    }
}





