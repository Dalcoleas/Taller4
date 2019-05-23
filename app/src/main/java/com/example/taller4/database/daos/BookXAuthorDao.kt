package com.example.taller4.database.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4.database.entities.BookXAuthor
import com.example.taller4.database.entities.Publisher

interface BookXAuthorDao {

    @Query("SELECT * FROM bookxauthors")
    fun getBookXAuthor():List<BookXAuthor>

    @Query("SELECT * FROM bookxauthors WHERE idbook = :bookId")
    fun getBookXAuthorId(bookId : Int):List<BookXAuthor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(bookXAuthor: BookXAuthor)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM bookxauthors")
    fun nukeTable()//elimina la tabla

}