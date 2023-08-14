package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.widget.EditText
import android.widget.Toast


class SiginUpActivity : AppCompatActivity() {

    private val id: EditText by lazy { findViewById(R.id.id_ed) }
    private val psw: EditText by lazy { findViewById(R.id.password_ed) }
    private val name: EditText by lazy { findViewById(R.id.name_ed) }
    private val mbti: EditText by lazy { findViewById(R.id.mbti_ed) }
    private val stateM: EditText by lazy { findViewById(R.id.profile_ed) }

    //지연초기화
    // 이 변수가 사용되는 시점에서 초기화가 된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sigin_up_activity)


    }

    fun doubleCheck() {
        if (userManager.userList.find { it.id == id.text.toString() } != null) {
            Toast.makeText(getApplicationContext(), "중복된 아이디 입니다!!", Toast.LENGTH_SHORT).show()

        } else Toast.makeText(getApplicationContext(), "사용가능한 아이디 입니다!!", Toast.LENGTH_SHORT).show()
    }

    fun signupButton() {
        when {
            userManager.userList.find { it.id == id.text.toString() } != null ->
                Toast.makeText(getApplicationContext(), "아이디 중복 체크를 해주세요!!", Toast.LENGTH_SHORT)
                    .show()

            psw.text.toString().trim().isEmpty() ->
                Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요!!", Toast.LENGTH_SHORT).show()

            name.text.toString().trim().isEmpty() ->
                Toast.makeText(getApplicationContext(), "이름을 입력해주세요!!", Toast.LENGTH_SHORT).show()

            mbti.text.toString().trim().isEmpty() ->
                Toast.makeText(getApplicationContext(), "MBTI를 입력해주세요!!", Toast.LENGTH_SHORT).show()

            stateM.text.toString().trim().isEmpty() ->
                Toast.makeText(getApplicationContext(), "소개글을 입력해주세요!!", Toast.LENGTH_SHORT).show()


        }
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


}