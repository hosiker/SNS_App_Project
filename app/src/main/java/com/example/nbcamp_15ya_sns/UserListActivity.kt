package com.example.nbcamp_15ya_sns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_list_activity)

        val friendListHosick = findViewById<ConstraintLayout>(R.id.friend_list1)
        val friendListGyujin = findViewById<ConstraintLayout>(R.id.friend_list2)
        val friendListSeungyoon = findViewById<ConstraintLayout>(R.id.friend_list3)
        val friendListJisung = findViewById<ConstraintLayout>(R.id.friend_list4)
        val friendListJaeyong = findViewById<ConstraintLayout>(R.id.friend_list5)

        toss(view = friendListHosick, friend = "hosick", friendInfo = friendManager.friendList[0])
        toss(view = friendListGyujin, friend = "gyujin", friendInfo = friendManager.friendList[1])
        toss(view = friendListSeungyoon, friend = "seingyoon", friendInfo = friendManager.friendList[2])
        toss(view = friendListJisung, friend = "jisung", friendInfo = friendManager.friendList[3])
        toss(view = friendListJaeyong, friend = "jaeyoung", friendInfo = friendManager.friendList[4])

        val homeBtn = findViewById<ConstraintLayout>(R.id.home_btn_list)
        val backBtn = findViewById<ImageView>(R.id.userlist_backButton)

        homeBtn.setOnClickListener{
            val toHome = Intent(this, MainActivity::class.java)
            startActivity(toHome)
        }
        backBtn.setOnClickListener{
            finish()
        }


    }
    fun toss(view:View,friend:String,friendInfo:Friend){

        view.setOnClickListener{

            val intent = Intent(this, DetailActivity::class.java)

            intent.putExtra(friend,friendInfo)
            startActivity(intent)

        }
    }


}