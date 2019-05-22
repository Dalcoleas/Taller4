package com.example.taller4.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4.database.entities.Book


@Dao
interface BookDao {

    @Query("SELECT*FROM books")
    fun getAll(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(book: Book)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM books")
    fun nukeTable()//elimina la tabla


    @Query("SELECT * FROM books WHERE book_title LIKE :search ")
    fun findBookbyTitle(search: String): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE book_title LIKE :search ")
    fun findBookbyTitles(search: String): LiveData<List<Book>>

}