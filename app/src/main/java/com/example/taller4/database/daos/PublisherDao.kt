package com.example.taller4.database.daos


@Dao
interface PublisherDao {

    @Query("SELECT*FROM publishers")
    fun getAll():LiveData<List<Publisher>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(publisher: Publisher)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM publishers")
    fun nukeTable()//elimina la tabla
}