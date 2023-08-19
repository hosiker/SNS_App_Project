package com.example.nbcamp_15ya_sns.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.nbcamp_15ya_sns.R
import com.example.nbcamp_15ya_sns.user.UserManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)


        val tv_userName = findViewById<TextView>(R.id.tv_userName)
        val tv_stateMsg = findViewById<TextView>(R.id.tv_stateMsg)


        val user = UserManager.user
        // 1. 로그인 Activity로부터 유저 객체  받아오기


        // 2. 받아온 유저 객체의 정보로 text 설정
        tv_userName.text = ("${user?.name}")
        tv_stateMsg.text = ("${user?.stateM}")

        val friend_constraintLayout = findViewById<ConstraintLayout>(R.id.friend_constraintLayout)
        friend_constraintLayout.setOnClickListener {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }

        // 3. 첫번째 더미 게시글 클릭시 화면 전환
        val constraintLayout3 = findViewById<ConstraintLayout>(R.id.main_twit1_constraintLayout)
        constraintLayout3.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }


    }

    fun toMyPage(view: View) {

        val intent = Intent(this, MyPageActivity::class.java)

        startActivity(intent)


    }
}