package com.wil.blooddonationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class SignupActivity : AppCompatActivity() {
    lateinit var EdtEmail: EditText
    private lateinit var EdtPass: EditText
    lateinit var EdtConPaa: EditText
    private lateinit var BtnSignup: Button
    lateinit var Redirect_Login: TextView

    // Firebase auth
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //view binding
        EdtEmail = findViewById(R.id.txt_email)
        EdtPass = findViewById(R.id.txt_password)
        EdtConPaa = findViewById(R.id.txt_confirmpassword)
        BtnSignup = findViewById(R.id.btn_signup)
        Redirect_Login = findViewById(R.id.redirectlogin)

        //init firebase
        auth= FirebaseAuth.getInstance()


        BtnSignup.setOnClickListener {
            SignUpUser()
        }
        Redirect_Login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    private fun SignUpUser() {
        val email = EdtEmail.text.toString()
        val pass = EdtPass.text.toString()
        val confirmpass = EdtConPaa.text.toString()
        if (email.isBlank() || pass.isBlank() || confirmpass.isBlank()) {
            Toast.makeText(this, "Email and Password cannot be empty", Toast.LENGTH_LONG).show()
            return
        } else if (pass != confirmpass) {
            Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show()
            return
        }
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                startActivity(Intent(this, SplashActivity::class.java).apply { })
                Toast.makeText(this, "Signed successfully", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "Failed to create", Toast.LENGTH_LONG).show()
            }
        }
    }
}