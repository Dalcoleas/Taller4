package com.example.taller4.gui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller4.R
import com.example.taller4.database.BookDataBase
import com.example.taller4.database.entities.Book
import com.example.taller4.gui.fragments.FragmentDetail
import com.example.taller4.gui.fragments.FragmentList

class MainActivity : AppCompatActivity(),  FragmentList.ListenerTools{

    private var booksList = ArrayList<Book>()
    //private lateinit var var bookViewModel: BookViewModel
    private lateinit var mainFrag : FragmentList
    private lateinit var detFrag : FragmentDetail

    lateinit var database : BookDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun PortraitClick(book: Book) {
    }

    override fun LandscapeClick(book: Book) {
    }
}
