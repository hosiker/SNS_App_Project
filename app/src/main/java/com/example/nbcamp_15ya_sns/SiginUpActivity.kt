package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SiginUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sigin_up_activity)

        val id_ed = findViewById<EditText>(R.id.id_ed)
        val password_ed = findViewById<EditText>(R.id.password_ed)
        val name_ed = findViewById<EditText>(R.id.name_ed)
        val mbti_ed = findViewById<EditText>(R.id.mbti_ed)
        val profile_ed = findViewById<EditText>(R.id.profile_ed)

        val cancel_btn = findViewById<Button>(R.id.cancel_btn)
        val dublecheck_btn = findViewById<Button>(R.id.dublecheck_btn)
        val signup_btn = findViewById<Button>(R.id.signup_btn)

        cancel_btn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }      // 뒤로 가기 버튼

        signup_btn.setOnClickListener {
            when {
                id_ed.text.toString().trim().isEmpty() -> Toast.makeText(getApplicationContext(), "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
                password_ed.text.toString().trim().isEmpty() -> Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                name_ed.text.toString().trim().isEmpty() -> Toast.makeText(getApplicationContext(), "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
                mbti_ed.text.toString().trim().isEmpty() -> Toast.makeText(getApplicationContext(), "MBTI를 입력해주세요", Toast.LENGTH_SHORT).show()
                profile_ed.text.toString().trim().isEmpty() -> Toast.makeText(getApplicationContext(), "소개글을 입력해주세요", Toast.LENGTH_SHORT).show()

            }

        }



    }
}