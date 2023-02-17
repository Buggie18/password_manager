package com.example.loginscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var b1: Button? = null
    private var b2: Button? = null
    private var ed1: EditText? = null
    private var ed2: EditText? = null
    private var tx1: TextView? = null
    private var counter = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1 = findViewById<View>(R.id.button1) as Button
        ed1 = findViewById<View>(R.id.editText1) as EditText
        ed2 = findViewById<View>(R.id.editText2) as EditText
        b2 = findViewById<View>(R.id.button2) as Button
        tx1 = findViewById<View>(R.id.textView2) as TextView
        tx1!!.visibility = View.VISIBLE
        b1!!.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(b1!!.windowToken, 0)
            if (ed1!!.text.toString() == "test@admin.com" && ed2!!.text.toString() == "12345678") {
                Toast.makeText(applicationContext, "Logging In", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SavedPasswordActivity::class.java)
                    startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Please Try Again", Toast.LENGTH_SHORT).show()
                tx1!!.visibility = View.VISIBLE
                counter--
                tx1!!.text = counter.toString()
                if (counter == 0) {
                    b1!!.isEnabled = false
                }
            }
        }
        b2!!.setOnClickListener { finish() }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}