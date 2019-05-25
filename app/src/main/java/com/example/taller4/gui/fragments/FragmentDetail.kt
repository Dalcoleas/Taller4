package com.example.taller4.gui.fragments

import android.os.Bundle
import android.service.autofill.Dataset
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

    var book = Book("N/A",0,"N/A","N/A","N/A", 1)

    companion object{
        fun newInstance (dataset : Book) : FragmentDetail{
            return FragmentDetail().apply {
                book = dataset
            }
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