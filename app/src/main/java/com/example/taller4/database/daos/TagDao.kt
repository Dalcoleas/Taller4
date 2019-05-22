package com.example.taller4.database.daos


@Dao
interface TagDao {

    @Query("SELECT*FROM tags")
    fun getAll():LiveData<List<Tag>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(tag: Tag)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM tags")
    fun nukeTable()//elimina la tabla
}