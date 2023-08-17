package com.example.nbcamp_15ya_sns

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val linkTextView = findViewById<TextView>(R.id.de_bloglink_text)
        linkTextView.text = Html.fromHtml("<a href=\"https://velog.io/@ghj6068\">Visit our website</a>")
        linkTextView.movementMethod = LinkMovementMethod.getInstance()
        // 벨로그 주소 링크 연결
        val linkTextView2 = findViewById<TextView>(R.id.de_githublink_text)
        linkTextView2.text = Html.fromHtml("<a href=\"https://github.com/hosiker\">Visit our website</a>")
        linkTextView2.movementMethod = LinkMovementMethod.getInstance()
        // 깃허부 주소 링크 연결

        val contentTextView: TextView = findViewById(R.id.de_stateM)
        val toggleButton: Button = findViewById<Button>(R.id.de_toggle_button) // 접기/펼치기 토글 버튼

        var isExpanded = false // 초기에는 텍스트가 접혀있다고 가정

        toggleButton.setOnClickListener {
            if (isExpanded) {
                contentTextView.maxLines = 3
                contentTextView.ellipsize = TextUtils.TruncateAt.END
                toggleButton.text = "더보기"
            } else {
                contentTextView.maxLines = Int.MAX_VALUE
                contentTextView.ellipsize = null
                toggleButton.text = "접기"
            }
            isExpanded = !isExpanded
        }

    }



}
