package com.example.taller4.gui.utilities

import com.example.taller4.gui.dtos.BookDTO

interface MyAdapter{
    fun changeDataSet(newDataSet : List<BookDTO>)
}