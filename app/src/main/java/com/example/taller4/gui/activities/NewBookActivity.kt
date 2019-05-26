package com.example.taller4.gui.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.taller4.R
import kotlinx.android.synthetic.main.activity_new_book.*

class NewBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)

        bt_add_newbook.setOnClickListener {

            val intent = Intent()

            intent.putExtra("Title", title_newbook.text.toString())
            intent.putExtra("Author", author_newbook.text.toString())
            intent.putExtra("ISBN", isbn_newbook.text.toString())
            intent.putExtra("Resumen", summary_newbook.text.toString())
            intent.putExtra("Cover", cover_newbook.text.toString())
            intent.putExtra("Tag", tags_newbook.text.toString())
            intent.putExtra("Publisher", publisher_newbook.text.toString())

            setResult(Activity.RESULT_OK, intent)

            finish()
        }

    }
}
