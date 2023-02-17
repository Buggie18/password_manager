package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PasswordActivity : AppCompatActivity() {
    private lateinit var btnAddPassword: Button
    private lateinit var editWebsite: EditText
    private lateinit var editUserName: EditText
    private lateinit var editPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnAddPassword = findViewById(R.id.button3)
        editWebsite = findViewById(R.id.editText1)
        editUserName = findViewById(R.id.editText2)
        editPassword = findViewById(R.id.editText3)

        btnAddPassword.setOnClickListener {
            startActivity(
                Intent(this, SavedPasswordActivity::class.java)
                    .putExtra("Website", editWebsite.text.toString())
                    .putExtra("Username", editUserName.text.toString())
                    .putExtra("Password", editPassword.text.toString())
            )
        }

    }
}