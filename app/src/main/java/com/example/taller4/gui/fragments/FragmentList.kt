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
import com.example.taller4.gui.adapters.BookDetailAdapter
import com.example.taller4.gui.dtos.BookDTO
import com.example.taller4.gui.dtos.DtoMapper
import com.example.taller4.gui.utilities.MyAdapter
import com.example.taller4.viewmodels.BookViewModel
import kotlinx.android.synthetic.main.content_main.view.*

class FragmentList : Fragment() {

    private lateinit var viewModel: BookViewModel
    private val booksList = ArrayList<BookDTO>()
    private lateinit var bookAdapter: MyAdapter
    private var listenerTools: ListenerTools? = null


    interface ListenerTools {
        fun portraitClick(book: BookDTO)
        fun landscapeClick(book: BookDTO)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.content_main, container, false)

        initRecyclerView(resources.configuration.orientation, view)

        return view
    }

    fun initRecyclerView(orientation: Int, container: View) {
        val gridLayoutManager = GridLayoutManager(this.context, 2)
        val linearLayoutManager = LinearLayoutManager(this.context)
        val recyclerView = container.recyclerview_books

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            bookAdapter = BookListAdapter(
                books = booksList,
                clickListener = { book: BookDTO -> listenerTools?.portraitClick(book) })
            recyclerView.apply {
                adapter = bookAdapter as BookListAdapter
                setHasFixedSize(true)
                layoutManager = gridLayoutManager
            }
        } else {
            bookAdapter = BookDetailAdapter(
                books = booksList,
                clickListener = { book: BookDTO -> listenerTools?.landscapeClick(book) })
            recyclerView.apply {
                adapter = bookAdapter as BookDetailAdapter
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
            }

        }

        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

        var BookDtos: List<BookDTO>

        viewModel.getAllBooks().observe(this, Observer { books ->
            books?.let {
                var allDtos: ArrayList<BookDTO> = ArrayList<BookDTO>()
//                Log.i("BOOKTABLE",viewModel.getAllBooks().value.toString())
                viewModel.getAllBooks().value?.forEach {

                    var bookDTO = DtoMapper.mapToDto(it)

                    viewModel.authors(it.id).observe(this, Observer { authors ->
                        authors.let {
                            //                            Log.i("MATERRACE", "ds")
                            //   d.authors = authors
                            allDtos.forEach {
                                if (it.id == bookDTO.id) {
                                    it.authors = authors
                                }
                            }
                            BookDtos = allDtos
                            bookAdapter.changeDataSet(BookDtos)
                        }
                    })

                    viewModel.publisher(it.id).observe(this, Observer { publisher ->
                        publisher.let {
                            //                            Log.i("MATERRACE", "ds")
                            // d.publisher = authors
                            allDtos.forEach {
                                if (it.id == bookDTO.id) {
                                    //  it.publisher= publisher
                                }
                            }
                            BookDtos = allDtos
                            bookAdapter.changeDataSet(BookDtos)
                        }
                    })

                    viewModel.tags(it.id).observe(this, Observer { tags ->
                        tags.let {
                            //                            Log.i("MATERRACE", "ds")
                            bookDTO.tags = tags
                            allDtos.forEach {
                                if (it.id == bookDTO.id) {
                                    it.tags = tags

                                }
                            }
                            BookDtos = allDtos
                            bookAdapter.changeDataSet(BookDtos)
                        }
                    })

                    allDtos.add(bookDTO)
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