//package com.example.taller4.viewmodels
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class PublisherViewModel(
//    app: Application
//) : AndroidViewModel(app) {
//
//    private val repository: PublisherRepository
//
//    init {
//        val publisherDao = PublisherRoomDatabase.getInstance(app).PublisherDao()
//
//        repository = PublisherRepository(publisherDao)
//    }
//
//    fun getPublishersList(): LiveData<List<Publisher>> = repository.getAll()
//
//    fun insert(publisher: Publisher) =
//        viewModelScope.launch(Dispatchers.IO)
//        {
//            repository.insert(publisher)
//        }
//}