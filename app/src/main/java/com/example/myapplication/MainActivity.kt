package com.example.myapplication

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Getting seirekiDate
        val seirekiDate = findViewById(R.id.seirekiDate) as EditText



        val cal = java.util.Calendar.getInstance()
        var year = cal.get(java.util.Calendar.YEAR)
        var month = cal.get(java.util.Calendar.MONTH)
        var day = cal.get(java.util.Calendar.DAY_OF_MONTH)

       var date = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

           cal.set(java.util.Calendar.YEAR, year)
           cal.set(java.util.Calendar.MONTH, monthOfYear)
           cal.set(java.util.Calendar.DAY_OF_MONTH, dayOfMonth)
           val dateFormat = "yyyy/MM/dd"
            var sdf = SimpleDateFormat(dateFormat,Locale.JAPAN)
            seirekiDate.setText(sdf.format(cal.time))
        }

        // Handler on Seireki Date
        seirekiDate.setOnClickListener{

            DatePickerDialog(
                this@MainActivity, date, cal
                    .get(java.util.Calendar.YEAR), cal.get(java.util.Calendar.MONTH),
                cal.get(java.util.Calendar.DAY_OF_MONTH)
            ).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
