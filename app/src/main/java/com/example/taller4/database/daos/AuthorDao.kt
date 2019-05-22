package com.example.taller4.database.daos


@Dao
interface AuthorDao {

    @Query("SELECT*FROM authors")
    fun getAll():LiveData<List<Author>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(author: Author)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM authors")
    fun nukeTable()//elimina la tabla
}