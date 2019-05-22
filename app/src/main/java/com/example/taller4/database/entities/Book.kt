package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="books")
data class Book (
    @ColumnInfo(name = "book_title")
    val title:String,

    @ColumnInfo(name = "book_author")
    val idauthor:int,

    @ColumnInfo(name = "book_edition")
    val edition:int,

    @ColumnInfo(name = "book_isbn")
    val isbn:String,

    @ColumnInfo(name = "book_summary")
    val summary:String,

    @ColumnInfo(name = "book_tag")
    val tag:String,

    @ColumnInfo(name = "book_cover")
    val cover:String,

    @ColumnInfo(name = "book_publisher")
    val idpublisher:int

){
    @PrimaryKey(autoGenerate = true)
    var id:int=0
}