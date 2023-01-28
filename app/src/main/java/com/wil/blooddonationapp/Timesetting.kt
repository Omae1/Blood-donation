package com.wil.blooddonationapp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class Timesetting : AppCompatActivity() {
    lateinit var scheduleButton: Button
    lateinit var title: EditText
    lateinit var message: EditText
    lateinit var datepicker: DatePicker
    lateinit var timepicker: TimePicker
    lateinit var logoutbutton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_setting)
        scheduleButton=findViewById(R.id.submit_btn)
        title= findViewById(R.id.titleET)
        message= findViewById(R.id.messageET)
        datepicker=findViewById(R.id.datepicker_txt)
        timepicker=findViewById(R.id.timepicker_txt)
        logoutbutton= findViewById(R.id.LogOut_btn)


        logoutbutton.setOnClickListener {
            val out = Intent(this,HomePage::class.java)
            startActivity(out)
            finish()
        }





        scheduleButton.setOnClickListener {
            Toast.makeText(this, "Notification Scheduled", Toast.LENGTH_SHORT).show()
            val calender= Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                calender.set(Calendar.YEAR,datepicker.year)
                calender.set(Calendar.MONTH,datepicker.month)
                calender.set(Calendar.DAY_OF_MONTH,datepicker.dayOfMonth)
                calender.set(Calendar.HOUR_OF_DAY, timepicker.hour)
                calender.set(Calendar.MINUTE, timepicker.minute)
            }else{
                Toast.makeText(this,   "your device is not supported", Toast.LENGTH_SHORT).show()
                finish()
            }



            scheduleNotification(calender.timeInMillis)

        }




    }

    private fun scheduleNotification(delay: Long) {
        val intent = Intent(applicationContext, Notification::class.java)
        val titleT = title.text.toString()
        val Message = message.text.toString()
        intent.putExtra(titleExtra, titleT)
        intent.putExtra(messageExtra, Message)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            notificationID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "Channel1",
                "My Channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)


        }


        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,delay, pendingIntent)
        }

    }


}