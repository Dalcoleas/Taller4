package com.example.taller4.database.daos

import androidx.room.Query
import com.example.taller4.database.entities.BookXAuthor

interface BookXAuthorDao {

    @Query("SELECT * FROM books")
    fun getBookXAuthor():List<BookXAuthor>

    @Query("SELECT * FROM books WHERE id = :bookId")
    fun getBookXAuthorId(bookId : Int):List<BookXAuthor>

    @Query("SELECT authors.author_name, authors.author_last_name FROM authors,books WHERE ")


}