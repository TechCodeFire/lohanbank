package com.curso.nequicolombia

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    // Tiempo en milisegundos que el splash screen estará visible
    private val SPLASH_TIME_OUT: Long = 5000 // 4 segundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Usamos un Handler para retrasar el lanzamiento de la siguiente actividad
        Handler().postDelayed({
            // Creamos un Intent para iniciar la actividad principal
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Cerramos la actividad actual
            finish()
        }, SPLASH_TIME_OUT)
    }
}
