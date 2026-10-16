package com.example.laboratoriot5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

// Adaptador que alimenta un ListView para mostrar una miniatura del terreno,
// el nombre de la localización y la peligrosidad del territorio
class EtapaAdapter(
    private val context: Context,
    private val listaEtapas: List<Etapa>

) : BaseAdapter() {

    override fun getCount(): Int {
        return listaEtapas.size
    }

    override fun getItem(p0: Int): Any {
        return listaEtapas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        // Coge el parámetro convertView: si es nulo "inflamos el layout" por primera vez;
        // si no reutilizamos la vista que ya ha salido de la pantalla al hacer scroll
        val vista: View = p1 ?: LayoutInflater.from(context)
            .inflate(R.layout.item_etapa, p2, false)

        // Lista de etapas
        val etapa = listaEtapas[p0]

        // Miniatura del terreno
        val imgEtapa: ImageView = vista.findViewById(R.id.imgEtapa)
        // Nombre de la localización
        val txtLocalizacion: TextView = vista.findViewById(R.id.txtLocalizacion)
        // Peligrosidad del territorio
        val txtPeligrosidad: TextView = vista.findViewById(R.id.txtPeligrosidad)


        imgEtapa.setImageResource(etapa.imagen)
        txtLocalizacion.text = etapa.localizacion
        txtPeligrosidad.text = "Peligro: ${etapa.peligrosidad}"

        return vista
    }
}
