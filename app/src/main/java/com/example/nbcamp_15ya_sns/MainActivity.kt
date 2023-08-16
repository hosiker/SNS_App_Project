package com.example.nbcamp_15ya_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // 1. 유저 객체 받아오기
        val user = intent.getSerializableExtra("user") as User

        val tv_userName = findViewById<TextView>(R.id.tv_userName)

        // 2. 받아온 유저 객체의 name으로 text 설정
        tv_userName.text = ("${user.name}")


        val tv_stateMsg = findViewById<TextView>(R.id.tv_stateMsg)
        tv_stateMsg.text = ("${user.stateM}")

    }
}