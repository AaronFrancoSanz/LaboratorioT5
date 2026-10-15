package com.example.laboratoriot5

import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView // <-- Asegúrate de tener este import
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val opcionAbandonar = toolbar.menu.add("Abandonar Misión")
        opcionAbandonar.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)

        toolbar.setOnMenuItemClickListener { item ->
            if (item == opcionAbandonar) {
                finishAffinity()
                true
            } else {
                false
            }
        }

        val listaEtapas = listOf(
            Etapa(android.R.drawable.ic_menu_compass, "La Comarca", "Inexistente"),
            Etapa(android.R.drawable.ic_dialog_map, "Rivendel", "Baja"),
            Etapa(android.R.drawable.ic_menu_search, "Las Minas de Moria", "Muy Alta"),
            Etapa(android.R.drawable.ic_menu_directions, "Lothlórien", "Baja"),
            Etapa(android.R.drawable.ic_menu_myplaces, "Las Torres de Gondor", "Media"),
            Etapa(android.R.drawable.ic_menu_report_image, "Ciénaga de los Muertos", "Alta"),
            Etapa(android.R.drawable.ic_dialog_alert, "El Monte del Destino", "Crítica")
        )


        val listView = findViewById<ListView>(R.id.ListView)

        val adapter = EtapaAdapter(this, listaEtapas)

        listView.adapter = adapter
    }
}
