package com.example.nbcamp_15ya_sns

object friendManager {

    val friendList = mutableListOf<Friend>()

    init {
        friendList.add(Friend("ho","이호식", "ENFP", "15조 바지사장입니다.","http://github.com/hosiker","http://velog.io/@ghj6068"))
        friendList.add(Friend("gy","송규진", "INTJ", "말이 항상 많습니다. 참을 수 없어요.","https://github.com/S4U2M","https://clockstillticktockticktock.tistory.com/"))
        friendList.add(Friend("so","박승윤", "INTJ", "분노조절잘해","","https://velog.io/@syoon0904"))
        friendList.add(Friend("js","전지성", "INTJ", "INTJ 삼형제 입니다.","https://github.com/PMETNT","https://velog.io/@pmet"))
        friendList.add(Friend("jo","장재용", "ISFP", "이런거 너무 어렵습니다.","https://github.com/choco5732","https://velog.io/@choco5732"))
    }
}