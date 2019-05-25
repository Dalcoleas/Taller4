package com.example.taller4.gui.dtos

import com.example.taller4.database.entities.Author
import com.example.taller4.database.entities.Publisher
import com.example.taller4.database.entities.Tag

data class BookDTO(
    val id: Int = 0,
    val title: String,
    val edition: Int,
    val isbn: String,
    val summary: String,
    val cover: String
) {
    lateinit var publisher: Publisher
       var authors: List<Author>
    lateinit var tags: List<Tag>
    init {
        authors = emptyList()
    }
}