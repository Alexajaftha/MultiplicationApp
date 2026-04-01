package com.example.multiplytable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //created variable to hold the homescreen elements
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val numInput = findViewById<EditText>(R.id.numTextInput)

        //created a button click listener to listen for button click
        multiplyButton.setOnClickListener {

            //created an intent to switch between pages
          //create the explicit intent
            val intent = Intent(this,TableDisplay::class.java)

            //add the table number to the intent
            intent.putExtra("tableNumber",numInput.text.toString())
            startActivity(intent)




        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}