
package com.example.taller4.database.entities

import androidx.room.*

@Entity(tableName = "bookxauthors",foreignKeys =
    [ForeignKey (entity = Book::class, parentColumns = ["id"],childColumns = ["idBook"]),
    ForeignKey(entity = Author::class,parentColumns = ["id"],childColumns = ["idAuthor"] )],
    primaryKeys = ["idBook","idAuthor"])
data class BookXAuthor(
    val idAuthor:Int,
    val idBook:Int
)