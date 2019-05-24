package com.example.taller4.database

import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

class BookDataBaseCallback (

    val scope : CoroutineScope
) : RoomDatabase.Callback(){

}