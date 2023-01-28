package com.wil.blooddonationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button

class HospitalList : AppCompatActivity() {
    lateinit var btn_schedule:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_list)


        btn_schedule=findViewById(R.id.schedule_btn)

        btn_schedule.setOnClickListener {
            val intent= Intent(this,Timesetting::class.java)
            startActivity(intent)

        }


        val centers = resources.getStringArray(R.array.find_center)
        val autoCompleteTextView=findViewById<AutoCompleteTextView>(R.id.HospitalTextView)

        //creating an array adapter

        val adapter = ArrayAdapter(applicationContext, R.layout.item_drop_down,R.id.text_view,centers)

        //attach adapter to autoCommpleteTextView
        autoCompleteTextView.setAdapter(adapter)



    }
}