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
//    fun getBooksList(): LiveData<List<Book>> = repository.getAll()
//
//    fun insert(book: Book) =
//        viewModelScope.launch(Dispatchers.IO)
//        {
//            repository.insert(book)
//        }
//}