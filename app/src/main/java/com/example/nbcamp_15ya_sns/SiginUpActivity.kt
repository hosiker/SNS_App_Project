package com.example.nbcamp_15ya_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class SiginUpActivity : AppCompatActivity() {

    private val id: EditText by lazy {findViewById(R.id.id_ed)}
    private val psw: EditText by lazy {findViewById(R.id.password_ed)}
    private val name: EditText by lazy {findViewById(R.id.name_ed)}
    private val mbti: EditText by lazy {findViewById(R.id.mbti_ed)}
    private val stateM: EditText by lazy {findViewById(R.id.profile_ed)}
    //지연초기화
    // 이 변수가 사용되는 시점에서 초기화가 된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sigin_up_activity)
    }
}