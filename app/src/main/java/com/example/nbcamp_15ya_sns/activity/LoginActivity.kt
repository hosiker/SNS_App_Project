package com.example.nbcamp_15ya_sns.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.nbcamp_15ya_sns.R
import com.example.nbcamp_15ya_sns.user.User
import com.example.nbcamp_15ya_sns.user.UserDB.userList
import com.example.nbcamp_15ya_sns.user.UserManager

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

                    UserManager.user = user

                    Toast.makeText(this, getString(R.string.welcome, user.name), Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                    overridePendingTransition(R.anim.fade_in, 0)

                } else {
                    Toast.makeText(this, getString(R.string.Not_exist), Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, getString(R.string.enter_id_pwd), Toast.LENGTH_SHORT).show()
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

