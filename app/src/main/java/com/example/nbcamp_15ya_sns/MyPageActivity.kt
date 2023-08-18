package com.example.nbcamp_15ya_sns

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import de.hdodenhof.circleimageview.CircleImageView


class MyPageActivity : AppCompatActivity() {
    private val userME = UserManager.user
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_page_activity)

        val nameText = findViewById<TextView>(R.id.my_name)
        val id = findViewById<TextView>(R.id.my_id)
        val stateM = findViewById<TextView>(R.id.my_stateM)
        val mbtiText = findViewById<TextView>(R.id.my_mbti)
        val faceImg = findViewById<CircleImageView>(R.id.my_photo)
        val twitImg = findViewById<CircleImageView>(R.id.my_twitPhoto_1)


        val getImg = UserManager.img


        nameText.text = "${userME?.name}"
        id.text = "@Id ${userME?.id}"
        stateM.text = "${userME?.stateM}"
        mbtiText.text = "MBTI는 ${userME?.mbti}입니다!!"


        faceImg.setImageResource(getImg)
        twitImg.setImageResource(getImg)

        val homeBtn = findViewById<ConstraintLayout>(R.id.home_btn_my)
        val friendBtn = findViewById<ConstraintLayout>(R.id.friend_constraintLayout_my)
        val backBtn = findViewById<ImageView>(R.id.my_backbutton)

        stateM.setOnClickListener{
            Dialog(getString(R.string.signin_stateM),stateM)
        }


        homeBtn.setOnClickListener {
            val goHome = Intent(this, MainActivity::class.java)
            startActivity(goHome)
        }

        friendBtn.setOnClickListener {
            val gofriend = Intent(this, UserListActivity::class.java)
            gofriend.putExtra("user", userME)
            startActivity(gofriend)
        }

        backBtn.setOnClickListener {
            finish()
        }

    }

    private fun Dialog(title: String, id: TextView) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_text_dialog, null)
        val input: EditText = dialogView.findViewById(R.id.costom_text_edit)

        builder.setTitle(title)
        builder.setView(dialogView)

        builder.setPositiveButton(getString(R.string.check)) { dialog, _ ->
            val inputText = input.text.trim().toString()

            if (inputText.isNotEmpty()) {
                id.text = inputText
                userME!!.stateM = id.text.toString()
            }

            dialog.dismiss()
        }

        builder.show()
    }



}
