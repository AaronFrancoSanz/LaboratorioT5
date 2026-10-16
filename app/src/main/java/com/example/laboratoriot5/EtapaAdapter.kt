package com.example.laboratoriot5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

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

        val vista: View = p1 ?: LayoutInflater.from(context)
            .inflate(R.layout.item_etapa, p2, false)

        val etapa = listaEtapas[p0]

        val imgEtapa: ImageView = vista.findViewById(R.id.imgEtapa)
        val txtLocalizacion: TextView = vista.findViewById(R.id.txtLocalizacion)
        val txtPeligrosidad: TextView = vista.findViewById(R.id.txtPeligrosidad)


        imgEtapa.setImageResource(etapa.imagen)
        txtLocalizacion.text = etapa.localizacion
        txtPeligrosidad.text = "Peligro: ${etapa.peligrosidad}"

        return vista
    }
}
