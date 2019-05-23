package com.example.taller4.database.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4.database.entities.BookXAuthor
import com.example.taller4.database.entities.BookXTag


interface BookXTagDao {

    @Query("SELECT * FROM bookxtags")
    fun getBookXTag():List<BookXTag>

    @Query("SELECT * FROM bookxtags WHERE idbook = :bookId")
    fun getBookXAuthorId(bookId : Int):List<BookXTag>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(bookXTag: BookXTag)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM bookxtags")
    fun nukeTable()//elimina la tabla

}