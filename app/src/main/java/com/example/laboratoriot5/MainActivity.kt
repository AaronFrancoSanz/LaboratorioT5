package com.example.laboratoriot5

import android.os.Bundle
import android.view.MenuItem
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
                finishAffinity() // Cierre controlado de la aplicación
                true
            } else {
                false
            }
        }
    }
}

