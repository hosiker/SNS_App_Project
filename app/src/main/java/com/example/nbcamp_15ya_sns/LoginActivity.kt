package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.nbcamp_15ya_sns.userManager.userList

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

       userList.add(User("hi","test","test","test","test"))

        // 1. 로그인 클릭시 메인화면 액티비티 전환 (
        val login = findViewById<TextView>(R.id.tv_login)

        login.setOnClickListener {
            val et_id = findViewById<EditText>(R.id.et_id)
            val et_pwd = findViewById<EditText>(R.id.et_pwd)
            val strId = et_id.text.toString()
            val strPwd = et_pwd.text.toString()

            if (strId.isNotEmpty() && strPwd.isNotEmpty()) {
                val user = userList.find { it.id == strId && it.password == strPwd }
                val userInfoTest = user.toString()
                if (user != null) {
                    val intent = Intent(this, MainActivity::class.java)

                    intent.putExtra("user",user)

                    Toast.makeText(this,"${user.name}님 반갑습니다", Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "존재하지 않는 계정입니다. \n입력하신 내용을 다시 확인해주세요.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "아이디/비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. 가입하기 클릭시 회원가입 액티비티 전환
        val register = findViewById<TextView>(R.id.tv_register)

        register.setOnClickListener {
            val intent = Intent(this, SiginUpActivity::class.java)
            startActivity(intent)
        }
        // TODO : 언어변경 기능 구현
    }
}

