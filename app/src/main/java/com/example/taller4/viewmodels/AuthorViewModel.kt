//package com.example.taller4.viewmodels
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class AuthorViewModel(
//    app: Application
//) : AndroidViewModel(app) {
//
//    private val repository: AuthorRepository
//
//    init {
//        val authorDao = AuthorRoomDatabase.getInstance(app).AuthorDao()
//
//        repository = AuthorRepository(authorDao)
//    }
//
//    fun getAuthorsList(): LiveData<List<Author>> = repository.getAll()
//
//    fun insert(author: Author) =
//        viewModelScope.launch(Dispatchers.IO)
//        {
//            repository.insert(author)
//        }
//}