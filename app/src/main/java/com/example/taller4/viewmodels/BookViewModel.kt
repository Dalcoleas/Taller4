package com.example.taller4.viewmodels

//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import com.example.taller4.database.entities.Author
//import com.example.taller4.database.entities.Book
//import com.example.taller4.database.entities.Publisher
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller4.database.BookDataBase
import com.example.taller4.database.entities.Author
import com.example.taller4.database.entities.Book
import com.example.taller4.database.entities.Tag
import com.example.taller4.repositories.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(
    app: Application
) : AndroidViewModel(app) {

    private val repository: BookRepository


    init {
        val bookDao = BookDataBase.getInstance(app,viewModelScope).bookDao()

        repository = BookRepository(bookDao)


    }

    /** Bloque de Book **/
    fun insert(book: Book) =
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.insert(book)
        }

    /** Bloque de funciones de búsqueda de libros**/
    /** Obtener todos los libros **/
    fun getAllBooks(): LiveData<List<Book>> {

        Log.i("BOOKTABLE",repository.allBooks.value.toString())
        return repository.allBooks}

//    /** Buscar libro según id **/
//    fun getBook(id: Int): LiveData<Book> =
//      //  repository.(id)

    /** Buscar libro según título **/
    fun searchBookByTitle(title: String): LiveData<List<Book>> =
        repository.allBooks

    fun authors(bookid: Int): LiveData<List<Author>> {
        return repository.authors(bookid)
    }



//    /** Buscar libro según Author **/
//    fun searchBookByAuthor(author: String): LiveData<List<Book>> =
//        repository.searchByAuthor(author)
//
//    /** Buscar libro según Editorial **/
//    fun searchBookByPublisher(publisher: String): LiveData<List<Book>> =
//        repository.searchByPublisher(publisher)
//
//    /** Buscar libro según Tag **/
//    fun searchBookByTag(tag: String): LiveData<List<Book>> =
//        repository.searchByTag(tag)
//
//    /** Buscar libro según ISBN **/
//    fun searchBookByIsbn(isbn: String): LiveData<List<Book>> =
//        repository.searchByIsbn(isbn)
//    /** Fin de bloque de funciones de búsqueda **/
//    /** Fin de bloque de Book **/
//
//
//    /** Bloque de Author **/
//    fun insert(author: Author) =
//        viewModelScope.launch(Dispatchers.IO)
//        {
//            repository.insert(author)
//        }
//
//    /** Obtener todos los autores **/
//    fun getAllAuthors(): LiveData<List<Author>> = repository.getAllAuthors()
//
//    /** Buscar autor según id **/
//    fun getAuthor(id: Int): LiveData<Author> =
//        repository.getAuthor(id)
//    /** Fin de bloque de Author **/
//
//
//    /** Bloque de Tag**/
//    fun insert(tag: Tag) =
//        viewModelScope.launch(Dispatchers.IO)
//        {
//            repository.insert(tag)
//        }

//    /** Obtener todas las tags **/
//    fun getAllTags(): LiveData<List<Tag>> = repository.getAllTags()
//
//    /** Buscar tag según id **/
//    fun getTag(id: Int): LiveData<Tag> =
//        repository.getTag(id)
//    /** Fin de bloque de Tag **/
//
//
//    /** Bloque de Publisher **/
//    fun insert(publisher: Publisher) =
//        viewModelScope.launch(Dispatchers.IO)
//        {
//            repository.insert(publisher)
//        }

//    /** Obtener todas las casas editoras **/
//    fun getAllPublishers(): LiveData<List<Publisher>> = repository.getAllPulishers()
//
//    /** Buscar tag según id **/
//    fun getPublisher(id: Int): LiveData<Publisher> =
//        repository.getPublisher(id)
//    /** Fin de bloque de Publisher **/
}
