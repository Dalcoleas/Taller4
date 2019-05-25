package com.example.taller4.gui.activities

import android.content.Intent
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
import com.example.taller4.viewmodels.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  FragmentList.ListenerTools{

    private var booksList = ArrayList<BookDTO>()
    private lateinit var mainFrag : FragmentList
    private lateinit var detFrag : FragmentDetail
    private var resource = 0

    lateinit var database : BookDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMainFragment()
    }

    fun initMainFragment(){

        mainFrag = FragmentList()

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            resource = R.id.main_fragment
        }
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showContent(R.id.land_main_cont_fragment, Book("N/A",1,"N/A","N/A","N/a",1))
            resource = R.id.land_main_fragment
        }

        changeFragment(resource, mainFrag)
    }

    override fun PortraitClick(book: BookDTO) {
        val intent = Intent(this@MainActivity, BookInfoActivity::class.java)
        startActivityForResult(intent, newBookActivityRequestCode)
    }

    override fun LandscapeClick(book: BookDTO) {
    }

    private fun changeFragment(id: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(id,fragment).commit()
    }

    private fun showContent(placeholder : Int, book : Book){
        detFrag = FragmentDetail.newInstance(book)
        changeFragment(placeholder, detFrag)
    }

    companion object{
        const val newBookActivityRequestCode = 1
    }
}
