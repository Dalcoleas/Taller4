package com.example.taller4.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.taller4.database.daos.BookDao
import com.example.taller4.database.entities.Author
import com.example.taller4.database.entities.Book

class BookRepository(private val bookDao : BookDao){


    var allBooks : LiveData<List<Book>> = bookDao.getAll()



    @WorkerThread
    suspend fun insert(book: Book){

        bookDao.insert(book)

    }
    @WorkerThread
    fun searchByTitle(title : String){
        allBooks = bookDao.findBookbyTitle(title)
    }

    @WorkerThread
    fun authors(bookid : Int) : LiveData<List<Author>> =
        bookDao.getAuthors(bookid)


}