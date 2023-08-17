package com.example.nbcamp_15ya_sns

object friendManager {

    val friendList = mutableListOf<Friend>()

    init {
        friendList.add(Friend("이호식", "ENFP", "15조 바지사장입니다.","",""))
        friendList.add(Friend("송규진", "INTJ", "말이 항상 많습니다. 참을 수 없어요.","",""))
        friendList.add(Friend("박승윤", "INTJ", "분노조절잘해","",""))
        friendList.add(Friend("전지성", "INTJ", "INTJ 삼형제 입니다.","",""))
        friendList.add(Friend("장재용", "ISFP", "이런거 너무 어렵습니다.","",""))
    }
}