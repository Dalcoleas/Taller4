package com.example.taller4.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taller4.database.daos.*
import com.example.taller4.database.entities.*


@Database(entities = [Book::class,Tag::class,Author::class,Publisher::class,BookXTag::class,BookXAuthor::class],version = 1,exportSchema = false)//en caso de mas entidades se agregan al arreglo.. despues de la version si se cambi se tiene que migrar
public abstract class BookDataBase: RoomDatabase(){

    abstract fun authorDao():AuthorDao
    abstract fun bookDao():BookDao
    abstract fun tagDao():TagDao
    abstract fun publisherDao():PublisherDao
    abstract fun bookXAuthorDao():BookXAuthorDao
    abstract fun bookXTagDao():BookXTagDao
    //aqui se agregan todos los DAOs

    companion object {//solo se necesita una entidad de esta clase SInglenton

        @Volatile//notifica cambios a todos los hilos que lo estan usando
        private var INSTANCE: BookDataBase?=null

        fun getInstance(context: Context): BookDataBase {
            val temInstance = INSTANCE
            if(temInstance!=null){
                return temInstance
            }

            synchronized(this){//para que solo un hilo la use y puedan crearse dos bases
                val instance = Room
                    .databaseBuilder(context, BookDataBase::class.java,"Book_DB")
                    .build()
                INSTANCE =instance
                return instance
            }
        }
    }


}