package com.example.nbcamp_15ya_sns

import java.io.Serializable

data class Friend(val name:String, val mbti:String, val stateM:String,
                  val gitURL : String,
                  val velURL : String
    ): Serializable
