
package com.example.taller4.database.entities

import androidx.room.*


class BookXAuthor{
    @Embedded
    var book: Book = Book(0,"",0,"","","",0)

    @Relation(parentColumn = "id",
        entityColumn = "book_id",
        entity = Author::class)
    var authors: List<Author> = listOf()
}