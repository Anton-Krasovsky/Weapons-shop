package com.example.website

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val userLogin = findViewById<EditText>(R.id.user_login_auth)
        val userPassword = findViewById<EditText>(R.id.user_password_auth)
        val buttonReg = findViewById<Button>(R.id.button_reg_auth)
        val textToReg = findViewById<TextView>(R.id.text_to_reg)


        textToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || password == "") {
                Toast.makeText(
                    this, "Not all fields are filled in",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val db = Helper(this, null)
                val isAuth = db.getUser(login, password)

                if (isAuth) {
                    Toast.makeText(
                        this, "The user \"$login\" is authorized",
                        Toast.LENGTH_LONG
                    ).show()
                    userLogin.text.clear()
                    userPassword.text.clear()
                    startActivity(Intent(this, ItemActivity::class.java))


                } else
                    Toast.makeText(
                        this, "The user \"$login\" was not found",
                        Toast.LENGTH_LONG).show()
            }
        }
    }
}
