package com.example.nbcamp_15ya_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_page_activity)

        val userME = intent.getSerializableExtra("user") as User
        val myIMG = intent.getSerializableExtra("img")



    }
}