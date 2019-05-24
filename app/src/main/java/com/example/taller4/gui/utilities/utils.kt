package com.example.taller4.gui.utilities

import com.example.taller4.database.entities.Book

object AppConstans{
    val dataset_saveinstance_key = "CLE"
    val MAIN_LIST_KEY = "key_list_books"
}

interface MyAdapter{
    fun changeDataSet(newDataSet : ArrayList<Book>)
}