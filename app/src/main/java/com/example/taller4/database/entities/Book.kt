package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName="books")
data class Book (
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,

    @ColumnInfo(name = "book_title")
    val title:String,

    @ColumnInfo(name = "book_edition")
    val edition:Int,

    @ColumnInfo(name = "book_isbn")
    val isbn:String,

    @ColumnInfo(name = "book_summary")
    val summary:String,

    @ColumnInfo(name = "book_cover")
    val cover:String,

    @ColumnInfo(name = "book_publisher")
    val idpublisher:Int,

    @Ignore
    val authors : List<Author>,

    @Ignore
    val tags : List<Tag>



)