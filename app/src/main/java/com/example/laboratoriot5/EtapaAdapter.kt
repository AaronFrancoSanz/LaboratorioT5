package com.example.laboratoriot5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter


class EtapaAdapter(
    private val context: Context,
    private val datasource: List<Etapa>,
    private val layoutId: Int
) : BaseAdapter() {

    override fun getCount(): Int = datasource.size

    override fun getItem(position: Int): Etapa = datasource[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(layoutId, parent, false)
        } else {
            view = convertView
        }
        val etapa = getItem(position)
        return view
    }
}
