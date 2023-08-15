package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast


class SiginUpActivity : AppCompatActivity() {

    private val id: EditText by lazy { findViewById(R.id.id_ed) }
    private val psw: EditText by lazy { findViewById(R.id.password_ed) }
    private val name: EditText by lazy { findViewById(R.id.name_ed) }
    private val mbti: EditText by lazy { findViewById(R.id.mbti_ed) }
    private val stateM: EditText by lazy { findViewById(R.id.profile_ed) }

    private var nameCheck: Boolean = false

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
            nameCheck == false ->
                Toast.makeText(getApplicationContext(), "아이디 중복 체크를 해주세요!!", Toast.LENGTH_SHORT)
                    .show()

            checkEmpty(inputpsw) || checkEmpty(inputname) || checkEmpty(inputmbti)
            -> checkMessage(psw = inputpsw, name = inputname, mbti = inputmbti)

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

    fun finish(view: View) {
        finish()
    }

    fun checkMessage(psw: String, name: String, mbti: String) {

        when {
            checkEmpty(psw) -> toast("비밀번호를 확인해주세요")

            checkEmpty(name) -> toast("이름을 입력해주세요")

            checkEmpty(mbti) -> toast("mbti를 입력해주세요")

            checkEmpty(psw) && checkEmpty(name) -> toast("비밉번호와 이름을 입력해주세요")

            checkEmpty(psw) && checkEmpty(mbti) -> toast("비밉번호와 mbti를 입력해주세요")

            checkEmpty(mbti) && checkEmpty(name) -> toast("mbti와 이름을 입력해주세요")

            checkEmpty(psw) && checkEmpty(name) && checkEmpty(mbti) -> toast("공백을 확인해주세요 입력해주세요")

        }

    }

    fun toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun checkEmpty(id: String): Boolean {
        return id.trim().isEmpty()
    }

    fun isMBTI(mbti: String): Boolean {
        return mbti.matches(Regex("[EI][FT][JP]]"))
    }

    fun mbtiWatcher(view: View) {
        mbti.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }
}
