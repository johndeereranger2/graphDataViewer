package com.deerbrain.graphdataviewer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deerbrain.graphdataviewer.Charts.SampleDataMaker
import com.deerbrain.graphdataviewer.Realm.TagDataRealmManager

class MainActivity : AppCompatActivity() {
    companion object {

        lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SampleDataMaker.createData()

        TagDataRealmManager.addArrayData(SampleDataMaker.dataArray)
        
      //  onClickListener. go to recyclerActivity
        
        
        // go to individualGraphActivity
    }
}
