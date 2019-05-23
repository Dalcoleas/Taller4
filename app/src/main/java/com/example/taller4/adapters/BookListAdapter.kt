package com.example.taller4.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taller4.R
import com.example.taller4.database.entities.Book
import com.example.taller4.utilities.MyAdapter
import kotlinx.android.synthetic.main.recyclerview_book.view.*

class BookListAdapter (var books: ArrayList<Book> , val clickListener: (Book) -> Unit) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>(), MyAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_book, parent, false)

        return BookViewHolder(view)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) = holder.bind(books[position], clickListener)

    override fun changeDataSet(books: ArrayList<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book, clickListener: (Book) -> Unit) = with(itemView) {
            //img_book -> setear imagen
            tv_title_book.text = book.title
        }
    }
}