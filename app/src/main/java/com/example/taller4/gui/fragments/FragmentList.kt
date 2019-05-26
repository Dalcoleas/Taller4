package com.example.taller4.gui.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taller4.R
import com.example.taller4.gui.adapters.BookListAdapter
import com.example.taller4.database.entities.Book
import com.example.taller4.gui.adapters.BookDetailAdapter
import com.example.taller4.gui.dtos.BookDTO
import com.example.taller4.gui.utilities.MyAdapter
import com.example.taller4.viewmodels.BookViewModel
import kotlinx.android.synthetic.main.content_main.view.*

class FragmentList  : Fragment(){

    private lateinit var viewModel: BookViewModel
    private val booksList = ArrayList<BookDTO>()
    private lateinit var BookAdapter : MyAdapter
    private var listenerTools : ListenerTools? = null


    interface ListenerTools{
        fun PortraitClick(book: BookDTO)
        fun LandscapeClick(book: BookDTO)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.content_main, container,false)

        initRecyclerView(resources.configuration.orientation, view)

        return view
    }

    fun initRecyclerView(orientation: Int, container: View){
        val gridLayoutManager = GridLayoutManager(this.context,2)
        val linearLayoutManager = LinearLayoutManager(this.context)
        val recyclerView = container.recyclerview_books

        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            BookAdapter = BookListAdapter(books = booksList, clickListener = {book: BookDTO ->  listenerTools?.PortraitClick(book)})
            recyclerView.apply {
                adapter = BookAdapter as BookListAdapter
                setHasFixedSize(true)
                layoutManager = gridLayoutManager
            }
        } else{
            BookAdapter = BookDetailAdapter(books = booksList, clickListener = {book: BookDTO ->   listenerTools?.LandscapeClick(book)})
            recyclerView.apply {
                adapter = BookAdapter as BookDetailAdapter
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
            }

        }

        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        var dtos  : List<BookDTO>

        viewModel.getAllBooks().observe(this, Observer { books->
            books?.let {
                var a :ArrayList<BookDTO> = ArrayList<BookDTO>()
                Log.i("BOOKTABLE",viewModel.getAllBooks().value.toString())
                viewModel.getAllBooks().value?.forEach{

                    var d = BookDTO(it.id,it.title,it.edition,it.isbn,it.summary,it.cover)

                    viewModel.authors(it.id).observe(this, Observer {  authors->
                        authors.let {
                            Log.i("MATERRACE", "ds")
                            d.authors = authors
                            a.add(d)
                            dtos = a
                            BookAdapter.changeDataSet(dtos)
                        }
                    })


                }

            }
        })

    }

    override fun onDetach() {
        super.onDetach()
        listenerTools = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ListenerTools) {
            listenerTools = context
        } else {
            throw RuntimeException("Se necesita una implementación de la interfaz")
        }
    }
}