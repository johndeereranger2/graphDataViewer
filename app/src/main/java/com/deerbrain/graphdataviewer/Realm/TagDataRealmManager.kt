package com.deerbrain.graphdataviewer.Realm

import com.deerbrain.graphdataviewer.Charts.TimDataStruct


object TagDataRealmManager {

    fun addArrayData(timArray: ArrayList<TimDataStruct>) {
        var id = (RealmWrapper.realm.where(MapPolys::class.java).max("id")?.toInt() ?: 0) + 1
    }

}