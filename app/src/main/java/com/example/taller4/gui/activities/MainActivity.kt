package com.example.taller4.gui.activities

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.taller4.R
import com.example.taller4.database.BookDataBase
import com.example.taller4.database.entities.Book
import com.example.taller4.gui.dtos.BookDTO
import com.example.taller4.gui.fragments.FragmentDetail
import com.example.taller4.gui.fragments.FragmentList
import com.example.taller4.gui.utilities.AppConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  FragmentList.ListenerTools{

    private var booksList = ArrayList<BookDTO>()
    //private lateinit var var bookViewModel: BookViewModel
    private lateinit var mainFrag : FragmentList
    private lateinit var detFrag : FragmentDetail

    lateinit var database : BookDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMainFragment()
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(AppConstants.dataset_saveinstance_key,booksList)
        super.onSaveInstanceState(outState)
    }*/

    fun initMainFragment(){
        //bookViewModel = ViewModelProviders.of(this).get()

        mainFrag = FragmentList.newInstance(booksList)

        val resource = if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            R.id.main_fragment
        else{
            detFrag = FragmentDetail.newInstance(Book("N/A",0,"N/A","N/A","N/A",0))

            changeFragment(R.id.land_main_cont_fragment, detFrag)

            R.id.land_main_fragment
        }

        changeFragment(resource, mainFrag)
    }

    override fun PortraitClick(book: Book) {
    }

    override fun LandscapeClick(book: Book) {
    }

    fun updateBooks(bookList : ArrayList<BookDTO>){
        mainFrag.updateBooks(bookList)
    }

    private fun changeFragment(id: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(id,fragment).commit()
    }
}
