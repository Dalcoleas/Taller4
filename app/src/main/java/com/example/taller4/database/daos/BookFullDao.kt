package com.example.taller4.database.daos


@Dao
interface BookFullDao {

    @Query("SELECT*FROM repos")
    fun getAll():LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)//cuando hay conficto con los datos por ejemplo mismo id... en este caso reemplaza
    suspend fun insert(repo: GithubRepo)//supend para ser llamado por otra funcion supend o una corrutina

    @Query("DELETE FROM repos")
    fun nukeTable()//elimina la tabla
}