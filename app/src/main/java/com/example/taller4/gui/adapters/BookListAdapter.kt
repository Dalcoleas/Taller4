package com.example.taller4.gui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taller4.R
import com.example.taller4.database.entities.Author
import com.example.taller4.database.entities.Book
import com.example.taller4.gui.dtos.BookDTO
import com.example.taller4.gui.utilities.MyAdapter
import kotlinx.android.synthetic.main.recyclerview_book.view.*

class BookListAdapter (var books: List<BookDTO> , val clickListener: (Book) -> Unit) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_book, parent, false)

        return BookViewHolder(view)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) = holder.bind(books[position], clickListener)

     fun changeDataSet(newDataSet: List<BookDTO>) {
        this.books = newDataSet
        notifyDataSetChanged()
    }
//    fun setBooks(book: List<Book>){
//        this.books = books
//        notifyDataSetChanged()
//
//    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(book: BookDTO, clickListener: (Book) -> Unit) = with(itemView) {
            //img_book -> setear imagen
           // val e : List<Author> = emptyList()
          //  if(book.authors !=e ){
         //       Log.i("HOLLLLA","hola")
        //    }
            tv_title_book.text = book.authors.get(0).author_name
        }
    }
}