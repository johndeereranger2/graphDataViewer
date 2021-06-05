package com.deerbrain.graphdataviewer.Realm

import android.util.Log
import com.deerbrain.graphdataviewer.Charts.TimDataStruct


object TagDataRealmManager {

    fun addArrayData(timArray: ArrayList<TimDataStruct>) {


        for (item in timArray) {
            var id = (RealmWrapper.realm.where(BuckData::class.java).max("id")?.toInt() ?: 0) + 1
            val newItem = BuckData()
            newItem.id = id
            newItem.cameraLocationName = item.locationName
            newItem.buckTag = item.name
            newItem.photoDateString = item.photoDate


            RealmWrapper.realm.executeTransaction{
                it.insert(newItem)
            }
            Log.i("Realm", "Stored Marker at ${id} ${item.photoDate}")
        }


    }

}