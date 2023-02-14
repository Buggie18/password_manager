package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.loginscreen.view.UserAdapter
import com.example.loginscreen.model.UserData


class SavedPasswordActivity : AppCompatActivity() {
    private lateinit var addsBtn: FloatingActionButton
    private lateinit var recv: RecyclerView
    private lateinit var userList: ArrayList<UserData>
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_password)
        userList = ArrayList()
        recv = findViewById(R.id.mRecycler)
        userAdapter = UserAdapter(this,userList)
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter
        addsBtn = findViewById(R.id.addingBtn)

        addsBtn.setOnClickListener {
            val intent = Intent(this, PasswordActivity::class.java)
            startActivity(intent)
        }

        val website = intent.getStringExtra("Website")
        val userName = intent.getStringExtra("Username")
        val password = intent.getStringExtra("Password")

        if (website != null) {
            userList.add(
                UserData(
                    "Website: $website", "Username: $userName",
                    "Password: $password"
                )
            )
            userAdapter.notifyItemInserted(userList.size)
            Toast.makeText(this, "Added new password successfully", Toast.LENGTH_SHORT).show()
        }
    }
        }


