package com.kienct.fandemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.area_layout.view.*

class AreaAdapter(private val areas: List<Area>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.area_layout, parent, false)
        return AreaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return areas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AreaViewHolder) {
            holder.bind(areas[position])
        }
    }

    inner class AreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(area: Area) {
            val key: TextView = itemView.tvKey
            val areaName: TextView = itemView.tvLocalizedName
            val provinceName: TextView = itemView.tvProvinceName
            val latitude: TextView = itemView.tvLatitude
            val longitude: TextView = itemView.tvLongitude
            key.text = area.key
            areaName.text = area.localizedName
            provinceName.text = area.area.EnglishName
            latitude.text = area.geoPosition.latitude
            longitude.text = area.geoPosition.longitude
        }
    }
}