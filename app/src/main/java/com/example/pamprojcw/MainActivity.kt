package com.example.pamprojcw

import android.content.Intent
import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {

    private lateinit var mUsername: EditText
    private lateinit var mPass: EditText
    private lateinit var btnLogin: Button
    private lateinit var mForgetPassword: TextView
    private lateinit var mSignUpHere : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mUsername = findViewById(R.id.username_login)
        mPass = findViewById(R.id.password_login)
        btnLogin = findViewById(R.id.btn_login)
        mForgetPassword = findViewById(R.id.forgot_password)
        mSignUpHere = findViewById(R.id.signup_reg)

        //login button functionality
        btnLogin.setOnClickListener{

            if( mUsername.text.isNullOrBlank() && mPass.text.isNullOrBlank() ) {

                Toast.makeText(this,"Required fields must be filled", Toast.LENGTH_SHORT).show()

            }

            else if(!mUsername.text.isNullOrBlank() && !mPass.text.isNullOrBlank()) {
                Toast.makeText(this,"${mUsername.text}, you're logged in!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                val user = User(mUsername.text.toString(), mPass.text.toString())

                intent.putExtra("username", user.getUsername())
                intent.putExtra("password", user.getPassword())
                startActivity(intent)
            }
        }
        //registration
        mSignUpHere.setOnClickListener {
            startActivity(Intent(this,RegistrationActivity::class.java))

        }
        //when you forgot your password
        mForgetPassword.setOnClickListener {

            startActivity(Intent(this,ResetActivity::class.java))
        }





    }





}