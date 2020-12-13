package com.example.crazyquiz.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.crazyquiz.Question

@Entity(tableName = "selectedquestions")

data class SelectedQuestion (
    var answer : Int,
    var questionId: Int,

    var gameId : Int,
    var answer1: Int,
    var answer2: Int,
    var answer3: Int,
    var answer4: Int,
    var answer1Locked: Boolean,
    var answer2Locked: Boolean,
    var answer3Locked: Boolean,
    var answer4Locked: Boolean
)