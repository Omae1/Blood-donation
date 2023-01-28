package com.wil.blooddonationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast

class Donate : AppCompatActivity() {
    private lateinit var btnNext:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
        btnNext=findViewById(R.id.next_btn)

        btnNext.setOnClickListener {
            val intent = Intent(this, HospitalList::class.java)
            startActivity(intent)

        }

        val donation = resources.getStringArray(R.array.donation_type)
        val autoCompleteTextView=findViewById<AutoCompleteTextView>(R.id.autocompleteTextView)


        //creating an array adapter

        val adapter = ArrayAdapter(applicationContext, R.layout.item_drop_down,R.id.text_view,donation)

        //attach adapter to autoCommpleteTextView
        autoCompleteTextView.setAdapter(adapter)
    }
}
