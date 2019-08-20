package com.mxy.krd.model

/**
 * Created by Mengxy on 2019-08-19.
 */

data class AnswerResponse(
    val answer: String,
    val forced: Boolean,
    val image: String
)