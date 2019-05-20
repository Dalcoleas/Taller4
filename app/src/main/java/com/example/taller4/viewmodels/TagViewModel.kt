//package com.example.taller4.viewmodels
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class TagViewModel(
//    app: Application
//) : AndroidViewModel(app) {
//
//    private val repository: TagRepository
//
//    init {
//        val tagDao = TagRoomDatabase.getInstance(app).TagDao()
//
//        repository = TagRepository(tagDao)
//    }
//
//    fun getTagsList(): LiveData<List<Tag>> = repository.getAll()
//
//    fun insert(tag: Tag) =
//        viewModelScope.launch(Dispatchers.IO)
//        {
//            repository.insert(tag)
//        }
//}