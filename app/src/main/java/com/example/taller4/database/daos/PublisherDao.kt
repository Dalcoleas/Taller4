package com.example.taller4.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4.database.entities.Publisher


@Dao
interface PublisherDao {

    @Query("SELECT*FROM publishers")
    fun getAll(): LiveData<List<Publisher>>

    //obtener publicadores en base al nombre
    @Query("SELECT*FROM publishers WHERE publisher_name like :search")
    fun findByTag (search : String): LiveData<List<Publisher>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(publisher: Publisher)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM publishers")
    fun deleteTable()//elimina la tabla
}