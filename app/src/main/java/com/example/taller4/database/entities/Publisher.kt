package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="publishers")
data class Publisher (
    @ColumnInfo(name = "publisher_name")
    val publisher_name:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}