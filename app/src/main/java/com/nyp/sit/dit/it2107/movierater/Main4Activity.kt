package com.nyp.sit.dit.it2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main4.*
import org.w3c.dom.Text

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        registerForContextMenu(pressMe)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.pressMe) {
            menu?.add(1, 1001, 1, "Add")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1001) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }



}
