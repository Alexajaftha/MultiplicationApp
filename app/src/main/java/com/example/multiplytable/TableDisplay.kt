package com.example.multiplytable

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        //get the table number from the bundle
        //assigning data from main page to table display page
        val bundle: Bundle? = intent.extras
        val tableString: String? = bundle?.getString("tableNumber")

        //convert the table number back into an integer
        val tableNumber = tableString?.toInt()

        //added another variable for the multiply table
        val multiplyTable = findViewById<TextView>(R.id.tableDisplayText)
        var timesDisplay: String = "$tableNumber x tables\n\n"

        //creating counter for while loop
        var count = 1

        multiplyTable.text = timesDisplay


        while ( count <= 10 ) {
            //example: user enters 5 and count is 1 so: 5 x 1 = (Answer)
            val answer = tableNumber * count
            //displays as: 5 x 1 = 5

            timesDisplay += "$tableNumber x $count = ${answer}\n"

            //increasing the count
            count++
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}