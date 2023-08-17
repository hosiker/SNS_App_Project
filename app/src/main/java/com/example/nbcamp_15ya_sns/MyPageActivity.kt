package com.example.nbcamp_15ya_sns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView


class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_page_activity)

        val userME = intent.getSerializableExtra("user") as User
        val getImg = intent.getIntExtra("img", 0)

        val nameText = findViewById<TextView>(R.id.my_name)
        val id = findViewById<TextView>(R.id.my_id)
        val stateM = findViewById<TextView>(R.id.my_stateM)
        val mbtiText = findViewById<TextView>(R.id.my_mbti)
        val faceImg = findViewById<CircleImageView>(R.id.my_photo)
        val twitImg = findViewById<CircleImageView>(R.id.my_twitPhoto_1)


        nameText.text = "${userME.name}"
        id.text = "$@Id ${userME.id}"
        stateM.text = "${userME.stateM}"
        mbtiText.text = "MBTI는 ${userME.mbti}입니다!!"


        faceImg.setImageResource(getImg)
        twitImg.setImageResource(getImg)

    }
}