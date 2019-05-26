package com.example.taller4.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4.database.entities.Tag


@Dao
interface TagDao {

    @Query("SELECT*FROM tags")
    fun getAll(): LiveData<List<Tag>>

    @Query("SELECT*FROM tags WHERE tag_name like :search")
    fun finByTag(search : String): LiveData<List<Tag>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(tag: Tag)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM tags")
    fun deleteTable()//elimina la tabla
}