package com.example.nbcamp_15ya_sns

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val linkTextView = findViewById<TextView>(R.id.de_bloglink_text)
        linkTextView.text =
            Html.fromHtml("<a href=\"https://velog.io/@ghj6068\">Visit our website</a>")
        linkTextView.movementMethod = LinkMovementMethod.getInstance()
        // 벨로그 주소 링크 연결
        val linkTextView2 = findViewById<TextView>(R.id.de_githublink_text)
        linkTextView2.text =
            Html.fromHtml("<a href=\"https://github.com/hosiker\">Visit our website</a>")
        linkTextView2.movementMethod = LinkMovementMethod.getInstance()
        // 깃허부 주소 링크 연결

        val contentTextView: TextView = findViewById(R.id.de_stateM)
        val toggleButton: Button = findViewById<Button>(R.id.de_toggle_button) // 접기/펼치기 토글 버튼

        var isExpanded = false // 초기에는 텍스트가 접혀있다고 가정

        toggleButton.setOnClickListener {
            if (isExpanded) {
                contentTextView.maxLines = 1
                contentTextView.ellipsize = TextUtils.TruncateAt.END
                toggleButton.text = "더보기"
            } else {
                contentTextView.maxLines = Int.MAX_VALUE
                contentTextView.ellipsize = null
                toggleButton.text = "접기"
            }
            isExpanded = !isExpanded
        }

        val friend by lazy { intent.getSerializableExtra("friend") as Friend } // friend 라는 객체를 가져와서 friend 변수에에 Friend 형식으로 배치

        val De_name = findViewById<TextView>(R.id.de_name)
        val De_mbti = findViewById<TextView>(R.id.de_mbti)
        val De_stateM = findViewById<TextView>(R.id.de_stateM)
        val De_giturl = findViewById<TextView>(R.id.de_githublink_text)
        val De_vlourl = findViewById<TextView>(R.id.de_bloglink_text)

        De_name.text = ("${friend.name}")
        De_mbti.text = ("MBTI는 ${friend.mbti}입니다!!")
        De_stateM.text = ("${friend.stateM}")
        De_giturl.text = ("${friend.gitURL}")
        De_vlourl.text = ("${friend.velURL}")
        //data 받아와서 설정하기


    }

    fun moveUserList(v: View) {
        val moveintent = Intent(this, UserListActivity::class.java)
        startActivity(moveintent)
    }

    fun moveHome(v: View) {
        val moveintent2 = Intent(this, MainActivity::class.java)
        startActivity(moveintent2)
    }

    fun moveMypage(v: View) {
        val moveintent3 = Intent(this, MyPageActivity::class.java)
        startActivity(moveintent3)
    }

}
