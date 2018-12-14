package com.nyp.sit.dit.it2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.save) {
            var id: Int = rg1.checkedRadioButtonId
            val movie = MovieEntity()
            movie.movietitle = movie_name.text.toString()
            movie.movie_desc = description.text.toString()
            movie.movie_rdate = release_date.text.toString()
            val language:RadioButton = findViewById(id)
            movie.movie_lang = language.text.toString()
            var audience: String = ""
            if (checkbox_audience.isChecked()) {
                movie.movie_audience = true
                audience = "Yes"
            }
            else {
                movie.movie_audience = false
                audience = "No"
            }

            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("Title", movie.movietitle)
            intent.putExtra("Overview", movie.movie_lang)
            intent.putExtra("Language", movie.movie_lang)
            intent.putExtra("ReleaseDate", movie.movie_rdate)
            intent.putExtra("Audience", audience)
            startActivity(intent)


        }
        return super.onOptionsItemSelected(item)
    }

    fun onCheck (v: View) {
        if (checkbox_audience.isChecked()) {
            checkbox_language.setVisibility(View.VISIBLE)
            checkbox_violence.setVisibility(View.VISIBLE)
        }
        else {
            checkbox_language.setVisibility(View.INVISIBLE)
            checkbox_violence.setVisibility(View.INVISIBLE)
        }
    }
    fun onSubmit (v: View) {
        var name: String= movie_name.text.toString()
        var desc: String= description.text.toString()
        var date: String= release_date.text.toString()
        var id: Int = rg1.checkedRadioButtonId
        val radio:RadioButton = findViewById(id)


        if (name == "") {
            movie_name.setError("Name is required")
        }
        if (desc == "") {
            description.setError("Description is required")
        }
        if (date == "") {
            release_date.setError("Date is required")
        }
        if ((name != "") && (desc != "") && (date != "")) {
            if (checkbox_audience.isChecked()) {
                var violence = ""
                var language = ""
                if (checkbox_language.isChecked()) {
                    language = "\nLanguage"
                }
                if (checkbox_violence.isChecked()) {
                    violence = "\nViolence"
                }
                Toast.makeText(this, "Title = "+name+"\nOverview="+desc+"\nRelease date = "+date+"" +
                        "\nLanguage = "+radio.text+"\nSuitable for all ages = false\nReason:"+violence+language, Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Title = "+name+"\nOverview="+desc+"\nRelease date = "+date+"" +
                        "\nLanguage = "+radio.text+"\nSuitable for all ages = true", Toast.LENGTH_LONG).show()
            }
        }
    }

}
