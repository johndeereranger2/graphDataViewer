package com.deerbrain.graphdataviewer.Charts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deerbrain.graphdataviewer.R


//this is similar to baseGraphViewController
class BaseGraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_graph)
    }
}