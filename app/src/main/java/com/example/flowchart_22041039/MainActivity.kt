package com.example.flowchart_22041039

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFlowchart: RecyclerView
    private val list = ArrayList<Flowchart>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvFlowchart = findViewById(R.id.rv_flowchart)
        rvFlowchart.setHasFixedSize(true)

        list.addAll(getListFlowchart())
        showRecyclerList()
    }

    private fun getListFlowchart(): ArrayList<Flowchart> {
        val dataName = resources.getStringArray(R.array.name_flowchart)
        val dataPhoto = resources.obtainTypedArray(R.array.gambar_flowchart)
        val listFlowchart = ArrayList<Flowchart>()
        for (i in dataName.indices) {
            val flowchart = Flowchart(dataName[i], dataPhoto.getResourceId(i, -1))
            listFlowchart.add(flowchart)
        }
        return listFlowchart
    }

    private fun showRecyclerList() {
        rvFlowchart.layoutManager = LinearLayoutManager(this)
        val listFlowchartAdapter = FlowchartListAdapter(list)
        rvFlowchart.adapter = listFlowchartAdapter
    }

    private fun showRecyclerGrid() {
        rvFlowchart.layoutManager = GridLayoutManager(this, 4)
        val GridFlowchartAdapter = FlowchartGridAdapter(list)
        rvFlowchart.adapter = GridFlowchartAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_utama, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.list -> {
                showRecyclerList()
            }

            R.id.grid -> {
                showRecyclerGrid()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}