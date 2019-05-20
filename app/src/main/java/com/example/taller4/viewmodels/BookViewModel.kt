//package com.example.taller4.viewmodels
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class BookViewModel(
//    app: Application
//) : AndroidViewModel(app) {
//
//    private val repository: BookRepository
//
//    init {
//        val bookDao = BookRoomDatabase.getInstance(app).BookDao()
//
//        repository = BookRepository(bookDao)
//    }
//
//    fun getAllBooks(): LiveData<List<Book>> = repository.getAll()
//
// /** Buscar libro según título **/
//    fun searchBookByTitle(title: String): LiveData<List<Book>> = repository.searchByTitle(title)
//
// /** Buscar libro según Author **/
//    fun searchBookByAuthor(author: String): LiveData<List<Book>> = repository.searchByAuthor(author)
//
// /** Buscar libro según Editorial**/
//    fun searchBookByPublisher(publisher: String): LiveData<List<Book>> = repository.searchByPublisher(publisher)
//
// /** Buscar libro según Tag**/
//    fun searchBookByTag(publisher: String): LiveData<List<Book>> = repository.searchByTag(tag)
//
// /** Buscar libro según ISBN**/
//    fun searchBookByPublisher(isbn: String): LiveData<List<Book>> = repository.searchByIsbn(isbn)
//
//    fun insert(book: Book) =
//        viewModelScope.launch(Dispatchers.IO)
//        {
//            repository.insert(book)
//        }
//}