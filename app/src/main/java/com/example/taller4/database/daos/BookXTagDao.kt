package com.example.taller4.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4.database.entities.BookXTag
import com.example.taller4.database.entities.Tag

@Dao
interface BookXTagDao {

    @Query("SELECT * FROM tags INNER JOIN bookxtags ON tags.id = idTag WHERE :bookId = idBook")
    fun gettags(bookId: Int):List<Tag>

    @Query("SELECT * FROM BookXTags")
    fun getBookXtagId():List<BookXTag>

    //obtener lista de tags que coincidan
    @Query("SELECT * FROM tags INNER JOIN bookxtags ON tags.id = idTag WHERE tag_name like :search")
    fun finndByTag(search : String):List<BookXTag>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(bookXtag: BookXTag)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM BookXTags")
    fun deleteTable()//elimina la tabla

}