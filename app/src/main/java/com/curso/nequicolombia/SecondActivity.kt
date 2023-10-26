package com.curso.nequicolombia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class SecondActivity: AppCompatActivity(){

    private lateinit var editTextNumberPassword: EditText
    private lateinit var editTextNumberPassword2: EditText
    private lateinit var editTextNumberPassword3: EditText
    private lateinit var editTextNumberPassword4: EditText
    private lateinit var button: Button

    private val contraseña = "1234"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editTextNumberPassword = findViewById(R.id.editTextNumberPassword)
        editTextNumberPassword2 = findViewById(R.id.editTextNumberPassword2)
        editTextNumberPassword3 = findViewById(R.id.editTextNumberPassword3)
        editTextNumberPassword4 = findViewById(R.id.editTextNumberPassword4)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val password1 = editTextNumberPassword.text.toString()
            val password2 = editTextNumberPassword2.text.toString()
            val password3 = editTextNumberPassword3.text.toString()
            val password4 = editTextNumberPassword4.text.toString()
            val contraseñaIngresada = "$password1$password2$password3$password4"

            if (contraseñaIngresada == contraseña) {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }

        val numeroIngresado = intent.getStringExtra("numeroIngresado")

        val textViewNumero: TextView = findViewById(R.id.textView2)
        textViewNumero.text = "Número ingresado: $numeroIngresado"

        val editTextNumberPassword = findViewById<EditText>(R.id.editTextNumberPassword)
        val editTextNumberPassword2 = findViewById<EditText>(R.id.editTextNumberPassword2)
        val editTextNumberPassword3 = findViewById<EditText>(R.id.editTextNumberPassword3)
        val editTextNumberPassword4 = findViewById<EditText>(R.id.editTextNumberPassword4)

        editTextNumberPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    editTextNumberPassword2.requestFocus()
                }
            }
        })

        editTextNumberPassword2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    editTextNumberPassword3.requestFocus()
                }
            }
        })

        editTextNumberPassword3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    editTextNumberPassword4.requestFocus()
                }
            }
        })

        editTextNumberPassword4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 0) {
                    editTextNumberPassword3.requestFocus()
                }
            }
        })


    }
}

