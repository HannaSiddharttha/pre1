package com.example.crazyquiz

import android.graphics.Color

data class SelectedQuestion (var answer : Int, var question: Question, var answer1: Int, var answer2: Int, var answer3: Int, var answer4: Int,
                             var answer1Locked: Boolean = false, var answer2Locked: Boolean = false,
                             var answer3Locked: Boolean = false, var answer4Locked: Boolean = false) {

    fun isAnswered(): Boolean {
        return answer != null && answer > 0
    }

    fun isCorrect(): Boolean {

        return answer == question.Correcta
    }


}










