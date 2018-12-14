package com.nyp.sit.dit.it2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val movie = MovieEntity()
        var movie_name: String = getIntent().getStringExtra("Title")
        var movie_desc: String = getIntent().getStringExtra("Overview")
        var movie_lang: String = getIntent().getStringExtra("Language")
        var movie_rdate: String = getIntent().getStringExtra("ReleaseDate")
        var movie_audience: String = getIntent().getStringExtra("Audience")
        movie_title.text = movie_name + "\n"
        movie_description.text = movie_desc + "\n"
        language.text = movie_lang + "\n"
        r_date.text = movie_rdate + "\n"
        audience.text = movie_audience + "\n"
        var ratingNum: Float = movie.Rating
        if (ratingNum != 0.00F) {
            ratingDisplay.setVisibility(View.VISIBLE)
            ratingDisplay.rating = ratingNum
        }

        registerForContextMenu(movie_reviews)
    }

//    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        if (v?.id == R.id.movie_reviews) {
//            menu?.add(1, 1001, 1, "Add Review")
//        }
//    }
//
//    override fun onContextItemSelected(item: MenuItem?): Boolean {
//        if (item?.itemId == 1001) {
//            val intent = Intent(this, Main3Activity::class.java)
//            startActivity(intent)
//        }
//        return super.onContextItemSelected(item)
//    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.movie_reviews) {
            menu?.add(2, 1002, 1, "Add Review")

        } }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1002) {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }



}
