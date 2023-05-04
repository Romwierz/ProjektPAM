package com.example.pamprojcw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class RegistrationActivity : AppCompatActivity() {

    private lateinit var mUsername: EditText
    private lateinit var mPass: EditText
    private lateinit var btnReg: Button
    private lateinit var mSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        registration()

    }


    private fun registration() {
        mUsername = findViewById(R.id.username_reg)
        mPass = findViewById(R.id.password_reg)
        btnReg = findViewById(R.id.register_button)
        mSignIn = findViewById(R.id.already_have_account)


        btnReg.setOnClickListener{
            if( mUsername.text.isNullOrBlank() && mPass.text.isNullOrBlank() ) {

                Toast.makeText(this,"Required fields must be filled", Toast.LENGTH_SHORT).show()

            }

            else if(!mUsername.text.isNullOrBlank() && !mPass.text.isNullOrBlank()) {
                Toast.makeText(this,"${mUsername.text}, you've registered!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                val user = User(mUsername.text.toString(), mPass.text.toString())

                intent.putExtra("username", user.getUsername())
                intent.putExtra("password", user.getPassword())
                startActivity(intent)
            }

        }

        //when you already have an account
        mSignIn.setOnClickListener {




                startActivity(Intent(this,MainActivity::class.java))

        }
    }




}