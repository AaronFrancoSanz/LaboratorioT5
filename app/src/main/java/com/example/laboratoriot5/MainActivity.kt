package com.example.laboratoriot5

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Lista que guarda todas las etapas de la misión
    private lateinit var listaEtapas: List<Etapa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Añade la opción para abandonar la misión en la barra superior
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val opcionAbandonar = toolbar.menu.add("Abandonar Misión")
        opcionAbandonar.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)

        // Cierra todas las actividades de la aplicación al abandonar
        toolbar.setOnMenuItemClickListener { item ->
            if (item == opcionAbandonar) {
                finishAffinity()
                true
            } else {
                false
            }
        }

        listaEtapas = listOf(
            Etapa(android.R.drawable.ic_menu_compass, "La Comarca", "Inexistente"),
            Etapa(android.R.drawable.ic_dialog_map, "Rivendel", "Baja"),
            Etapa(android.R.drawable.ic_menu_search, "Las Minas de Moria", "Muy Alta"),
            Etapa(android.R.drawable.ic_menu_directions, "Lothlórien", "Baja"),
            Etapa(android.R.drawable.ic_menu_myplaces, "Las Torres de Gondor", "Media"),
            Etapa(android.R.drawable.ic_menu_report_image, "Ciénaga de los Muertos", "Alta"),
            Etapa(android.R.drawable.ic_dialog_alert, "El Monte del Destino", "Crítica")
        )

        // Conecta la lista de etapas con el ListView para mostrarlas en pantalla
        val listView = findViewById<ListView>(R.id.ListView)
        val adapter = EtapaAdapter(this, listaEtapas)
        listView.adapter = adapter

        // Permite abrir el menú contextual al mantener pulsada una etapa
        registerForContextMenu(listView)
    }

    // Crea el menú que aparece al mantener pulsada una etapa
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Opciones de etapa")
        menu?.add(0, 1, 0, "Inspeccionar Terreno")
    }

    // Controla qué ocurre al seleccionar una opción del menú contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo

        return when (item.itemId) {
            1 -> {
                // Obtiene la etapa que se ha seleccionado
                val etapaSeleccionada = listaEtapas[info.position]

                // Abre la pantalla de detalles y le pasa los datos de la etapa
                val intent = Intent(this, DetalleActivity::class.java).apply {
                    putExtra("EXTRA_LOC", etapaSeleccionada.localizacion)
                    putExtra("EXTRA_PELIGRO", etapaSeleccionada.peligrosidad)
                }
                startActivity(intent)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
