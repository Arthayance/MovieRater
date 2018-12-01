package com.nyp.sit.dit.it2107.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
