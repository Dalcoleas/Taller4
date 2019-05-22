package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="tags")
data class Tag (
        @ColumnInfo(name = "tag_name")
        val tag_name:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}


