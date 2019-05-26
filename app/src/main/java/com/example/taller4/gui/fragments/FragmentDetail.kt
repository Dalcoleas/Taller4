package com.example.taller4.gui.fragments

import android.os.Bundle
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.taller4.R
import com.example.taller4.database.entities.Author
import com.example.taller4.database.entities.Book
import com.example.taller4.database.entities.Tag
import com.example.taller4.gui.dtos.BookDTO
import kotlinx.android.synthetic.main.book_details_frag.view.*

class FragmentDetail() : Fragment(){

    var book = BookDTO(0," ", 0, "N/A", "N/A","N/A")

    companion object{
        fun newInstance (dataset : BookDTO) : FragmentDetail{
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

        view.name_frag.text = book.title
        Glide.with(view.context).load(book.cover).into(view.img_frag)
    }
}