package com.example.taller4.gui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taller4.R
import com.example.taller4.database.entities.Author
import com.example.taller4.database.entities.Book
import com.example.taller4.database.entities.Tag
import kotlinx.android.synthetic.main.book_details_frag.view.*

class FragmentDetail() : Fragment(){

    var authors : List<Author> = emptyList()
    var tags : List<Tag> = emptyList()

    var book = Book(0,"N/A",0,"N/A","N/A","N/A",0, authors, tags)

    companion object{
        fun newInstance (book:Book) : FragmentDetail{
            val newFragment = FragmentDetail()
            newFragment.book = book
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.book_details_frag, container,false)

        bind(view)

        return view
    }

    fun bind(view: View){
        //view.image_frag -> poner imagen
        view.title_frag.text = book.title
    }
}