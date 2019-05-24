package com.example.taller4.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taller4.database.daos.*
import com.example.taller4.database.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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

        fun getInstance(context: Context,
                        scope: CoroutineScope
        ): BookDataBase {
            val temInstance = INSTANCE
            if(temInstance!=null){
                return temInstance
            }

            synchronized(this){//para que solo un hilo la use y puedan crearse dos bases
                val instance = Room
                    .databaseBuilder(context, BookDataBase::class.java,"Book_DB")
                    .fallbackToDestructiveMigration()
                    .addCallback(BookDatabaseCallback(scope))
                    .build()
                INSTANCE =instance
                return instance
            }
        }

        private class BookDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.authorDao())
                        populateDatabase(database.publisherDao())
                        populateDatabase(database.tagDao())
                        populateDatabase(database.bookDao())
                        populateDatabase(database.bookXAuthorDao())
                        populateDatabase(database.bookXTagDao())

                    }
                }
            }
        }

        suspend fun populateDatabase(bookDao: BookDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            bookDao.nukeTable()

            var book = Book("myBook1",1,"sndjad3","mi resumen del libro 1","algunaImagen.png",1)
            bookDao.insert(book)
            book = Book("myBook2",4,"aszssndjad3","mi resumen del libro 2","algunaImagen.png",2)
            bookDao.insert(book)
        }

        suspend fun populateDatabase(tagDao: TagDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            tagDao.nukeTable()

            var tag = Tag("my tag mindjns as")
            tagDao.insert(tag)
            tag = Tag("aszssndjad3")
            tagDao.insert(tag)
        }

        suspend fun populateDatabase(publisherDao: PublisherDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            publisherDao.nukeTable()

            var publisher = Publisher("trujillo´s ;v")
            publisherDao.insert(publisher)
            publisher = Publisher("publisher_aszssndjad3")
            publisherDao.insert(publisher)
        }

        suspend fun populateDatabase(authorDao: AuthorDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            authorDao.nukeTable()

            var author = Author("eromanga","sensei")
            authorDao.insert(author)
            author = Author("mio","tachibana")
            authorDao.insert(author)
        }

        suspend fun populateDatabase(bookXAuthorDao: BookXAuthorDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            bookXAuthorDao.nukeTable()

            var bookXAuthor = BookXAuthor(1,1)
            bookXAuthorDao.insert(bookXAuthor)
            bookXAuthor = BookXAuthor(2,1)
            bookXAuthorDao.insert(bookXAuthor)
            bookXAuthor = BookXAuthor(2,2)
            bookXAuthorDao.insert(bookXAuthor)
        }

        suspend fun populateDatabase(bookXTagDao: BookXTagDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            bookXTagDao.nukeTable()

            var bookTag = BookXTag(1,1)
            bookXTagDao.insert(bookTag)
            bookTag = BookXTag(2,1)
            bookXTagDao.insert(bookTag)
            bookTag = BookXTag(2,2)
            bookXTagDao.insert(bookTag)
        }
    }


}