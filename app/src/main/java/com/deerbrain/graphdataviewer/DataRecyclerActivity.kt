package com.deerbrain.graphdataviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.deerbrain.graphdataviewer.Realm.BuckData
import com.deerbrain.graphdataviewer.Realm.TagDataRealmManager
import kotlinx.android.synthetic.main.activity_data_recycler.*
import kotlinx.android.synthetic.main.graphviewcell.*


//similar to DataTableViewController  inside DataViewer-> DataOverView
class DataRecyclerActivity : AppCompatActivity() {

    //activity needs to be updated to proper spacing
    //activity currently has buttons at the top and needs setup similar to iOS segmented Controller, not buttons


    var rawBuckData: List<BuckData> = emptyList()
    val dataSource = ChartAdapter()
    var displayData: Array<String> = arrayOf("Hour of Day","Time Till Dusk", "Trail Camera")
    var displayedGraphs: ArrayList<GraphRecyclerItem> = ArrayList<GraphRecyclerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_recycler)
        rawBuckData = TagDataRealmManager.allBuckData
        updateRecyclerView()
    }

    fun updateRecyclerView() {
        updateDisplayedGraphs()
        tableView.layoutManager = LinearLayoutManager(this)
        val tableViewAdapter = ChartAdapter()
        tableView.adapter =  tableViewAdapter
        tableViewAdapter.update(displayedGraphs)

    }

    fun updateDisplayedGraphs() {
        var graphOne = GraphRecyclerItem (
            theHeaderLabel = "Hour of day"
            // graphData = DeerChartCalcs.hourOfDayData(rawBuckData)
        )
        displayedGraphs.add(graphOne)

        var graphTwo = GraphRecyclerItem(
            theHeaderLabel = "Time Since 6 AM"
            //graphData = DeerChartCalcs.timeSince6AM(rawBuckData)
        )
        displayedGraphs.add(graphTwo)

        var graphThree = GraphRecyclerItem(
            theHeaderLabel = "Trail Cameras"
            //graphData = DeerChartCalcs.sightingsPerCam(rawBuckData)
        )
        displayedGraphs.add(graphThree)
    }
}
