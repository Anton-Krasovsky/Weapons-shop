package com.example.website

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin = findViewById<EditText>(R.id.user_login)
        val userEmail = findViewById<EditText>(R.id.user_email)
        val userPassword = findViewById<EditText>(R.id.user_password)
        val buttonReg = findViewById<Button>(R.id.button_reg)
        val textToAuth = findViewById<TextView>(R.id.authorization)

        textToAuth.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || email == "" || password == "") {
                Toast.makeText(this, "Not all fields are filled in", Toast.LENGTH_LONG).show()
            }
            else {
                val user = User(login, email, password)
                val db = Helper(this, null)
                db.addUser(user)
                Toast.makeText(this, "The user \"$login\" has been added", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }


        }

    }
}