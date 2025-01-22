package com.example.flowchart_22041039

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlowchartListAdapter(private val listFlowchart: ArrayList<Flowchart>) :
    RecyclerView.Adapter<FlowchartListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_flowchart_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, image) = listFlowchart[position]
        holder.gambarflowchart.setImageResource(image)
        holder.namaflowchart.text = name
    }

    override fun getItemCount(): Int = listFlowchart.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambarflowchart: ImageView = itemView.findViewById(R.id.img_item_flowchart_list)
        val namaflowchart: TextView = itemView.findViewById(R.id.tv_namaflowchart_list)
    }
}