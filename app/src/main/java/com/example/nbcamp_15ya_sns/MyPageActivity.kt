package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
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

        val homeBtn = findViewById<ConstraintLayout>(R.id.home_btn_my)
        val friendBtn = findViewById<ConstraintLayout>(R.id.friend_constraintLayout_my)
        val backBtn = findViewById<ImageView>(R.id.my_backbutton)

        homeBtn.setOnClickListener{
            val goHome = Intent(this,MainActivity::class.java)
            startActivity(goHome)
        }

        friendBtn.setOnClickListener{
            val gofriend = Intent(this,UserListActivity::class.java)
            startActivity(gofriend)
        }

        backBtn.setOnClickListener{
            finish()
        }

    }
}