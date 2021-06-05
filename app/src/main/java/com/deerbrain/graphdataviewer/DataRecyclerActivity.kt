package com.deerbrain.graphdataviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_data_recycler.*
import kotlinx.android.synthetic.main.graphviewcell.*


//similar to DataTableViewController  inside DataViewer-> DataOverView
class DataRecyclerActivity : AppCompatActivity() {

    //activity needs to be updated to proper spacing
    //activity currently has buttons at the top and needs setup similar to iOS segmented Controller, not buttons

    val dataSource = ChartAdapter()
    var displayData: Array<String> = arrayOf("Hour of Day","Time Till Dusk", "Trail Camera")
    var displayedGraphs: ArrayList<GraphRecyclerItem> = ArrayList<GraphRecyclerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_recycler)
        updateRecyclerView()
    }

    fun updateRecyclerView() {
        updateDisplayedGraphs()
        tableView.layoutManager = LinearLayoutManager(this)
        val tableViewAdapter = ChartAdapter()
        tableView.adapter =  tableViewAdapter
        tableViewAdapter.update(displayedGraphs)
        //chartAdapter.data = TagDataRealmManager.instance.getAllData()
        //recycler view implimentations

    }

    fun updateDisplayedGraphs() {
        var graphOne = GraphRecyclerItem (
            theHeaderLabel = "Hour of day"
            //graphData = DeerChartCalcs.CalcHourOfDay(rawData: rawBuckData)
        )
        displayedGraphs.add(graphOne)

        var graphTwo = GraphRecyclerItem(
            theHeaderLabel = "Time Since 6 AM"
            //graphData = DeerChartCalcs.CalcTimeSince6am(rawData: rawBuckData)
        )
        displayedGraphs.add(graphTwo)

        var graphThree = GraphRecyclerItem(
            theHeaderLabel = "Trail Cameras"
            //graphData = DeerChartCalcs.CalcTrailCameraQty(rawData: rawBuckData)
        )
        displayedGraphs.add(graphThree)
    }
}
