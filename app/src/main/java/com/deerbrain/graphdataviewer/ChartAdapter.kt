package com.deerbrain.graphdataviewer

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class ChartAdapter() : RecyclerView.Adapter<ChartRecyclerItem> {
    var items = mutableListOf<ChartRecyclerItem>()

    var displayData: Array<String> = arrayOf("Hour of Day","Time Till Dusk", "Trail Camera")

    private var onClickListener: OnClickListener? = null

    ///numberOf rows
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartRecyclerItem {
        val termView = LayoutInflater.from(parent.context).inflate(R.layout.termcells, parent, false)
        return ChartRecyclerItem(termView)
    }

    override fun onBindViewHolder(holder: ChartRecyclerItem, position: Int) {
        when (displayData[position]) {
            "Hour of Day" -> {
                ChartRecyclerItem.data = TableCellData(title: "Sightings by Hour of Day", type: .hourOfDay, data: DeerChartCalcs().hourOfDayData,
                DeerChartCalcs.hourOfDayData.maxY)
            }
            "Time Till Dusk" -> {
                ChartRecyclerItem.data = TableCellData(title: "Time Till Dusk", type: .hourOfDay, data: DeerChartCalcs().timeTillDusk,
                DeerChartCalcs.timeTillDusk.maxY)
            }
            "Trail Camera" -> {
                ChartRecyclerItem.data = TableCellData(title: "Trail Camera", type: .hourOfDay, data: DeerChartCalcs().Trail Camera,
                DeerChartCalcs.Trail Camera.maxY)
                //this will be a pie graph and the others will be a chart
            }


        }

    }

    fun setOnClickListener(itemPressed: OnClickListener) {
        this.onClickListener = itemPressed
    }

    interface OnClickListener {
        fun onClick(position: Int, model: ChartRecyclerItem)
    }



}