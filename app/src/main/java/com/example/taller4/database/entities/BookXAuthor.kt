
package com.example.taller4.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Author::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("author_id"),
    onDelete = ForeignKey.CASCADE)))