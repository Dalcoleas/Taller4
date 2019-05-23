package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.taller4.database.daos.TagDao

@Entity(tableName = "bookxtags",foreignKeys =
[ForeignKey (entity = Book::class, parentColumns = ["id"],childColumns = ["idBook"]),
    ForeignKey(entity = Tag::class,parentColumns = ["id"],childColumns = ["idTag"] )],
    primaryKeys = ["idBook","idTag"])
data class BookXTag(
    val idTag:Int,
    val idBook:Int
)