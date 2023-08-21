package com.example.nbcamp_15ya_sns.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.nbcamp_15ya_sns.R
import com.example.nbcamp_15ya_sns.friend.Friend
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)


        val contentTextView: TextView = findViewById(R.id.de_stateM)
        val toggleButton: Button = findViewById<Button>(R.id.de_toggle_button) // 접기/펼치기 토글 버튼

        var isExpanded = false // 초기에는 텍스트가 접혀있다고 가정

        toggleButton.setOnClickListener {
            if (isExpanded) {
                contentTextView.maxLines = 1
                contentTextView.ellipsize = TextUtils.TruncateAt.END
                toggleButton.text = getString(R.string.de_more)
            } else {
                contentTextView.maxLines = Int.MAX_VALUE
                contentTextView.ellipsize = null
                toggleButton.text = getString(R.string.de_shorts)
            }
            isExpanded = !isExpanded
        }

        val Hosick = intent.getSerializableExtra("hosick") as? Friend
        val GyuJin = intent.getSerializableExtra("gyujin") as? Friend
        val seingyoon = intent.getSerializableExtra("seingyoon") as? Friend
        val jisung = intent.getSerializableExtra("jisung") as? Friend
        val jaeyoung = intent.getSerializableExtra("jaeyoung") as? Friend

        var name: Friend? = null
        var image : Int = 0

        val getImg1 = intent.getIntExtra("img1", 0)
        val getImg2 = intent.getIntExtra("img2", 0)
        val getImg3 = intent.getIntExtra("img3", 0)
        val getImg4 = intent.getIntExtra("img4", 0)
        val getImg5 = intent.getIntExtra("img5", 0)

        if(getImg1 !=0) image=getImg1
        if(getImg2 !=0) image=getImg2
        if(getImg3 !=0) image=getImg3
        if(getImg4 !=0) image=getImg4
        if(getImg5 !=0) image=getImg5

        if (Hosick != null) name = Hosick
        if (GyuJin != null) name = GyuJin
        if (seingyoon != null) name = seingyoon
        if (jisung != null) name = jisung
        if (jaeyoung != null) name = jaeyoung

        if (name != null && image !=0) {

            val linkTextView = findViewById<TextView>(R.id.de_bloglink_text)
            linkTextView.text =
                Html.fromHtml("<a href=\"${name.velURL}\">Visit our website</a>")
            linkTextView.movementMethod = LinkMovementMethod.getInstance()
            // 벨로그 주소 링크 연결
            val linkTextView2 = findViewById<TextView>(R.id.de_githublink_text)
            linkTextView2.text =
                Html.fromHtml("<a href=\"${name.gitURL}\">Visit our website</a>")
            linkTextView2.movementMethod = LinkMovementMethod.getInstance()
            // 깃허부 주소 링크 연결

            val De_name = findViewById<TextView>(R.id.de_name)
            val De_mbti = findViewById<TextView>(R.id.de_mbti)
            val De_stateM = findViewById<TextView>(R.id.de_stateM)
            val De_giturl = findViewById<TextView>(R.id.de_githublink_text)
            val De_vlourl = findViewById<TextView>(R.id.de_bloglink_text)
            val De_image = findViewById<CircleImageView>(R.id.de_photo)
            val De_twitPhoto_1 =findViewById<CircleImageView>(R.id.de_twitPhoto_1)
            val De_twitId_1 = findViewById<TextView>(R.id.de_twitId_1)

            De_name.text = ("${name.name}")
            De_mbti.text = ("MBTI는 ${name.mbti}입니다!!")
            De_stateM.text = ("${name.stateM}")
            De_giturl.text = ("${name.gitURL}")
            De_vlourl.text = ("${name.velURL}")
            De_image.setImageResource(image)
            De_twitPhoto_1.setImageResource(image)
            De_twitId_1.text = ("${name.name}")
            //data 받아와서 설정하기
        }


        val moveHome = findViewById<ImageView>(R.id.de_imageView4)
        val moveUserList = findViewById<ImageView>(R.id.de_imageView3)
        val moveMypage = findViewById<ImageView>(R.id.de_imageView5)
        val backBtn = findViewById<ImageView>(R.id.de_backbutton)

        backBtn.setOnClickListener{
            finish()
        }

        moveHome.setOnClickListener {
            val moverHome = Intent(this, MainActivity::class.java)
            startActivity(moverHome)
        }
        moveUserList.setOnClickListener {
            finish()
        }
        moveMypage.setOnClickListener {
            val moverMypage = Intent(this, MyPageActivity::class.java)
            startActivity(moverMypage)
        }

    }


}
