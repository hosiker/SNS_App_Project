package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)



        // 1. 로그인 클릭시 메인화면 액티비티 전환
        val login = findViewById<TextView>(R.id.tv_login)
        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 2. 가입하기 클릭시 회원가입 액티비티 전환
        val register = findViewById<TextView>(R.id.tv_register)
        register.setOnClickListener {
            val intent = Intent(this, SiginUpActivity::class.java)
            startActivity(intent)
        }

        // TODO : 아이디와 비밀번호 값 있는지 체크 textwatcher?







        // TODO : 언어변경 기능 구현

    }

}