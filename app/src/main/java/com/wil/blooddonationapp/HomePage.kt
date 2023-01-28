package com.wil.blooddonationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class HomePage : AppCompatActivity() {
    lateinit var cardHome: CardView
    lateinit var cardLogin: CardView
    lateinit var cardRegister: CardView
    lateinit var cardForgotpass: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        cardHome=findViewById(R.id.cardHome)
        cardLogin=findViewById(R.id.cardLogin)
        cardRegister=findViewById(R.id.cardRegister)
        cardForgotpass=findViewById(R.id.cardForgotPassword)

        cardHome.setOnClickListener {
            Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
            val homepage = Intent(this,HomePage::class.java)
            startActivity(homepage)
            finish()

        }
        cardLogin.setOnClickListener {
            Toast.makeText(this, "LogIn clicked", Toast.LENGTH_SHORT).show()
            val log = Intent(this, MainActivity::class.java)
            startActivity(log)
        }
        cardRegister.setOnClickListener {
            Toast.makeText(this, "Registration clicked", Toast.LENGTH_SHORT).show()
            val reg = Intent(this, SignupActivity::class.java)
            startActivity(reg)

        }
        cardForgotpass.setOnClickListener {
            Toast.makeText(this, " Forgot pass clicked", Toast.LENGTH_SHORT).show()
            val forgot = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(forgot)

        }


    }

    override fun onBackPressed() {
        val exit = ExitDialog()
        exit.show(supportFragmentManager, null)



    }
}