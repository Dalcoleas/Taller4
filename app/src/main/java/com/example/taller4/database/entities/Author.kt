package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="authors")
data class Author (
    @ColumnInfo(name = "author_name")
    val author_name:String,

    @ColumnInfo(name = "author_last_name")
    val author_last_name:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}