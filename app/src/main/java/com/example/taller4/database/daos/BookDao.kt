package com.example.taller4.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4.database.entities.Author
import com.example.taller4.database.entities.Book
import com.example.taller4.database.entities.Publisher
import com.example.taller4.database.entities.Tag


@Dao
interface BookDao {

    @Query("SELECT*FROM books")
    fun getAll(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(book: Book)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM books")
    fun deleteTable()//elimina la tabla


    @Query("SELECT * FROM books WHERE book_title LIKE :search ")
    fun findBookbyTitle(search: String): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE book_isbn LIKE :search ")
    fun findBookbyIsbn(search: String): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE book_summary LIKE :search ")
    fun findBookbySummary(search: String): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE book_edition LIKE :search ")
    fun findBookbyEdition(search: Int): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE book_publisher LIKE :search ")
    fun findBookbyPublisher(search: Int): LiveData<List<Book>>

    @Query("SELECT b.book_cover,b.book_edition,b.book_isbn,b.book_publisher,b.book_summary,b.book_title,b.id FROM books b INNER JOIN bookxauthors ba ON b.id=ba.idBook INNER JOIN authors a ON ba.idAuthor = a.id INNER JOIN bookxtags bt ON b.id=bt.idBook INNER JOIN tags t ON t.id=bt.idTag ")
    fun getAllFull():LiveData<List<Book>>
    @Query("SELECT * FROM authors INNER JOIN bookxauthors ON authors.id = idAuthor WHERE :bookId = idBook")
    fun getAuthors(bookId: Int):LiveData<List<Author>>
    @Query("SELECT * FROM tags INNER JOIN bookxtags ON tags.id = idTag WHERE :bookId = idBook")
    fun getTag(bookId: Int):LiveData<List<Tag>>
    @Query("SELECT * FROM publishers INNER JOIN books ON publishers.id = books.id WHERE :bookId = books.id")
    fun getPublisher(bookId: Int):LiveData<Publisher>

}