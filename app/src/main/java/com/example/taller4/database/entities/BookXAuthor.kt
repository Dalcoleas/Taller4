
package com.example.taller4.database.entities

import androidx.room.*

@Entity(tableName = "bookxauthors")
data class BookXAuthor(

    @PrimaryKey(autoGenerate = false)
    @ForeignKey(entity = Author::class,parentColumns = arrayOf("id"),childColumns = arrayOf("idAuthor"),onDelete = ForeignKey.CASCADE )
    @ColumnInfo(name = "idAuthor")
    val idAuthor:Int,
    @ForeignKey(entity = Book::class,parentColumns = arrayOf("id"),childColumns = arrayOf("idBook") ,onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "idBook")
    val idBook:Int

)