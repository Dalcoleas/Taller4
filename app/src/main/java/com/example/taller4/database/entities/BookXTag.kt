package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.taller4.database.daos.TagDao

@Entity(tableName = "bookxtags")
data class BookXTag(

    @PrimaryKey(autoGenerate = false)
    @ForeignKey(entity = TagDao::class,parentColumns = arrayOf("id"),childColumns = arrayOf("idTag"),onDelete = ForeignKey.CASCADE )
    @ColumnInfo(name = "idTag")
    val idTag:Int,
    @ForeignKey(entity = Book::class,parentColumns = arrayOf("id"),childColumns = arrayOf("idBook") ,onDelete = ForeignKey.CASCADE)
    @ColumnInfo(name = "idBook")
    val idBook:Int

)