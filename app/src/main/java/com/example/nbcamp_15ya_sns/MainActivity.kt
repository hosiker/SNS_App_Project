package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        val tv_userName = findViewById<TextView>(R.id.tv_userName)
        val tv_stateMsg = findViewById<TextView>(R.id.tv_stateMsg)
        val myConstraintLayout = findViewById<ConstraintLayout>(R.id.myConstraintLayout)

        // 1. 로그인 Activity로부터 유저 객체  받아오기
        val user = intent.getSerializableExtra("user") as User

        // 2. 받아온 유저 객체의 정보로 text 설정
        tv_userName.text = ("${user.name}")
        tv_stateMsg.text = ("${user.stateM}")

        // 3. 내 정보 클릭 시 마이페이지로 전환 및 유저 객체 전달
        myConstraintLayout.setOnClickListener{

            val intent = Intent(this, MyPageActivity::class.java)
            intent.putExtra("user",user)
            Toast.makeText(this, "메인페이지 ${user.toString()}:", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}