package com.example.flowchart_22041039

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlowchartGridAdapter(private val listFlowchart: ArrayList<Flowchart>) :
    RecyclerView.Adapter<FlowchartGridAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_flowchart_grid, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = listFlowchart.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val (name, image) = listFlowchart[position]
        holder.gambarflowchart.setImageResource(image)
        holder.namaflowchart.text = name
    }

    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambarflowchart: ImageView = itemView.findViewById(R.id.img_item_flowchart_grid)
        val namaflowchart: TextView = itemView.findViewById(R.id.tv_namaflowchart_grid)
    }
}