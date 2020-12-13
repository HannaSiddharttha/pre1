package com.example.crazyquiz.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "selectedQuestions")

data class SelectedQuestion (
    @PrimaryKey(autoGenerate = true)
    var selectedQuestionId: Int,
    var answer : Int,
    var questionId: Int,

    var gameId : Int,
    var answer1: String = "",
    var answer2: String = "",
    var answer3: String = "",
    var answer4: String = "",
    var answer1Locked: Boolean = false,
    var answer2Locked: Boolean = false,
    var answer3Locked: Boolean = false,
    var answer4Locked: Boolean = false
)