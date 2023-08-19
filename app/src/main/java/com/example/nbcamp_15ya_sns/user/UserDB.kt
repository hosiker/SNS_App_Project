package com.example.nbcamp_15ya_sns.user

object UserDB {

    var userList = mutableListOf<User>()

    init {
        userList.add(User("test","test","test","test","Good Morning!"))
    }

}