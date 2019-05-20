package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="publishers")
data class Book (
    @ColumnInfo(name = "book_title")
    val title:String,

    @ColumnInfo(name = "book_author")
    val author:String,

    @ColumnInfo(name = "book_edition")
    val edition:String,

    @ColumnInfo(name = "book_lsvn")
    val lsvn:String,

    @ColumnInfo(name = "book_resume")
    val resume:String,

    @ColumnInfo(name = "book_tag")
    val tag:String,

    @ColumnInfo(name = "book_portada")
    val portada:String,

    @ColumnInfo(name = "book_publisher")
    val publisher:String

){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}