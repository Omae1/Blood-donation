package com.wil.blooddonationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var forgot_pswd:EditText
    private lateinit var reset_btn:Button
    lateinit var back_btn:Button


    //creating auth firebase
    private lateinit var auth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)



        forgot_pswd=findViewById(R.id.resetemail)
        reset_btn=findViewById(R.id.btn_reset)
        back_btn=findViewById(R.id.btn_Back)

        //setting back button
        back_btn.setOnClickListener {
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        //init Firebase
        auth= FirebaseAuth.getInstance()



        reset_btn.setOnClickListener {
            reset_pass()
        }
    }

    private fun reset_pass() {
        val reset=forgot_pswd.text.toString()

        auth.sendPasswordResetEmail(reset)
            .addOnSuccessListener {
                Toast.makeText(this, "please check your email.", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()

            }
    }
}