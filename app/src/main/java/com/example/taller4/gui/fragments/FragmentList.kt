package com.example.taller4.gui.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taller4.R
import com.example.taller4.gui.adapters.BookListAdapter
import com.example.taller4.database.entities.Book
import com.example.taller4.gui.dtos.BookDTO
//import com.example.taller4.gui.utilities.AppConstants
import com.example.taller4.gui.utilities.MyAdapter
import com.example.taller4.viewmodels.BookViewModel
import kotlinx.android.synthetic.main.content_main.view.*

class FragmentList  : Fragment(){
    private lateinit var viewModel: BookViewModel
    private lateinit var booksList : ArrayList<BookDTO>
    private lateinit var bookAdapter : BookListAdapter
    var listenerTools : ListenerTools? = null


    companion object{
        fun newInstance(dataset : ArrayList<BookDTO>): FragmentList{
            val newFragment = FragmentList()
            newFragment.booksList = dataset
            return newFragment
        }
    }

    interface ListenerTools{
        fun PortraitClick(book: Book)
        fun LandscapeClick(book: Book)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.content_main, container,false)

        //if(savedInstanceState != null) booksList = savedInstanceState.getParcelableArrayList<Book>(AppConstants.MAIN_LIST_KEY)

        initRecyclerView(resources.configuration.orientation, view)


        return view
    }

    fun initRecyclerView(orientation: Int, container: View){
        val gridLayoutManager = GridLayoutManager(this.context,2)
        val linearLayoutManager = LinearLayoutManager(this.context)

        if(orientation==Configuration.ORIENTATION_PORTRAIT){
            bookAdapter = BookListAdapter(booksList,{book:Book -> listenerTools?.PortraitClick(book)})
            container.recyclerview_books.adapter = bookAdapter as BookListAdapter

            container.recyclerview_books.apply {
                setHasFixedSize(true)
                layoutManager = gridLayoutManager
            }
        }
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            bookAdapter = BookListAdapter(booksList, {book : Book -> listenerTools?.LandscapeClick(book)})
            container.recyclerview_books.adapter = bookAdapter as BookListAdapter

            container.recyclerview_books.apply {
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

                    var d = BookDTO(it.id,it.title,it.edition,it.cover,it.isbn,it.summary)

                    viewModel.authors(it.id).observe(this, Observer {  authors->
                        authors.let {
                            Log.i("MATERRACE", "ds")
                            d.authors = authors
                            a.add(d)
                            dtos = a
                            bookAdapter.changeDataSet(dtos)
                        }
                    })


                }


            }
        })
    }

    fun updateBooks(books : ArrayList<BookDTO>){
        bookAdapter.changeDataSet(books)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onDetach() {
        super.onDetach()
        listenerTools = null
    }
}