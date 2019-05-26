package com.example.taller4.gui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taller4.R
import com.example.taller4.gui.dtos.BookDTO
import com.example.taller4.gui.utilities.MyAdapter
import kotlinx.android.synthetic.main.recyclerview_book.view.*
import kotlinx.android.synthetic.main.recyclerview_book_details.view.*

class BookDetailAdapter (var books: List<BookDTO> , val clickListener: (BookDTO) -> Unit) : RecyclerView.Adapter<BookDetailAdapter.BookViewHolder>(), MyAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_book_details, parent, false)

        return BookViewHolder(view)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) = holder.bind(books[position], clickListener)

    override fun changeDataSet(newDataSet: List<BookDTO>) {
        this.books = newDataSet
        notifyDataSetChanged()
    }
   /*fun setBooks(book: List<Book>){
        this.books = books
        notifyDataSetChanged()

    }*/

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: BookDTO, clickListener: (BookDTO) -> Unit) = with(itemView) {
            tv_det_title.text = book.title
            Glide.with(itemView.context).load(book.cover).into(itemView.det_image)

            itemView.setOnClickListener { clickListener(book) }
        }
    }
}