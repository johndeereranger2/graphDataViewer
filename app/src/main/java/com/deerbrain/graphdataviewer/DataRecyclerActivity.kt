package com.deerbrain.graphdataviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


//similar to DataTableViewController  inside DataViewer-> DataOverView
class DataRecyclerActivity : AppCompatActivity() {

    val dataSource = ChartAdapter()
    var displayData: Array<String> = arrayOf("Hour of Day","Time Till Dusk", "Trail Camera")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_recycler)
        updateRecyclerView()
    }

    fun updateRecyclerView() {
        //recycler view implimentations
        
    }
}