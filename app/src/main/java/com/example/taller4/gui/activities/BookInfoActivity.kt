package com.example.taller4.gui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.taller4.R
import kotlinx.android.synthetic.main.activity_book_info.*

class BookInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)

        val mIntent = intent

        if(intent!=null){

            var title = mIntent.getStringExtra("title")
            var summary = mIntent.getStringExtra("summary")
            var img = mIntent.getStringExtra("img")
            var name = mIntent.getStringExtra("name")
            var lname = mIntent.getStringExtra("last")

            title_info.text = title
            summary_info.text = summary
            name_info.text = name
            lastname_info.text = lname

            Glide.with(this).load(img).into(img_info)



        }
    }
}
