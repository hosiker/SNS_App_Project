package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    val user by lazy { intent.getSerializableExtra("user") as User }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        val tv_userName = findViewById<TextView>(R.id.tv_userName)
        val tv_stateMsg = findViewById<TextView>(R.id.tv_stateMsg)


        // 1. 로그인 Activity로부터 유저 객체  받아오기


        // 2. 받아온 유저 객체의 정보로 text 설정
        tv_userName.text = ("${user.name}")
        tv_stateMsg.text = ("${user.stateM}")

        val friend_constraintLayout = findViewById<ConstraintLayout>(R.id.friend_constraintLayout)
        friend_constraintLayout.setOnClickListener {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }

        // 3. 첫번째 더미 게시글 클릭시 화면 전환
        val constraintLayout3 = findViewById<ConstraintLayout>(R.id.main_constraintLayout3)
        constraintLayout3.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }


    }

    fun toMyPage(view: View) {

        val intent = Intent(this, MyPageActivity::class.java)
        val myimg = R.drawable.iu
        intent.putExtra("user", user)
        intent.putExtra("img",myimg)
        startActivity(intent)


    }
}