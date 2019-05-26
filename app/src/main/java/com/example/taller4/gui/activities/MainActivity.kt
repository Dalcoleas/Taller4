package com.example.taller4.gui.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taller4.R
import com.example.taller4.database.BookDataBase
import com.example.taller4.gui.dtos.BookDTO
import com.example.taller4.gui.fragments.FragmentDetail
import com.example.taller4.gui.fragments.FragmentList
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),  FragmentList.ListenerTools{

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
        detFrag = FragmentDetail()

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            resource = R.id.main_fragment

            bt_add_activity.setOnClickListener{
                val intent = Intent(this@MainActivity, NewBookActivity::class.java)
                startActivityForResult(intent, newBookActivityRequestCode)
            }
        }
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            resource = R.id.land_main_fragment
            changeFragment(R.id.land_main_cont_fragment, detFrag)
        }


        changeFragment(resource, mainFrag)
    }

    override fun PortraitClick(book: BookDTO) {
        val intent = Intent(this@MainActivity, BookInfoActivity::class.java)
        intent.putExtra("title", book.title)
        intent.putExtra("summary", book.summary)
        intent.putExtra("name", book.authors[0].author_name)
        intent.putExtra("last",book.authors[0].author_last_name)
        intent.putExtra("img", book.cover)
        Log.d("summary", book.toString())
        startActivity(intent)
    }

    override fun LandscapeClick(book: BookDTO) {
        detFrag = FragmentDetail.newInstance(book)
        changeFragment(R.id.land_main_cont_fragment, detFrag)
    }

    private fun changeFragment(id: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(id,fragment).commit()
    }

    companion object{
        const val newBookActivityRequestCode = 1
    }
}
