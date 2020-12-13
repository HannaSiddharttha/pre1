package com.example.crazyquiz.db

import com.example.crazyquiz.Question

data class SelectedQuestion (
    var answer : Int,
    var question: Question,
    var answer1: Int,
    var answer2: Int,
    var answer3: Int,
    var answer4: Int,
    var answer1Locked: Boolean,
    var answer2Locked: Boolean,
    var answer3Locked: Boolean,
    var answer4Locked: Boolean
)