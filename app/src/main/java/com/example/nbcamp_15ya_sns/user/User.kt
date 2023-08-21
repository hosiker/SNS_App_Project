package com.example.nbcamp_15ya_sns.user

import java.io.Serializable

data class User(
    val id: String,
    val password: String,
    val name: String,
    val mbti: String,
    var stateM: String
) : Serializable