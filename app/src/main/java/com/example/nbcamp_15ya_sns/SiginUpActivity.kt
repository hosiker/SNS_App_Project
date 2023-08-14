package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.view.View
import android.widget.EditText
import android.widget.Toast


class SiginUpActivity : AppCompatActivity() {

    private val id: EditText by lazy { findViewById(R.id.id_ed) }
    private val psw: EditText by lazy { findViewById(R.id.password_ed) }
    private val name: EditText by lazy { findViewById(R.id.name_ed) }
    private val mbti: EditText by lazy { findViewById(R.id.mbti_ed) }
    private val stateM: EditText by lazy { findViewById(R.id.profile_ed) }

    private var nameCheck : Boolean =false

    //지연초기화
    // 이 변수가 사용되는 시점에서 초기화가 된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sigin_up_activity)


    }

    fun doubleCheck(view: View) {
        if (userManager.userList.find { it.id == id.text.toString() } != null) {

            Toast.makeText(getApplicationContext(), "중복된 아이디 입니다!!", Toast.LENGTH_SHORT).show()
            nameCheck = false

        } else {
            Toast.makeText(getApplicationContext(), "사용가능한 아이디 입니다!!", Toast.LENGTH_SHORT).show()
            nameCheck = true
        }
    }

    fun signupButton(view: View) {

        val inputId = id.text.toString()
        val inputpsw = psw.text.toString()
        val inputname = name.text.toString()
        val inputmbti = mbti.text.toString()
        val inputstateM = stateM.text.toString()

        when {
            nameCheck == true ->
                Toast.makeText(getApplicationContext(), "아이디 중복 체크를 해주세요!!", Toast.LENGTH_SHORT)
                    .show()

            inputpsw.trim().isEmpty() ->
                Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요!!", Toast.LENGTH_SHORT).show()

            inputname.trim().isEmpty() ->
                Toast.makeText(getApplicationContext(), "이름을 입력해주세요!!", Toast.LENGTH_SHORT).show()

            inputmbti.trim().isEmpty() ->
                Toast.makeText(getApplicationContext(), "MBTI를 입력해주세요!!", Toast.LENGTH_SHORT).show()

            inputstateM.trim().isEmpty() ->
                Toast.makeText(getApplicationContext(), "소개글을 입력해주세요!!", Toast.LENGTH_SHORT).show()

            else -> {
                userManager.userList.add(
                    User(
                        id = inputId,
                        password = inputpsw,
                        name = inputname,
                        mbti = inputmbti,
                        stateM = inputstateM
                    )
                )
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }

    fun finish(view:View){
        finish()
    }


}