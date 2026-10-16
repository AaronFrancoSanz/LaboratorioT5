package com.example.laboratoriot5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Al elegir la opción "Inspeccionar Terreno" aparecerá el nombre de la etapa y el nivel de peligro
class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detalle)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Nombre de la etapa
        val nombre = intent.getStringExtra("EXTRA_LOC") ?: "Etapa desconocida"
        // Nivel de peligro
        val peligro = intent.getStringExtra("EXTRA_PELIGRO") ?: "Desconocido"

        findViewById<TextView>(R.id.txtDetalleNombre).text = nombre
        findViewById<TextView>(R.id.txtDetallePeligro).text = "Nivel de peligro: $peligro"

        findViewById<Button>(R.id.btnVolver).setOnClickListener {
            finish()
        }
    }
}
